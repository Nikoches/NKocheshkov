package ru.job4j.tracker;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSQLTest {
    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            Item it = tracker.add(new Item("name", "desc", 12));
            System.out.println("NEW ITEM\n" + it);
            assertThat(tracker.findByName("name").size(), is(1));
            System.out.println(tracker.findByName("name").size());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void removeItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc", 12));
            tracker.deleteItem("1");
            assertThat(tracker.findByName("name").size(), is(0));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void replaceItem() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name", "desc", 12));
            Item ss = new Item("aaa", "bbb", 1488);
            ss.setId("12");
            tracker.replace("1", ss);
            assertThat(tracker.findById("12").getName(), is("aaa"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findAll() throws SQLException {
        try (TrackerSQL tracker = new TrackerSQL(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("aaa", "bbb", 1222));
            tracker.add(new Item("ccc", "ddd", 1488));
            LinkedList<Item> list = new LinkedList<>();
            Item ss = new Item("aaa", "bbb", 1222);
            Item ss1 = new Item("ccc", "ddd", 1488);
            list.add(ss);
            list.add(ss1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}