package ru.job4j.tracker;

import java.io.Closeable;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {

    private Connection connection;
    private int iditem = 0;

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
            st.execute(" create table if not exists items(id integer primary key,name text,description text,created integer);");
            st.close();

        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.connection != null;

    }

    @Override
    public Item add(Item item) {
        try {
            Statement st = connection.createStatement();
            item.setId("" + iditem++);
            int rs = st.executeUpdate("insert into items values( " + item.getId() + " ,'" + item.getName() + "','" + item.getDescription() + "'," + item.getCreate() + "); ");
            System.out.println("количество добавленных строк = " + rs);
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void replace(String id, Item item) {
        try {
            item.setId("" + iditem++);
            Statement st = connection.createStatement();
            st.execute("UPDATE items SET id = " + item.getId() + ",name=" + item.getName() + ",description=" + item.getDescription() + ",created=" + item.getCreate() + " WHERE id =" + id + ";");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(String id) {
        try {
            Statement st = connection.createStatement();
            st.execute("delete from items where id = " + id + ";");
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        LinkedList<Item> list = new LinkedList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("select * from items;");
            while (resultSet.next()) {
                list.add(new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getLong("created")));
                System.out.println(resultSet.getString("id") + "  " + resultSet.getString("name"));
            }
            st.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Item> findByName(String key) {
        LinkedList<Item> list = new LinkedList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("select * from items where name = " + key + ";");
            while (resultSet.next()) {
                list.add(new Item(resultSet.getString("name"), resultSet.getString("description"), resultSet.getLong("created")));
            }
            st.close();
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("select * from items where id = " + id + ";");
            item = new Item(resultSet.getString("name"),resultSet.getString("description"),resultSet.getLong("created"));
            st.close();
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
