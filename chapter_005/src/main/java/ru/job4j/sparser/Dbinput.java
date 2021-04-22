package ru.job4j.sparser;

import org.quartz.JobDetail;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Set;

import static org.quartz.JobBuilder.newJob;

public class Dbinput {
    private Connection connection;

    public Dbinput() {
        this.init();
    }

    public boolean init() {
        try (InputStream in = SqlParser.class.getClassLoader().getResourceAsStream("sql_parser/app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            Statement st = connection.createStatement();
            st.execute(" create table if not exists vacancy(id serial primary key,name text NOT NULL UNIQUE,description text,link text,created text);");
            st.close();
            JobDetail job = newJob(SqlParser.class)
                    .withIdentity("myJob", "group1")
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    public void input(Set<Vacancy> vacancySet) {
        String sqlc = ("insert into vacancy(name,description,link,created) values(?, ?, ?, ?)");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc)) {
            for (Vacancy i : vacancySet) {
                preparedStatement.setString(1, i.getName());
                preparedStatement.setString(2, i.getDescription());
                preparedStatement.setString(3, i.getUrl());
                preparedStatement.setString(4, i.getDate());
                preparedStatement.execute();
            }
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    public String getLastDate() {
        String sqlc = (" select * from vacancy ORDER BY id limit 1;");
        String lastdate = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlc); ResultSet resultSet = preparedStatement.executeQuery()) {
            lastdate = resultSet.getString("created");

        } catch (Exception x) {
            x.printStackTrace();
        }
        return lastdate;
    }

}
