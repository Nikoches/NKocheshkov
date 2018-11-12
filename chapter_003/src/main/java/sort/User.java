package sort;
import java.lang.Comparable;
public class User implements Comparable<User> {
    String name;
    int age;
    User(int age,String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public int compareTo(User o) {
       return this.age - o.age;
    }
    @Override
    public String toString() {
        return (String.format("%s, %s %n ",this.age,this.name));
    }
}
