package ru.job4j;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class StreamexTest {
    @Test
    public void whenTesting() {
        Streamex str = new Streamex();
        assertThat(str.getSortedAndFilter(new int[]{0, 1, 2, 3, 4, 5, 6, 7}), is(56));
    }
}
