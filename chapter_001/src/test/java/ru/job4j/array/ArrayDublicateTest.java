package ru.job4j.array;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import java.util.Arrays;
public class ArrayDublicateTest {
    @Test
    public void equals() {
        String [] array = {"aa","ss","qq","aa","ss"};
        ArrayDuplicate m1 = new ArrayDuplicate();
        String [] m2 = m1.remove(array);
        String [] m22 = {"aa","ss","qq"};
        assertThat(m2, is(m22));
    }

    @Test
    public void equals1() {
        String [] array = {"ww","ss","ww","aa"};
        ArrayDuplicate m10 = new ArrayDuplicate();
        String [] m3 = m10.remove(array);
        String [] m33 = {"ww","ss","aa"};
        System.out.print(Arrays.toString(m3));
        assertThat(m33, is(m3));
    }
}
