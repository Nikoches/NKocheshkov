package usermap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UseConvert {
    public Map<Integer, User1> process(List<User1> userslist) {
        HashMap<Integer, User1> mapF = new HashMap<>();
        for (User1 x : userslist) {
            mapF.put(x.getId(), x);
        }
        return mapF;
    }

}
