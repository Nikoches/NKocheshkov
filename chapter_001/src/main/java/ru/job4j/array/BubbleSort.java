package ru.job4j.array;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public int[] sort(int[] array) {
        for (int j = 0; j < array.length; j++) {
        for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1])  {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    System.out.println(Arrays.toString(array));
            }
        }
    }
        return array;
    }
}
