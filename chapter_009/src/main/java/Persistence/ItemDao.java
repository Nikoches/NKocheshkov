package Persistence;

import java.util.List;

public interface ItemDao {

    void save(Item item);

    Item findByid(Integer id);

    void update(Item item);

    void delete(Item id);

    List<Item> getAll();
}
