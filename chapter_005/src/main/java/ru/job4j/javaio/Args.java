package ru.job4j.javaio;

public class Args {
    private String[] args;

    public Args(String[] args) {
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

    public String exclude() {
        String result = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-e")) {
                result = args[i + 1];
                break;
            }
        }
        return result;
    }

}
