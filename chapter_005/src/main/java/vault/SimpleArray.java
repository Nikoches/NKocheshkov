package vault;

import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] mass;
    private int pos = 0;

    public SimpleArray(int size) {
        mass = new Object[size];
    }

    public void add(T value) {
        mass[pos++] = value;
    }

    public boolean set(int index, T value) {
        boolean exist = false;
        if (index <= pos) {
            mass[index] = value;
            exist = true;
        }
        return exist;
    }

    public T get(int index) {
        return (T) mass[index];
    }

    public void remove(int index) {
        if (index <= pos) {
            System.arraycopy(mass, index, mass, index + 1, mass.length - index - 1);
        }
    }

    public Iterator<T> iterator() {
        return new Iterator() {
            private int index = 0;

            @Override
            public boolean hasNext() throws NullPointerException {
                boolean checker = false;
                if (index < pos) {
                    checker = true;
                } else throw new NullPointerException("no,no,no");
                return checker;
            }

            @Override
            public T next() throws NullPointerException {
                T res = null;
                if (hasNext()) {
                    res = (T) mass[index++];
                } else throw new NullPointerException("no,no,no");
                return res;
            }
        };
    }

}
