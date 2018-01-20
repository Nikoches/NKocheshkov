package ru.job4j.array;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
public class MatrixTest {
    @Test
    public void matrix4x4() {
        int[][] array = {{1, 2, 3, 4},{2,4,6,8},{3,6,9,12},{4,8,12,16}};
        Matrix m1 = new Matrix();
        int[][] m2 = m1.multiple(4);
        assertThat(m2, is(array));//напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.

    }
    @Test
    public void matrix6x6() {
        int[][] array = {{1, 2, 3},{2,4,6},{3,6,9}};
        Matrix m1 = new Matrix();
        int[][] m2 = m1.multiple(3);
        assertThat(m2, is(array));//напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.

    }
}

