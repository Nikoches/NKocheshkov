package ru.job4j.UserCover;

import java.util.*;

public class MergerUser {
    private LinkedList<String> emails = new LinkedList<>();
    private User[] usersX;
    private HashMap<String, User> usersE = new HashMap<>();

    public static void main(String[] args) {
        LinkedList ss = new LinkedList();
        HashSet<String> listE = new HashSet<>();
        listE.add("OT");
        listE.add("OA");
        ss.add(new User("user1", listE));
        HashSet<String> listE1 = new HashSet<>();
        listE1.add("OQ");
        ss.add(new User("user2", listE1));
        HashSet<String> listE4 = new HashSet<>();
        listE4.add("OZ");
        ss.add(new User("user4", listE4));
        HashSet<String> listE2 = new HashSet<>();
        listE2.add("OB");
        listE2.add("OA");
        ss.add(new User("user3", listE2));
        new MergerUser().mergerUsers(ss);
    }

    public Set mergerUsers(List<User> users) {
        usersX = new User[users.size()];
        int j = 0;
        for (User x : users) {
            emails.addAll(x.getEmails());
            usersX[j++] = x;
        }
        int i = 0;
        for (String s : emails) {
            if (!usersE.containsKey(s)) {
                if (usersX[i].getEmails().contains(s)) {
                    usersE.put(s, usersX[i]);
                } else {
                    i = i + 1;
                    usersE.put(s, usersX[i]);
                }
            } else if (usersX[i].getEmails().contains(s)) {
                usersE.get(s).getEmails().addAll(usersX[i].getEmails());
            } else {
                i = i + 1;
                usersE.get(s).getEmails().addAll(usersX[i].getEmails());
                usersX[i]= usersE.get(s);
            }
        }
        return new HashSet<>(Arrays.asList(usersX));
    }
    public static class SetUtils {

        public static boolean equals(Set<?> set1, Set<?> set2){

            if(set1 == null || set2 ==null){
                return false;
            }

            if(set1.size()!=set2.size()){
                return false;
            }

            return set1.containsAll(set2);

        }
    }
}
