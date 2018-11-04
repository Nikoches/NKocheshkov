package sort;

import java.util.*;

public class SortUser {


    public Set<User> sort (List<User> users) {
        Set<User> userssort = new TreeSet<>();
        userssort.addAll(users);
        return userssort;
    }
}
