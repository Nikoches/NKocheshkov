package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;

    public TrackerSQL(Connection connection) {
        this.connection = connection;
       // this.init();
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            Statement st = connection.createStatement();
            st.execute(" create table if not exists items(id serial primary key,name text,description text,created integer);");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        return this.connection != null;

    }

    @Override
    public Item add(Item item) {
        String sqlc = ("insert into items(name,description,created) values(?,?,?); ");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getDescription());
            preparedStatement.setLong(3, item.getCreate());
            int rs = preparedStatement.executeUpdate();
            System.out.println("количество добавленных строк = " + rs);
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if(generatedKeys.next()){
                item.setId(String.valueOf(generatedKeys.getInt(1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void replace(String id, Item item) {
        String sqlc = ("update items set id = ?,name = ?,description = ?,created = ? where id = ?;");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            preparedStatement.setInt(1, Integer.parseInt(item.getId()));
            preparedStatement.setString(2, item.getName());
            preparedStatement.setString(3, item.getDescription());
            preparedStatement.setLong(4, item.getCreate());
            preparedStatement.setInt(5, Integer.parseInt(id));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(String id) {
        String sqlc = ("delete from items where id = ? ;");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        LinkedList<Item> list = new LinkedList<>();
        String sqlc = ("select * from items;");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                list.add(new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getLong("created")));
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        LinkedList<Item> list = new LinkedList<>();
        String sqlc = ("select * from items where name = ?;");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            preparedStatement.setString(1, key);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getLong("created")));
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        String sqlc = ("select * from items where id = ?");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                item = new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getLong("created"));
                item.setId(resultSet.getString("id"));
                System.out.println(item.getId() + "    " + item.getName() + "  " + item.getDescription() + "    " + item.getCreate());
            }
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;
    }


    @Override
    public void close() throws Exception {
        this.connection.close();
    }
}
