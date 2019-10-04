package ru.job4j.AbstractCache;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;

public class Cache {
    private LinkedList<Node> listCache = new LinkedList();
    private final String path = "C:\\Projects\\chapter_005\\src\\main\\resources\\cache\\";
    public LinkedList<Node> getListCache() {
        return listCache;
    }

    public String getElement(String key) {
            for (Node x : listCache) {
                if (x.getKey().equals(key)) {
                    return x.getText();
                }
            }
            load(key);
        return getElement(key);
    }

    private void load(String key) {
        try {
            this.listCache.add(new Node(Files.readString(Paths.get(path + "pp.txt")), key));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private class Node {
        private String text;
        private String key;

        public Node(String text, String key) {
            this.text = text;
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public String getKey() {
            return key;
        }
    }

}
