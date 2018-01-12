package ru.job4j.max;

public class Max {
    public int max(int first, int second){
     if (first>second){
        return first;
     }else if (first<second){
         return second;
     }else {return 0;
     }
    }
}
