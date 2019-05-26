package ru.job4j.iterating;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Evennumbersiterator implements Iterator<Integer> {
    private int i = 0;
    final private int[] array;

    public Evennumbersiterator(final int[] array) {
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
