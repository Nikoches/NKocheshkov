package ru.job4j.magnit;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties values = new Properties();
    public Config(){
        this.init();
    }
    public void init() {
        try (InputStream in = Config.class.getClassLoader().getResourceAsStream("sql_config/app.properties")) {
            values.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public String get(String key) {
        return this.values.getProperty(key);
    }
}