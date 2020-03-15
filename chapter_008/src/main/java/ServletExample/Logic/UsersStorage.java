package ServletExample.Logic;

import ServletExample.Model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersStorage implements Store {
    private final static UsersStorage usersStorage = new UsersStorage();
    private final Map<Integer, User> userList = new HashMap<Integer, User>();
    private int counterId = 0;

    private UsersStorage() {

    }

    public static UsersStorage getInstance() {
        return usersStorage;
    }

    public int getCounterId() {
        return counterId++;
    }

    @Override
    //TODO Сделай что нибудь с ид, проверка не проходит при втором добавлении
    public boolean add(User user) {
        if(!alreadyHas(user)) {
            userList.put(user.getId(),user);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user, String id) {
        user.setId(Integer.parseInt(id));
        if(alreadyHas(user)){
           userList.put(Integer.parseInt(id),user);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if(userList.containsKey(Integer.parseInt(id))){
            userList.remove(Integer.parseInt(id));
            return true;
        }
        return false;
    }

    @Override
    public List<User> findlAll() {
        return new ArrayList<>(userList.values());
    }

    @Override
    public User findById(String id) {
        return userList.get(Integer.parseInt(id));
    }

    public boolean alreadyHas(User user) {
        return userList.containsKey(user.getId());
    }
    public void removeAll(){
        userList.clear();
    }
}
