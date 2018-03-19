package ru.job4j.Tracker;
import java.util.*;
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
