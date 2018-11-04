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
       return this.age>o.age?1:-1;
    }

    @Override
    public String toString() {
        return (this.age + this.name);
    }
}
