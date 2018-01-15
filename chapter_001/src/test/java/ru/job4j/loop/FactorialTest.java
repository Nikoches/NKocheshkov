package ru.job4j.loop;

import org.junit.Test;
import ru.job4j.Factorial.Factorial;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
       Factorial f22 = new Factorial();
        int result = f22.calc(5);
        assertThat(result, is(120));//напишите здесь тест, проверяющий, что факториал для числа 5 равен 120.
    }

    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial f22 = new Factorial();
        int result = f22.calc(0);
        assertThat(result, is(1)); //напишите здесь тест, проверяющий, что факториал для числа 0 равен 1.
    }
}