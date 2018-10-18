package usermap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    public Map<Integer, User> process(List<User> userslist) {
        HashMap<Integer, User> mapF = new HashMap<>();
        for (User x : userslist) {
            mapF.put(x.getId(), x);
        }
        return mapF;
    }

}
