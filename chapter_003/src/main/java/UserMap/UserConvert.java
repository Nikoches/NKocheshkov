package UserMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvert {
    List<User> users = new ArrayList<>();
    public void addUser (int id,String name,String City){
        users.add(new User (id,name,City));
    }
    public List<User> getUsers(){
        return users;
    }
    public HashMap<Integer, User> process(List<User> list){
        HashMap<Integer, User> MapF = new HashMap<Integer, User>();
       for(User X:users){
            MapF.put(X.getId(),X);
       }
       return MapF;
    }

}
