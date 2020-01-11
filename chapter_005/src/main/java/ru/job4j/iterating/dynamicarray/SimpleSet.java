package ru.job4j.iterating.dynamicarray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    Dynarray<E> set = new Dynarray<>();
    private int mode = 0;
    public boolean add(E value) {
        boolean checker = false;

        if (mode != 0) {
            if (checkuniq(value)) {
                set.add(value);
                checker = true;
                mode++;
            }
        } else {
            checker = true;
            set.add(value);
            mode++;
        }
        return checker;
    }

    private boolean checkuniq(E value) {
        Iterator<E> iter = set.iterator();
        boolean checker = true;
            while (iter.hasNext()) {
                E item = iter.next();
                if ((item != null && item.equals(value)) || item == value) {
                    checker = false;
                    break;
                }
            }
        return checker;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {


        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {

                boolean checker = false;
                if (index < set.getPos()) {
                    checker = true;
                }
                return checker;
            }

            @Override
            public E next() throws NullPointerException, ConcurrentModificationException {
                E res;
                if (!hasNext()) {
                    throw new NullPointerException("no,no,no");
                }
                res = (E) set.get(index++);
                return res;
            }
        };
    }
}
