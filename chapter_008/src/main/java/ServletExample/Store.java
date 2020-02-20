package ServletExample;

public interface Store {
    boolean add(User user);

    boolean update(User user,String id);

    boolean delete(String id);

    String findlAll();

    User findById(String id);

}
