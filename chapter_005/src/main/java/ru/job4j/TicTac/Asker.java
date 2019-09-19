package ru.job4j.TicTac;

import java.util.Scanner;

public class Asker {
    private static Scanner scanner = new Scanner(System.in);

    public static int[] askCord(String text) {
        System.out.println(text);
        return new int[]{scanner.nextInt(), scanner.nextInt()};
    }

    public static int ask(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }
}
