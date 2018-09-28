import java.util.*;

import UserMap.User;
import UserMap.UserConvert;
import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserMapTest {

    @Test
    public void processTest(){
        UserConvert TryOne = new UserConvert();
        TryOne.addUser(0,"Vasiliy","SaintPetersburg");
        TryOne.addUser(1,"Evgeniy","Moscow");
        TryOne.addUser(2,"Nikita","Yekaterinburg");
        HashMap<Integer,User> usershash= new HashMap<Integer,User>();
       usershash= TryOne.process(TryOne.getUsers());
        Set<Map.Entry<Integer, User>> set = usershash.entrySet();
        for (HashMap.Entry<Integer, User> me : set) {
            System.out.print(me.getKey() + ": ");
            System.out.println(me.getValue());
        }
    }
}
