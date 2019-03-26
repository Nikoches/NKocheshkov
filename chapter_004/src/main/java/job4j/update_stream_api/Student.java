package job4j.update_stream_api;

import java.util.Comparator;
public class Student implements Comparable<Student> {

    private String name;
    private int scope;
    public Student(String name, int scope){
        this.name = name;
        this.scope = scope;
    }
        @Override
        public int compareTo (Student a){

            return a.getScope() - this.getScope();
        }
        @Override
        public boolean equals(final Object obj) {
            if (obj == null) {
                return false;
         }
            final Student std = (Student) obj;
            if (this == std) {
             return true;
            } else {
                return (this.name.equals(std.name) && (this.scope == std.scope));
            }
    }
    @Override
    public int hashCode() {
        int hashno = 7;
        hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
        return hashno;
    }

    public int getScope(){
        return this.scope;
    }
    public String toString(){
        return "Name="+" " + this.name +" "+ "Scope=" + this.scope;
    }
}
