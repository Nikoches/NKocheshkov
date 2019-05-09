package ru.job4j.iterating.Map;

import java.util.Calendar;

public class User {
    private String name;
    private int children;
    private Calendar birthday;
    public User(String name, int children, Calendar birthday){
            this.name = name;
            this.birthday = birthday;
            this.children = children;
        }
    @Override
    public int hashCode(){
        int result = Integer.hashCode(children);
        result = 31 * result + name.hashCode();
        result = 31 * result + birthday.hashCode();
        return result;
    }
   /* @Override
    public boolean equals(Object obj){
        boolean equality = false;
        if(obj == this){
            equality = true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            equality =  false;
        }
        User user = (User) obj;
        if(user.name != null && user.birthday != null && this.name.equals(user.name) && this.birthday.equals(user.birthday) && this.children == user.children ){
            equality = true;
        }
        return equality;
    }*/
}
