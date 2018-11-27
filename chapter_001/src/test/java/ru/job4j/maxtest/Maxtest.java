package ru.job4j.maxtest;
import org.junit.Test;
import ru.job4j.max.Max;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class Maxtest {
    @Test
    public void whenFirstLessSecond() {
        Max max1 = new Max();
        int result = max1.max(1, 2);
        assertThat(result, is(2));

    }
    @Test
    public void whenFirstMorethanSecond() {
        Max max1 = new Max();
        int result = max1.max(3, 2);
        assertThat(result, is(3));

    }
    @Test
    public void guessWhat() {
        Max max1 = new Max();
        int result = max1.max2(3, 2, 5);
        assertThat(result, is(5));

    }
}