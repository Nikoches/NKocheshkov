package ru.job4j.array;
import java.util.Arrays;
public class ArrayDuplicate {
    int[] values;
    public String[] remove(String[] array) {
        int u = array.length;
     for (int i = 0; i < u; i++) {
         for (int j = i + 1; j < u; j++) {
            if (array[i].equals(array[j])) {
                array[j] = array[u - 1];
                u--;
                i--;
            }
         }
     }
     return Arrays.copyOf(array, u);
    }
}
