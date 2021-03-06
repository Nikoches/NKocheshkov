package ru.job4j.updatestreamapi;
/**
 * Package for new features stream task.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Students {
    /** Сортировка и выборка студентов
     * @param students список студентов
     * @param bound кол-во баллов для выборки
     * @return возвращает лист студентов
     * */

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted(Comparator.comparing(Student::getScope).reversed())
                .takeWhile(student -> student.getScope() >= bound)
                .collect(Collectors.toList());
    }
}
