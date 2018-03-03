package ru.job4j;

public class Start {
    public static void main(String[] args) {
        check ch1 = new check();
        String x;
        int i = 0;
        while (i < 10) {
            i++;
            x = ch1.generateId();
            System.out.println(x);
        }
    }
}