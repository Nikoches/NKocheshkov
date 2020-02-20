package ServletExample;

import java.util.HashMap;
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
    @Override
    public boolean add(User user) {
        if(!alreadyHas(user)){
            userList.put(counterId,user);
            counterId++;
            return true;
        }
        return false;
    }

    @Override
    public boolean update(User user, String id) {
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
    public String findlAll() {
        return "User List" + toString();
    }

    @Override
    public User findById(String id) {
        return userList.get(Integer.parseInt(id));
    }

    public boolean alreadyHas(User user) {
        return userList.containsValue(user);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (User x:userList.values()){
            stringBuilder.append(x.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
    public void removeAll(){
        userList.clear();
    }
}
