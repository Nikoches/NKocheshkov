package ru.job4j;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FuncTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Func.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenSquareFunctionThenLinearResults() {
        List<Double> result = Func.diapason(5, 8, x -> 2 * x * x + x + 3);
        List<Double> expected = Arrays.asList(58D, 81D, 108D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenlogarifmicalFunctionThenLinearResults() {
        List<Double> result = Func.diapason(5, 8, x -> Math.log(x));
        List<Double> expected = Arrays.asList(1.6094379124341003,  1.791759469228055, 1.9459101490553132);
        assertThat(result, is(expected));
    }
}
