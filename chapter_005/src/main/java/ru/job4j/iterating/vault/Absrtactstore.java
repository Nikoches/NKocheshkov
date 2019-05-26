package ru.job4j.iterating.vault;

import java.util.Iterator;

public abstract class Absrtactstore<T extends Base> implements Store<T> {
    public Simplearray<T> store;
    public Absrtactstore(int size) {
        store = new Simplearray(size);
    }
    public void add(T user) {
        store.add(user);
    }



    public boolean replace(String id, T user) {
        int index = getIndex(id);
        boolean result = false;
        if (index != -1) {
            this.store.set(index, user);
            result = true;
        }
        return result;
    }

    public boolean delete(String id) {
        boolean exist = false;
        if (getIndex(id) != -1) {
            store.remove(getIndex(id));
            exist = true;
        }
        store.remove(getIndex(id));
        return exist;
    }
    public T findbyid(String id) {
        T ss = null;
        if (getIndex(id) != -1) {
            ss = store.get(getIndex(id));
        }
        return ss;
    }
    public int getIndex(String id) {
        Iterator<T> ss =  store.iterator();
        int index = -1;
        int count = 0;
        while (ss.hasNext()) {
            if (id.equals(ss.next().getId())) {
                index = count;
                break;
            }
            count++;
        }
        return index;
    }
}
