package vault;

import java.util.Iterator;

public class UserStore<User> extends AbsrtactStore<User>  {
    private SimpleArray<User> store;
    public <User> UserStore(int size) {
        super(size);
    }
    Iterator<User> ss =  store.iterator();
    /*public  void add(User user) {
        store.add(user);
    }/*
    @Override
    public boolean replace(String id, User user) {
        int pointer = 0;
        boolean exist = false;
        while (ss.hasNext()) {
            pointer++;
            if (ss.next().getId().equals(id)) {
                store.set(pointer, user);
                exist = true;
                break;
            }
        }
        return exist;
    }

    @Override
    public boolean delete(String id) {
        User res = null;
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

    @Override
    public User findbyid(String id) {
        User res = null;
        while (ss.hasNext()) {
            if (ss.next().getId().equals(id)) {
                res = ss.next();
            }
        }
        return res;
    }*/

    @Override
    public void add(User model) {

    }

    @Override
    public boolean replace(String id, Base model) {
        return false;
    }
}
