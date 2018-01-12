package ru.job4j.MaxTest;
import org.junit.Test;
import ru.job4j.max.Max;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class MaxTest {
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
    public void whenFirstEqualSecond() {
        Max max1 = new Max();
        int result = max1.max(3, 3);
        assertThat(result, is(0));

    }
}