package ru.job4j.abstractcache;

import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Cache {
    private final String path = "C:\\Projects\\chapter_005\\src\\main\\resources\\cache\\";
    private final HashMap<String, SoftReference<String>> cacheMap = new HashMap<>();

    public HashMap getListCache() {
        return cacheMap;
    }

    public String getElement(String key) {
        if (cacheMap.containsKey(key)) {
            if (cacheMap.get(key) != null) {
                return cacheMap.get(key).get();
            } else {
                load(key);
            }
        } else {
            load(key);
        }
        return getElement(key);
    }

    private void load(String key) {
        try {
            this.cacheMap.put(key, new SoftReference<>(Files.readString(Paths.get(path + key))));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
