package job4j;

import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;
public class School {
    public List<Student> collect(List<Student> students, Predicate<Student> predict){
        return  students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
