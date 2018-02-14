package ru.job4j.array;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
public class arrays_comparison_test {
    @Test
    public void tryingto() {
        int[] a= {1,3};
        int[] b ={2,4,6};
        arrays_comperison ar = new arrays_comperison();
        int [] ar1 = ar.comp(a,b);
        int [] r1 = {1,2,3,4,6};
        assertThat(ar1, is(r1));
    }
}
