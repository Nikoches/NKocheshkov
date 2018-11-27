package ru.job4j;

public class Start {
    public static void main(String[] args) {
        Check ch1 = new Check();
        String x;
        int i = 0;
        while (i < 10) {
            i++;
            x = ch1.generateId();
            System.out.println(x);
        }
    }
}