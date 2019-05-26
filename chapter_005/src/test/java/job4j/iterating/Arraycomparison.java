package job4j.iterating;

import org.junit.Test;

public class Arraycomparison {
    @Test
    public void masTest() {
        ru.job4j.iterating.Arraycomparison ar = new ru.job4j.iterating.Arraycomparison();
        char[] ch1 = new char[]{'a', 's', 'w'};
        char[] ch2 = new char[]{'a', 's', 'w'};
        System.out.println(ar.quntity(ch1, ch2));
    }
}
