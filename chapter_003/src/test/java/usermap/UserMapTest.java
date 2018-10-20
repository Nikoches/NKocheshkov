package usermap;

import java.util.*;
import org.junit.Test;;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserMapTest {

    @Test
    public void processTest() {
        UserConvert tryOne = new UserConvert();
        List<User> usersList = new ArrayList<>();
        usersList.add(new User(0, "Vasiliy", "SaintPetersburg"));
        usersList.add(new User(1, "Evgeniy", "Moscow"));
        usersList.add(new User(2, "Nikita", "Yekaterinburg"));
        HashMap<Integer, User> expected = new HashMap<Integer, User>();
        expected.put(0, new User(0, "Vasiliy", "SaintPetersburg"));
        expected.put(1, new User(1, "Evgeniy", "Moscow"));
        expected.put(2, new User(2, "Nikita", "Yekaterinburg"));
        Map<Integer, User> actual = new HashMap<>();
        actual = tryOne.process(usersList);
        assertThat(actual, is(expected));
    }
}