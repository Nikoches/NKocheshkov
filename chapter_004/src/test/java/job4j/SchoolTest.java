package job4j;


import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.*;
import java.util.stream.Collectors;

public class SchoolTest {
    Student st1 = new Student("vova",100);
    Student st2  = new Student("slava",90);
    Student st3  = new Student("petya",40);
    Student st4  = new Student("roman",30);
    @Test
    public void whenAclass() {
         School sch = new School();
        LinkedList<Student> students = new LinkedList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        List<Student> expected = new LinkedList<>();
        expected.add(st1);
        expected.add(st2);
        List<Student> real = sch.collect(students,student -> student.getScore()  >= 90);
        assertThat(real, is (expected));

    }

    @Test
    public void convert() {
        Map<String,Student> mapOfStudent = new TreeMap<>();
        LinkedList<Student> students = new LinkedList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        mapOfStudent  = students.stream()
                .distinct()
                .collect(Collectors.toMap(Student::getName, Student -> Student ));
    }
}
