package ru.job4j.array;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    public void whenSquareFour() {
        Square sqr = new Square();
        int[] rst = sqr.calculate(4);
        int[] rss = {1, 4, 9, 16};
        assertThat(rst, is(rss));
    }
    @Test
    public void whenSquareSeven() {
        Square sqr = new Square();
        int[] rst = sqr.calculate(7);
        int[] rss = {1, 4, 9, 16, 25, 36, 49};
        assertThat(rst, is(rss));
    }
}
