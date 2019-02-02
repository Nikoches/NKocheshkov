package banking;

public class User implements Comparable<User>{
    private String name;
    private String pasport;

    public User(String pasport,String name){
        this.pasport = pasport;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPasport() {
        return pasport;
    }

    public boolean equals(Object obj) {
        boolean equality =false;
        if (obj == this) {
            equality = true;
        }
        User user = (User) obj;
        equality = name!=null && pasport != null && name.equals(user.name) && pasport.equals(user.pasport);

        if (obj == null || obj.getClass() != this.getClass()) {
            equality = false;
        }
        return equality;
    }
    public int compareTo(User obj){

       return this.getName().compareTo(obj.getName());

    }
    public int hashCode() {
        int res = 17;
        res = 31 * res + name.hashCode();
        res = 31 * res + pasport.hashCode();
        return res;
    }
}
