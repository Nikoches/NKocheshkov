package ru.job4j.updatestreamapi;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
public class StudentsTest {
    @Test
    public void whenHaveBound() {
        Students uni = new Students();
        List<Student> students = new ArrayList<>();
        students.add(new Student("volodya", 100));
        students.add(new Student("roman", 25));
        students.add(new Student("stepan", 85));
        students.add(new Student("eugeniy", 80));
        students.add(null);
        List<Student> students1 = uni.levelOf(students, 80);
        List<Student> studentsTest = new ArrayList<>();
        studentsTest.add(new Student("volodya", 100));
        studentsTest.add(new Student("stepan", 85));
        studentsTest.add(new Student("eugeniy", 80));
        assertThat(students1, is(studentsTest));
    }
}
