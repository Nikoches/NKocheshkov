package job4j.update_stream_api;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Students {

    public List<Student> levelOf(List<Student> students, int bound){
        return students.stream()
                .sorted()
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScope()>= bound)
                .collect(Collectors.toList());
    }
}
