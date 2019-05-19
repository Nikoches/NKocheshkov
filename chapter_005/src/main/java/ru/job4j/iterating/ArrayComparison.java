package ru.job4j.iterating;

import java.util.HashMap;
import java.util.Iterator;

public class ArrayComparison {
    public boolean  quntity(char[] array1, char[] array2){
        HashMap<Character,Integer> mymap = new HashMap<>();
        for (int i=0;i<array1.length;i++) {
            mymap.put(array1[i],0);
        }
        for (int i=0;i<array2.length;i++) {
            mymap.put(array2[i],1);
        }
         return mymap.containsValue(0);
    }

}
