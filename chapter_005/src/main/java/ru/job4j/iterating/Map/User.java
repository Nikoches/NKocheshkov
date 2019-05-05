package ru.job4j.iterating.Map;

import java.util.Calendar;

public class User {
    public String name;
    int children;
    Calendar birthday;
    public User(String name, int children, Calendar birthday){
            this.name = name;
            this.birthday = birthday;
            this.children = children;
        }
}
