package ru.job4j.iterating;

import org.junit.Test;

public class Arraycomparisontest {
    @Test
    public void masTest() {
        Arraycomparison ar1 = new Arraycomparison();
        char[] ch1 = new char[]{'a', 's', 'w'};
        char[] ch2 = new char[]{'a', 's', 'w'};
        System.out.println(ar1.quntity(ch1, ch2));
    }
}
