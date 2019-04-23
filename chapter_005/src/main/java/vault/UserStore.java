package vault;

import java.util.Iterator;

public class UserStore implements Store<User> {
    private SimpleArray store;
    public UserStore(int size) {
        store = new SimpleArray(size);
    }
    Iterator<User> ss =  store.iterator();
    @Override
    public void add(User user) {
        store.add(user);
    }
    @Override
    public boolean replace(String id, User user) {
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
    }
}
