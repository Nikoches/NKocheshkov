package sort;
import java.util.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void sorttest() {
        Set<User> userssort;
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(12, "vova"));
        usersList.add(new User(21, "vadim"));
        usersList.add(new User(7, "anton"));
        SortUser ss1 = new SortUser();
        userssort = ss1.sort(usersList);
       System.out.println(userssort);
    }
    @Test
    public void sorttestlistbyname() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(12, "vova"));
        usersList.add(new User(21, "adamson"));
        usersList.add(new User(7, "anton"));
        SortUser ss1 = new SortUser();
        System.out.println(ss1.sortNameLength(usersList));
    }

    @Test
    public void sorttestlistbyallfields() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(25, "Иван"));
        usersList.add(new User(30, "Иван"));
        usersList.add(new User(20, "Сергей"));
        usersList.add(new User(25, "Сергей"));
        SortUser ss1 = new SortUser();
        System.out.println(ss1.sortByAllFields(usersList));
    }
}

