package ServletExample.Logic;

import ServletExample.Model.User;

import java.util.List;

public interface Store {
    boolean add(User user);

    boolean update(User user,String id);

    boolean delete(String id);

    List<User> findlAll();

    User findById(String id);

    void removeAll();

    int getCounterId();
}
