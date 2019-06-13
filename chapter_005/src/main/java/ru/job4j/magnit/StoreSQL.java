package ru.job4j.magnit;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
    }

    public boolean createNewDatabase(String namedb) {
        Config config = new Config();
        try {
            System.out.println(config.get("url") + namedb);
            connect = DriverManager.getConnection(config.get("url") + namedb + ".db");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect != null;
    }

    public void generate(int size) {
        String sql = "CREATE TABLE IF NOT EXISTS entry(field INTEGER);";
        String sqlq = "INSERT INTO entry (field) VALUES(?);";
        try(PreparedStatement preparedStatement = connect.prepareStatement(sql); PreparedStatement preparedStatement1 = connect.prepareStatement(sqlq)) {
            preparedStatement.execute();
            for (int i = 1; i < size; i++){
                preparedStatement1.setInt(1,i);
                preparedStatement1.execute();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Map.Entry> load() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void close() throws Exception {

    }

    public static void main(String[] args) {
      Config cfg = new Config();
      StoreSQL ss = new StoreSQL(cfg);
      ss.createNewDatabase("name");
      ss.generate(5);
    }
}
