package usermap;


import java.util.Comparator;

public class User1 {
    private int id;
    private String name;
    private String city;

    public User1(int id, String name, String city) {
        this.id = id;
        this.city = city;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User1 user1 = (User1) obj;
        return id == user1.id && (city != null && city.equals(user1.getCity()))
                &&  (name != null && name.equals(user1.getName()));
    }

}
