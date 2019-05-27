package sort;
import java.util.*;


public class SortUser {


    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }
    public List<User> sortNameLength(LinkedList<User> users) {
        User.UserComparator compus = new User.UserComparator();
        users.sort(compus);
        return users;
    }
    public List<User> sortByAllFields(List<User> users) {
        Comparator<User> compall = new User.UserComparatorname().thenComparing(new User.UserComparatorage());
        users.sort(compall);
        return  users;
    }

}
