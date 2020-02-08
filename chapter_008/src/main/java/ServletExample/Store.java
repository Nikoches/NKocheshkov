package ServletExample;

import java.util.Map;

public interface Store {
    boolean add(User user);

    boolean update();

    boolean delete();

    Map<Integer,User> findlAll();

    User findById(Integer id);
}
