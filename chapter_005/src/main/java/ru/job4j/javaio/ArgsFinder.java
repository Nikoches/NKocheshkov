package ru.job4j.javaio;

import java.util.HashMap;

public class ArgsFinder {
    private String[] args;
    private String key;
    private HashMap<String, String> map;

    public ArgsFinder(String[] args) throws Exception {

        this.args = args;
        this.directory();
        this.output();
        this.typeFind();
        this.getName();
    }

    public void directory() throws Exception {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                result = args[i + 1];
                break;
            }
        }
        if(result.equals("")) throw new Exception("null flag");
        map.put("-d", result);
    }

    public void typeFind() throws Exception {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                result = args[i + 1];
                map.put("-f", result);
                break;
            } else if (args[i].equals("-m")) {
                result = args[i + 1];
                map.put("-m", result);
                break;
            }
        }
        if(result.equals("")) throw new Exception("null flag");
    }

    public void output() throws Exception {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                result = args[i + 1];
                break;
            }
        }
        if(result.equals("")) throw new Exception("null flag");
        map.put("-o", result);
    }

    public void getName() throws Exception {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-n")) {
                result = args[i + 1];
                break;
            }
        }
        if(result.equals("")) throw new Exception("null flag");
        map.put("-n", result);

    }

    public String gettype() throws Exception {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                key = "-f";
                break;
            } else if (args[i].equals("-m")) {
                key = "-m";
                break;
            }
        }
        if(key.equals(null)) throw new Exception("null flag");
        return key;
    }

    public String getKey(String ax) {
        return map.getOrDefault(ax, "null");
    }
}
