package ru.job4j;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertingMantrixTest {

    @Test
    public void convert() {
        ConvertingMantrix mantrix = new ConvertingMantrix();
        Integer[][] array = {{1, 2}, {3, 4}};
        System.out.println(mantrix.converting(array));
        List<Integer> matrix = List.of(1, 2, 3, 4);
        assertThat(mantrix.converting(array), is(matrix));
    }
}
