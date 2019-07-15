package ru.job4j.javaio;

public class ArgsFinder {
    private String[] args;
    private String key;

    public ArgsFinder(String[] args) {
        this.args = args;
    }

    public String directory() {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                result = args[i + 1];
                break;
            }
        }
        return result;
    }

    public String typeFind() {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                result = args[i + 1];
                break;
            } else if (args[i].equals("-m")) {
                result = args[i + 1];
                break;
            }
        }
        return result;
    }

    public String output() {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-o")) {
                result = args[i + 1];
                break;
            }
        }
        return result;

    }

    public String getName() {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-n")) {
                result = args[i + 1];
                break;
            }
        }
        return result;

    }

    public String gettype() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                key = "-f";
                break;
            } else if (args[i].equals("-m")) {
                key = "-m";
                break;
            }
        }
        return key;
    }
}
