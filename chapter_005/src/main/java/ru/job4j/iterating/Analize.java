package ru.job4j.iterating;

import java.util.*;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int nochanges = 0;
        Map<Integer, User> mymap = new HashMap<>();
        for (User x : current) {
            mymap.put(x.id, x);
        }
        int nofinded = 0;
        for (User previousUser : previous) {
            if (mymap.containsKey(previousUser.id)) {
                if (!previousUser.name.equals(mymap.get(previousUser.id).name)) {
                    info.changed++;
                } else {
                    nochanges++;
                }
            } else {
                nofinded++;
            }
        }
        info.deleted = nofinded;
        info.added = current.size() - nochanges - info.changed;
        return info;
    }

    public static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.name = name;
            this.id = id;
        }
    }

    public class Info {
        int added;
        int changed;
        int deleted;

        @Override
        public String toString() {
            return "changes=" + changed + " added=" + added + " deleted=" + deleted;
        }
    }
}
