package SafeUserStorage;

import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;

@ThreadSafe
public class UserStorage {
    private HashMap<Integer, User> storage;

    public synchronized boolean add(User usr) {
        if (!storage.containsKey(usr.getId())) {
            storage.put(usr.getId(), usr);
        } else return false;
        return true;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        if (storage.containsKey(fromId) && storage.containsKey(toId) && storage.get(fromId).getAmount() >= amount) {
            storage.get(fromId).setAmout(-amount);
            storage.get(toId).setAmout(amount);
        } else return false;
        return true;
    }

    public void remove(int id) {
        synchronized (this){
            storage.remove(id);
        }
    }
}
