import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.LinkedList;
import java.util.List;

public class SchoolTest {
    Student st1 = new Student("vova",100);
    Student st2  = new Student("slava",90);
    Student st3  = new Student("petya",40);
    Student st4  =new Student("roman",30);
    @Test
    public void whenAclass(){
         School sch = new School();
        LinkedList<Student> students = new LinkedList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        List<Student> expected = new LinkedList<>();
        expected.add(st1);
        expected.add(st4);
        List<Student> real = sch.collect(students,student -> student.getScore()  >= 90);
        assertThat(real, is (expected));

    }
}
