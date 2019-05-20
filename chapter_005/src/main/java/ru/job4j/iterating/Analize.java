package ru.job4j.iterating;

import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int nochanges = 0;
        for (User fir : previous) {
            int nofinded = 0;
            for (User sec : current) {
                if (fir.id == sec.id) {
                    if (!fir.name.equals(sec.name)) {
                        info.changed++;
                    }else nochanges++;
                }else nofinded++;
            }
            info.deleted = nofinded == current.size() ? info.deleted + 1 : info.deleted;
        }
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

    public  class Info {
        int added;
        int changed;
        int deleted;

        @Override
        public String toString() {
            return "changes=" + changed + " added=" + added + " deleted=" + deleted;
        }
    }
}
