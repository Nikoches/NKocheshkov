package ru.job4j.array;

public class Square {
    public int[] calculate(int bound) {

        int[] rsl = new int[bound];
        for (int i = 0; i != rsl.length; i++) {
            rsl[i] = (i + 1) * (i + 1);
        }
        // заполнить массив через цикл элементами от 1 до bound возведенные в квадрат
        return rsl;
    }
}
