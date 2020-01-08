package FailSafeIterator;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.iterating.dynamicarray.Dynarray;

import java.util.Iterator;

@ThreadSafe
public class ConcurentArray<E> implements Iterable<E> {
    private Dynarray<E> eDynarray;

    public ConcurentArray(Dynarray<E> eDynarray) {
        this.eDynarray = eDynarray;
    }

    private Dynarray<E> copySnapshot(Object[] array) {
        Dynarray<E> snap = new Dynarray<>();
        for (Object x : array) {
            if (x != null) {
                snap.add((E) x);
            }
        }
        return snap;
    }


    @Override
    public synchronized Iterator<E> iterator() {
        return copySnapshot(eDynarray.getArray()).iterator();
    }
}
