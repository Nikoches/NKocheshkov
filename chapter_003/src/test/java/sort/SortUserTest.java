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
        List<User> usersList;
        usersList = List.of(
                new User(12, "vova"),
                new User(21, "adamson"),
                new User(7, "anton")
        );
        SortUser ss1 = new SortUser();
        System.out.println(ss1.sortNameLength(usersList));
    }

    @Test
    public void sorttestlistbyallfields() {
        List<User> usersList;
        usersList = List.of(
                new User(25, "Иван"),
                new User(30, "Иван"),
                new User(20, "Сергей"),
                new User(25, "Сергей")
        );
        SortUser ss1 = new SortUser();
        System.out.println(ss1.sortByAllFields(usersList));
    }
}

