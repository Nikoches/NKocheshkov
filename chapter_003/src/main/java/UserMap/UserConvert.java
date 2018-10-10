package usermap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserConvert {
    /* list<User> users = new ArrayList<>();
     public void addUser (int id,String name,String City){
         users.add(new User (id,name,City));
     }
     public list<User> getUsers(){
         return users;
     }*/
    public Map<Integer, User> process(List<User> userslist) {
        HashMap<Integer, User> mapF = new HashMap<>();
        for (User x : userslist) {
            mapF.put(x.getId(), x);
        }
        return mapF;
    }

}
