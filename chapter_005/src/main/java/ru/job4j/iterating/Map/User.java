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
}
