package ru.job4j.iterating.list;
import org.junit.Test;
import org.junit.Before;
import ru.job4j.iterating.list.Simplearraylist;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class Simplearraylisttest {

    private Simplearraylist<Integer> list;

    @Before
    public void beforeTest() {
        list = new Simplearraylist<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }
    @Test
    public void whenDeleteFirstAndSecond() {
        //System.out.println(list.get(0));
        list.remove();
        assertThat(list.get(0), is(2));
        list.add(4);

    }

}

