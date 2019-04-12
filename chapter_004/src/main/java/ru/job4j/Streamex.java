package ru.job4j;

import java.util.Arrays;

public class Streamex {

    public int getSortedAndFilter(int[] array) {
       return Arrays.stream(array)
                .filter(x -> x % 2 == 0)
                .map(x -> x * x)
                .reduce(0, (acc, x) -> acc + x );
    }
}
