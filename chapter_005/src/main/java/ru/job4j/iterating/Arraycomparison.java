package ru.job4j.iterating;

import java.util.HashMap;
import java.util.Iterator;

public class Arraycomparison {
    public boolean quntity(char[] array1, char[] array2) {
        HashMap<Character, Integer> mymap = new HashMap<>();
        for (char c : array1) {
            mymap.put(c, 0);
        }
        for (char c : array2) {
            mymap.put(c, 1);
        }
        return mymap.containsValue(0);
    }

}
