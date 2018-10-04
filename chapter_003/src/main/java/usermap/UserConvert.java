package usermap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserConvert {
   /* List<User> users = new ArrayList<>();
    public void addUser (int id,String name,String City){
        users.add(new User (id,name,City));
    }
    public List<User> getUsers(){
        return users;
    }*/
    public HashMap<Integer, User> process(List<User> userslist){
        HashMap<Integer, User> mapF = new HashMap<>();
       for(User X:userslist){
            mapF.put(X.getId(),X);
       }
       return mapF;
    }

}
