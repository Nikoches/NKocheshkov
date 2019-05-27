package ru.job4j.iterating;

import org.junit.Test;

public class Arraycomparison {
    @Test
    public void masTest() {
        Arraycomparison ar = new Arraycomparison();
        char[] ch1 = new char[]{'a', 's', 'w'};
        char[] ch2 = new char[]{'a', 's', 'w'};
        System.out.println(ar.quntity(ch1, ch2));
    }
}
