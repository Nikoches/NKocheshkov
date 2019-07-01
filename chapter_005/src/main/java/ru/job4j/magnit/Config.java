package ru.job4j.magnit;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();
    private String path;
    public Config(String path) {
        this.path = path;
        this.init(path);
    }

    public void init(String path) {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream(path)) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}