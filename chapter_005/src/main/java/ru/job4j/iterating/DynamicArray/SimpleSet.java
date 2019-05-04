package ru.job4j.iterating.DynamicArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleSet<E>  implements Iterable<E>  {
    public int modCount = 0;
    DynArray<E> set = new DynArray<>();
    public boolean add(E value){
        Iterator<E> iter =  set.iterator();
        boolean checker = true;
        while (iter.hasNext()) {
            if(iter.next().equals(value)) {
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
            private int expModCount = modCount;
            private int index = 0;

            @Override
            public boolean hasNext() {

                boolean checker = false;
                if (index < set.pos) {
                    checker = true;
                }
                return checker;
            }

            @Override
            public E next() throws NullPointerException, ConcurrentModificationException {
                E res = null;
                if (expModCount != modCount) {
                    throw new ConcurrentModificationException("Modification detected");
                }
                if (!hasNext()) {
                    throw new NullPointerException("no,no,no");
                }
                res = (E) set.get(index++);
                return res;
            }
        };
    }
}
