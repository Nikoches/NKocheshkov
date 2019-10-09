package ru.job4j.UserCover;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private HashSet<String> emails;

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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (!emails.equals(other.getEmails()))
            return false;
        if (!name.equals(other.getName()))
            return false;
        return true;
    }
}
