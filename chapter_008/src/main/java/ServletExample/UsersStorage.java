package ServletExample;

import java.util.HashMap;
import java.util.Map;

public class UsersStorage implements Store {
    private Map<Integer, User> userList = new HashMap<Integer, User>();
    private int counterId = 0;
    private final static UsersStorage usersStorage = new UsersStorage();
    private UsersStorage()  {

    }

    public static UsersStorage getInstance() {
        return usersStorage;
    }

    public void deleteUser(int id) {
        userList.remove(id);
    }

    public void updateUser() {

    }

    @Override
    public boolean add(User user) {
        if (!userList.containsValue(user)) {
            userList.put(counterId, user);
            counterId++;
            return true;
        }
        return false;
    }

    @Override
    public boolean update() {
        return true;
    }

    @Override
    public boolean delete() {
        return true;
    }

    @Override
    public Map<Integer, User> findlAll() {
        return userList;
    }

    @Override
    public User findById(Integer id) {
        User returned = null;
        if (!userList.containsKey(id)) {
            return userList.get(id);
        }
        return returned;
    }
    public boolean alreadyHas(User user){
        return userList.containsValue(user);
    }
}
