package ru.job4j.iterating.DynamicArray;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void whenPoll() {
        SimpleQueue<Integer> ss = new SimpleQueue<>();

        ss.push(0);
        assertThat(ss.poll(), is(0));
        ss.push(1);
        ss.push(2);
        assertThat(ss.poll(), is(1));
        assertThat(ss.poll(), is(2));
    }
}