package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void whenPaintBoardWithWidthThreeAndHeightThreeThenStringWithThreeColsAndThreeRows() {
        Board board = new Board();
        String result = board.paint(3, 3);
        final String ln = System.getProperty("line.separator");
        String expected = String.format("X X%s X %sX X%s", ln, ln, ln);
        assertThat(result, is(expected));
    }

    @Test
    public void whenPaintBoardWithWidthFiveAndHeightFourThenStringWithFiveColsAndFourRows() {
        Board board1 = new Board();
        String result = board1.paint(5, 4);
        final String ln = System.getProperty("line.separator");
        String expected = String.format("X X X%s X X %sX X X%s X X %s", ln, ln, ln, ln); //напишите здесь тест, проверяющий формирование доски 5 на 4.
        assertThat(result, is(expected));
    }
}