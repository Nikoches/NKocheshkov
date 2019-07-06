package ru.job4j.Sparser;

import org.junit.Test;

public class SparserTest {
    @Test
    public void testparser() {
        PasingVacancy ss = new PasingVacancy();
        ss.parse("1 июл 19, 21:56");

    }
}
