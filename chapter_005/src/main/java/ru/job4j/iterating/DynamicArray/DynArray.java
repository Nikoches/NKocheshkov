package ru.job4j.iterating.DynamicArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynArray<T> implements Iterable<T> {
    public int modCount = 0;
    private Object[] array;
    public int pos = 0;

    public DynArray() {
        array = new Object[100];
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void add(T value) {
        if (pos < array.length - 1) {
            array[pos++] = value;
        } else {
            array = extensionArray();
            array[pos++] = value;
        }
        modCount++;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    private Object[] extensionArray() {
        Object[] array1 = new Object[pos + 100];
        System.arraycopy(array, 0, array1, 0, pos);
        array = array1;
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int expModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {

                boolean checker = false;
                if (index < pos) {
                    checker = true;
                }
                return checker;
            }

            @Override
            public T next() throws NullPointerException, ConcurrentModificationException {
                T res = null;
                if (expModCount != modCount) {
                    throw new ConcurrentModificationException("Modification detected");
                }
                if (!hasNext()) {
                    throw new NullPointerException("no,no,no");
                }
                    res = (T) array[index++];
                return res;
            }
        };
    }
}