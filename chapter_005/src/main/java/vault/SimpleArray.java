package vault;

import java.lang.reflect.Array;
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
    public void set(int index, T value) {
        if (index >= 0 && index < mass.length - 1) {
            mass[index] = value;
        }
    }
    public T get(int index) {
        return (T) mass[index];
    }
    public void remove(int index) {
        if (index >= 0 && index < mass.length - 1) {
            System.arraycopy(mass, index, mass, index + 1, mass.length - index - 1);
        }
    }
    public Iterator<T> iterator() {
        return new Iterator() {
            private int index = 0;
            @Override
            public boolean hasNext() throws NullPointerException{
                boolean checker = false;
                if (index <= mass.length ) {
                checker = !(mass[index + 1] == null);
                } else throw new NullPointerException("no,no,no");
                return checker;
            }

            @Override
            public T next() {
                return (T) mass[index++];
            }
        };
    }
}
