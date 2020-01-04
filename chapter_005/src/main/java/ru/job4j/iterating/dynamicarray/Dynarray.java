package ru.job4j.iterating.dynamicarray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class Dynarray<T> implements Iterable<T> {
    protected int modCount = 0;
    protected Object[] array;
    protected int pos = 0;

    public Dynarray() {
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
    public int getSize(){
        return this.pos;
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
                T res;
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