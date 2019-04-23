package vault;
/**
 * Package  vault.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */
public abstract class Base {

    private final String id;
    public Base(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
}
