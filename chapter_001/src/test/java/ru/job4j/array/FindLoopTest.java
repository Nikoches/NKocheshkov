package ru.job4j.array;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class FindLoopTest {
    @Test
    public void WhenSix() {
        FindLoop ff = new FindLoop();
        int[] rss={12,22,3965,990,7922,1,3445,34,35,36,3407};
        int rst = ff.indexOf(rss,3445);
        assertThat(rst, is(6));
    }

    @Test
    public void WhenFour() {
        FindLoop ff = new FindLoop();
        int[] rss={12,22,3965,990,7922,1,3445,34,35,36,3407};
        int rst = ff.indexOf(rss,7922);
        assertThat(rst, is(0));
    }
}