package job4j.iterating.DynamicArray;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.iterating.DynamicArray.SimpleStack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {
    @Test
    public void TestingStack() {
        SimpleStack<Integer> ss = new SimpleStack<>();
        ss.push(12);
        ss.push(13);
        ss.push(14);
        assertThat(ss.poll(), is(14));
        assertThat(ss.poll(), is(13));
        assertThat(ss.poll(), is(12));
    }
}
