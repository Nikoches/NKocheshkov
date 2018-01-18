package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class TurnTest {
    @Test
    public void WhenArrayUno() {
        Turn trn = new Turn();
        int[] array = {1,2,3,4,5};
        int[] rst = trn.back(array);
        int[] rss = {5,4,3,2,1};
        assertThat(rst, is(rss));
    }
    @Test
    public void WhenArrayDos() {
        Turn trn = new Turn();
        int[] array = {2,6,1,4};
        int[] rst = trn.back(array);
        int[] rss = {4,1,6,2};
        assertThat(rst, is(rss));
    }

}
