package usermap;


public class User {
    private int id;
    private String name;
    private String city;
    public User(int id,String name,String city){
        this.id=id;
        this.city=city;
        this.name=name;
    }

    public Integer getId(){
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }


    public boolean equals(Object obj) {
        /*1. Проверьте*/
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        User user1 =  (User) obj;
        return id == user1.id && (city == user1.city || (city != null && city.equals(user1.getCity()))) &&
                (name == user1.name || (name != null &&  name.equals(user1.getName())));
    }


}
