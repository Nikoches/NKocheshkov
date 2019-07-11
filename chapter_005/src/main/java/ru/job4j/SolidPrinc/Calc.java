package ru.job4j.SolidPrinc;

public class Calc {
    private double prev;

    public void add(String first, String second) {
        if (first.equals("prev")) first = String.valueOf(prev);
        if (second.equals("prev")) second = String.valueOf(prev);
        this.prev = Double.valueOf(first) + Double.valueOf(second);
        result();
    }

    public void subtract(String first, String second) {
        if (first.equals("prev")) first = String.valueOf(prev);
        if (second.equals("prev")) second = String.valueOf(prev);
        this.prev = Double.valueOf(first) - Double.valueOf(second);
        result();
    }

    public void multiple(String first, String second) {
        if (first.equals("prev")) first = String.valueOf(prev);
        if (second.equals("prev")) second = String.valueOf(prev);
        this.prev = Double.valueOf(first) * Double.valueOf(second);
        result();
    }

    public void div(String first, String second) {
        if (first.equals("prev")) first = String.valueOf(prev);
        if (second.equals("prev")) second = String.valueOf(prev);
        this.prev = Double.valueOf(first) / Double.valueOf(second);
        result();
    }

    public String result() {
        return " result = " + this.prev;
    }
}
