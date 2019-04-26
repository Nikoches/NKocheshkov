package vault;

import java.util.Iterator;

public abstract class AbsrtactStore<T extends Base> implements Store<T> {
    public SimpleArray<T> store;
    Iterator<T> ss =  store.iterator();
    public AbsrtactStore(int size){
        store = new SimpleArray<T>(size);
    }
    public  void add(T user) {
        store.add(user);
    }

    public boolean replace(String id, T user) {
        int pointer = 0;
        boolean exist = false;
        while (ss.hasNext()) {
            pointer++;
            if (ss.next().getId().equals(id)) {
                exist = true;
                break;
            }
        }
        store.set(pointer, user);
        return exist;
    }
    public boolean delete(String id) {
        T res = null;
        boolean exist = false;
        int pointer = 0;
        while (ss.hasNext()) {
            pointer++;
            if (ss.next().getId().equals(id)) {
                exist = true;
                break;
            }
        }
        store.remove(pointer);
        return exist;
    }
    public T findbyid(String id) {
        T res = null;
        while (ss.hasNext()) {
            if (ss.next().getId().equals(id)) {
                res = ss.next();
            }
        }
        return res;
    }
}
