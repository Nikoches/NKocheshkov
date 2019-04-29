package ru.job4j.iterating.DynamicArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynArray<T> implements Iterable<T> {
    protected int modCount = 0;
    private Object[] array;
    private int pos = 0;

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
        return new Iterator() {
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
                    if (hasNext()) {
                        res = (T) array[index++];
                    } else {
                        throw new NullPointerException("no,no,no");
                    }
                } else {
                    throw new ConcurrentModificationException("Modification detected");
                }
                return res;
            }
        };
    }
}
