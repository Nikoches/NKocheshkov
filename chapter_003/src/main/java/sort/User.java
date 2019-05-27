package sort;
import java.lang.Comparable;
import java.util.Comparator;

public class User implements Comparable<User> {
    String name;
    int age;
    User(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public int compareTo(User o) {
       return Integer.compare(this.age, o.age);
    }
    @Override
    public String toString() {
        return (String.format("%s, %s ", this.age, this.name));
    }


    public static class UserComparator implements Comparator<User> {
        @Override
        public int compare(User o1, User o2) {
            return (o1.name.length() - o2.name.length());
        }
    }

    public static class UserComparatorname implements Comparator<User> {
        @Override
        public int compare(sort.User o1, sort.User o2) {
            return o1.name.compareTo(o2.name);
        }
    }
    public static class UserComparatorage implements Comparator<sort.User> {
        @Override
        public int compare(sort.User o1, sort.User o2) {
            return Integer.compare(o1.age, o2.age);        }
    }

}
