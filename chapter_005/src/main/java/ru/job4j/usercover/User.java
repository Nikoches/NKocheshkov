package ru.job4j.usercover;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String name;
    private final HashSet<String> emails;

    public User(String name, HashSet<String> emails) {
        this.name = name;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public Set<String> getEmails() {
        return emails;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        User other = (User) obj;
        if (!emails.equals(other.getEmails())) {
            return false;
        }
        return name.equals(other.getName());
    }

    public int hashCode() {
        return 1;
    }
}
