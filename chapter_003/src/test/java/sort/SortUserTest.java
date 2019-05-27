package sort;
import java.util.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void sorttest() {
        Set<User> userssort;
        List<User> usersList;
        usersList = List.of(
                new User(12, "vova"),
                new User(21, "vadim"),
                new User(7, "anton")
        );
        SortUser ss1 = new SortUser();
        userssort = ss1.sort(usersList);
        System.out.println(userssort);
    }
    @Test
    public void sorttestlistbyname() {
        LinkedList<User> usersList = new LinkedList<>();
        usersList.add(new User(12, "vova"));
        usersList.add(new User(21, "adamson"));
        usersList.add(new User(7, "anton"));
        SortUser ss1 = new SortUser();
        ss1.sortNameLength(usersList);
        System.out.println(ss1.sortNameLength(usersList));
    }

    @Test
    public void sorttestlistbyallfields() {
        LinkedList<User> usersList = new LinkedList<>();
        usersList.add(new User(25, "Иван"));
        usersList.add(new User(30, "Иван"));
        usersList.add(new User(20, "Сергей"));
        usersList.add(new User(25, "Сергей"));
        SortUser ss1 = new SortUser();
        System.out.println(ss1.sortByAllFields(usersList));
    }
}

