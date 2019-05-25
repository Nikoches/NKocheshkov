package ru.job4j.javaio;

import javax.imageio.IIOException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public static void main(String[] args) {
        Config ss = new Config("app.properties");
        ss.load();
        System.out.println(ss.value("hibernate.connection.username"));
    }

    public void load() {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String s;
            while ((s = br.readLine()) != null) {
                if (s.contains("=")) {
                    values.put(s.split("=")[0], s.split("=")[1]);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}