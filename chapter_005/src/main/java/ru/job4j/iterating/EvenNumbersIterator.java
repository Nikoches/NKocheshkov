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
        boolean event = false;
        for (; i < array.length;) {
            if (array[i] % 2 == 0) {
                event = true;
                break;
            } else {
                i++;
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
        if (!hasNext()) {
            throw new NoSuchElementException("no");
        }
        return array[i++];
    }
}
