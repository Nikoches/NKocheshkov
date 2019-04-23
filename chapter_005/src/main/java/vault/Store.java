package vault;
/**
 * Package  vault.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */
public interface Store<T extends Base> {
    void add(T model);
    boolean replace(String id, T model);
    boolean delete(String id);
    T findbyid(String id);
}
