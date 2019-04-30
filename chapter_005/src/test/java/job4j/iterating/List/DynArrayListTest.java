package job4j.iterating.List;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterating.DynamicArray.DynArrayList;
import java.util.Iterator;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynArrayListTest {
    private DynArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new DynArrayList<>();

    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }
    @Test
    public void checkingIterator(){
        list.add(5);
        Iterator<Integer> iterator =  list.iterator();
        iterator.hasNext();
        iterator.hasNext();
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
