package ServletExample.Logic;

import ServletExample.Model.User;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicInteger;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();
    private volatile AtomicInteger counterId = new AtomicInteger(1);
    private Connection connection;

    public DbStore() {
        setConnection();
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }

    private void setConnection() {
        try (InputStream in = DbStore.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            SOURCE.setDriverClassName(config.getProperty("connection.driver_class"));
            SOURCE.setUrl(config.getProperty("connection.url"));
            SOURCE.setUsername(config.getProperty("connection.username"));
            SOURCE.setPassword(config.getProperty("connection.password"));
            connection = SOURCE.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean add(User user) {
        user.setId(getCounterId());
        String sqlc = ("insert into users (id, name, login, email, creation_date,imageName,id_role,password) values (?,?,?,?,?,?,?,?);");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getLogin());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setDate(5, Date.valueOf(user.getCreateDate()));
            preparedStatement.setString(6,user.getImageName());
            preparedStatement.setInt(7,user.getRoleId());
            preparedStatement.setString(8,user.getPassword());
            preparedStatement.execute();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(User user, String id) {
        if (!existUser(id)) {
            return false;
        }
        String sqlc = "update users  SET login = ?, email = ?, name = ? where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getLogin());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, Integer.parseInt(id));
            preparedStatement.execute();
        } catch (Exception x) {
            x.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        if (!existUser(id) & id != null) {
            return false;
        }
            String sqlc = "delete from  users  where id = ?;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
                preparedStatement.setInt(1, Integer.parseInt(id));
                preparedStatement.execute();
            } catch (Exception x) {
                x.printStackTrace();
        }
        return true;
    }

    @Override
    public List<User> findlAll() {
        List<User> userList = new ArrayList<>();
        String sqlc = "select * from users order by id;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc); ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
                user.setId(resultSet.getInt(1));
                user.setImageName(resultSet.getString(6));
                user.setRoleId(resultSet.getInt(7));
                userList.add(user);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }

        return userList;
    }

    @Override
    public User findById(String id) {
        User user = null;
        if (!existUser(id)) {
            return user;
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement(" select * from users where id=?;")) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new User(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5));
            user.setId(resultSet.getInt(1));
            user.setImageName(resultSet.getString(6));
            user.setRoleId(resultSet.getInt(7));
        } catch (Exception x) {
            x.printStackTrace();
        }
        return user;
    }

    @Override
    public void removeAll() {
        try (PreparedStatement preparedStatement = connection.prepareStatement("TRUNCATE users;")) {
            preparedStatement.execute();
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    @Override
    public int getCounterId() {
        return counterId.getAndIncrement();
    }

    private boolean existUser(String id) {
        String request = "select * from users where id=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return false;
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
        return true;
    }
    public int getCredentials(String login, String pwd) {
        String request = "select * from users where login=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(request)) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()&&resultSet.getString(8).equals(pwd)) {
                  return resultSet.getInt(7);
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
        return 0;
    }

}
