package ru.job4j.javaio;

import java.util.HashMap;

public class ArgsFinder {
    private HashMap<String, String> map;
    public ArgsFinder(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                map.put("-d", args[i + 1]);
            } else if (args[i].equals("-f")) {
                map.put("-f", args[i + 1]);
            } else if (args[i].equals("-m")) {
                map.put("-m", args[i + 1]);
            } else if (args[i].equals("-o")) {
                map.put("-o", args[i + 1]);
            } else if (args[i].equals("-n")) {
                map.put("-n", args[i + 1]);
            }
        }
    }

    public String getKey(String ax) {
        return map.getOrDefault(ax, "null");
    }
}
