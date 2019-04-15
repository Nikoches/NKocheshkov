package ru.job4j.iterating;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    private int i = 0;
    final private int[] array;

    public EvenNumbersIterator(final int[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        int j = 0;
        boolean event = false;
        j = i;
        for (; j < array.length; j++) {
            if (array[j] % 2 == 0) {
                event = true;
            }
        }
        return event;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Integer next()throws NoSuchElementException {
        int res = 0;
        for (; i < array.length; i++) {
                if (array[i] % 2 == 0) {
                    res = array[i];
                    break;
            }
        }
        if (i == array.length) {
            throw new NoSuchElementException("no");  //else throw new NoSuchElementException("no");
        }
        i++;
        return res;
}
}
