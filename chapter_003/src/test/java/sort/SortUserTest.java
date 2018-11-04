package sort;
import java.util.*;
import org.junit.Test;;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void Sorttest(){
        Set<User> userssort = new TreeSet<>();
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(12,"vova"));
        usersList.add(new User(21,"vadim"));
        usersList.add(new User(7,"anton"));
        SortUser ss1= new SortUser();
       userssort = ss1.sort(usersList);
       System.out.println(userssort);
    }

}

