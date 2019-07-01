package ru.job4j.magnit;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;

    public StoreSQL(Config config) {
        this.config = config;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        Config cfg = new Config("sql_config/app.properties");
        StoreSQL ss = new StoreSQL(cfg);
        System.out.println(ss.createNewDatabase("mydb"));
        ss.generate(5);
        StoreXML storeXML = new StoreXML(new File("file.xml"));
        storeXML.convertObjectToXml(ss.load());
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        SaxParsing saxp = new SaxParsing();
        parser.parse(storeXML.convertObjectToXml(ss.load()), saxp);
    }

    public boolean createNewDatabase(String namedb) {
        try {
            System.out.println(config.get("url") + namedb);
            connect = DriverManager.getConnection(config.get("url") + namedb + ".db");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connect != null;
    }

    public void generate(int size) {
        String sql = "CREATE TABLE IF NOT EXISTS entry (field INTEGER);";
        String sql1 = "select * from entry;";
        String sql2 = "delete from entry";
        String sql3 = "INSERT INTO entry (field) VALUES(?);";
        try {
            Statement statement1 = connect.createStatement();
            statement1.execute(sql);
            Statement statement2 = connect.createStatement();
            ResultSet set = statement2.executeQuery(sql1);
            // Удаление строк если есть
            if (set.next()) {
                Statement statement3 = connect.createStatement();
                statement3.execute(sql2);
                statement3.close();
            }
            connect.setAutoCommit(false);
            PreparedStatement pst = connect.prepareStatement(sql3);
            for (int i = 1; i < size; i++) {
                pst.setInt(1, i);
                pst.addBatch();
            }
            int[] count = pst.executeBatch();
            connect.commit();
            statement1.close();
            statement2.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Entry> load() {
        List<Entry> list = new LinkedList<>();
        String sql = "select * from entry;";
        try {
            Statement statement1 = connect.createStatement();
            ResultSet resultSet = statement1.executeQuery(sql);
            while (resultSet.next()) {
                list.add(new Entry(resultSet.getInt("field")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void close() throws Exception {
        this.connect.close();
    }

}
