package ru.job4j.usercover;

import java.util.*;

public class MergerUser {

    public Set mergerUsers(List<User> users) {
        LinkedList<String> emails = new LinkedList<>();
        User[] usersArray;
        HashMap<String, User> usersMap = new HashMap<>();
        usersArray = new User[users.size()];
        int j = 0;
        for (User x : users) {
            emails.addAll(x.getEmails());
            usersArray[j++] = x;
        }
        j = 0;
        for (String s : emails) {
            if (!usersMap.containsKey(s)) {
                if (usersArray[j].getEmails().contains(s)) {
                    usersMap.put(s, usersArray[j]);
                } else {
                    j++;
                    usersMap.put(s, usersArray[j]);
                }
            } else if (usersArray[j].getEmails().contains(s)) {
                usersMap.get(s).getEmails().addAll(usersArray[j].getEmails());
            } else {
                j++;
                usersMap.get(s).getEmails().addAll(usersArray[j].getEmails());
                usersArray[j] = usersMap.get(s);
            }
        }
        return new HashSet<>(Arrays.asList(usersArray));
    }

    public static class SetUtils {

        public static boolean equals(Set<?> set1, Set<?> set2) {

            if (set1 == null || set2 == null) {
                return false;
            }

            if (set1.size() != set2.size()) {
                return false;
            }

            return set1.containsAll(set2);

        }
    }
}
