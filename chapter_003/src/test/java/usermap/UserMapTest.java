package usermap;

import java.util.*;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserMapTest {

    @Test
    public void processTest() {
        UserConvert tryOne = new UserConvert();
        List<User1> usersList = new ArrayList<>();
        usersList.add(new User1(0, "Vasiliy", "SaintPetersburg"));
        usersList.add(new User1(1, "Evgeniy", "Moscow"));
        usersList.add(new User1(2, "Nikita", "Yekaterinburg"));
        HashMap<Integer, User1> expected = new HashMap<>();
        expected.put(0, new User1(0, "Vasiliy", "SaintPetersburg"));
        expected.put(1, new User1(1, "Evgeniy", "Moscow"));
        expected.put(2, new User1(2, "Nikita", "Yekaterinburg"));
        Map<Integer, User1> actual;
        actual = tryOne.process(usersList);
        assertThat(actual, is(expected));
    }
}
