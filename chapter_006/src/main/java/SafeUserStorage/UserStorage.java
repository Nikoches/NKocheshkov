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
            User from = storage.get(fromId);
            User toid = storage.get(toId);
            from.setAmout(from.getAmount() - amount);
            toid.setAmout(toid.getAmount() + amount);
        } else return false;
        return true;
    }

    public void remove(int id) {
        synchronized (this){
            storage.remove(id);
        }
    }
}
