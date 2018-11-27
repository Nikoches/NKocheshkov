package ru.job4j.array;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
    public class BubbleSortTest {
        @Test
        public void whenSortArrayWithTenElementsThenSortedArray() {
          int[] array = {5, 4, 3, 2, 1};
          BubbleSort b1 = new BubbleSort();
          int[] ar = b1.sort(array);
          int[] r1 = {1, 2, 3, 4, 5};
            assertThat(ar, is(r1)); //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        }
    }

