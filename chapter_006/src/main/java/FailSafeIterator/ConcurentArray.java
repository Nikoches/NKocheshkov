package FailSafeIterator;

import net.jcip.annotations.ThreadSafe;
import ru.job4j.iterating.dynamicarray.Dynarray;

import java.util.Iterator;
@ThreadSafe
public class ConcurentArray<E> extends Dynarray<E> {
    public ConcurentArray() {
        super();
    }

    private Dynarray<E> copySnapshot(Object[] array) {
        Dynarray<E> snap = new Dynarray<>();
        for (Object x : array) {
            if(x!=null){
                snap.add((E) x);
            }
        }
        return snap;
    }


    @Override
    public synchronized Iterator<E> iterator() {
        return copySnapshot(this.array).iterator();
    }
}
