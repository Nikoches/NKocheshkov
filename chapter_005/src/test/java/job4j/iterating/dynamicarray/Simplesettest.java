package job4j.iterating.dynamicarray;
import org.junit.Test;
import ru.job4j.iterating.dynamicarray.SimpleSet;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Simplesettest {
    @Test
    public void TestingSet() {
       SimpleSet<Integer> set = new SimpleSet<>();
       set.add(5);
       set.add(7);
       set.add(null);
       set.add(4);
        set.add(null);
        set.add(5);
       Iterator<Integer> seet  = set.iterator();
       assertThat(seet.next(), is(5));
        assertThat(seet.next(), is(7));
        System.out.println(seet.next());
       assertThat(seet.next(), is(4));
    }
}
