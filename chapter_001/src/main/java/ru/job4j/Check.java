package ru.job4j;

import java.util.Random;

public class Check {
    int unicInt = 0;
    public String generateId() {
        Random random = new Random();
        String number = Integer.toString(random.nextInt(29 + 1)) + Integer.toString(this.unicInt++);
        //Реализовать метод генерации.
        return number;
    }
}
