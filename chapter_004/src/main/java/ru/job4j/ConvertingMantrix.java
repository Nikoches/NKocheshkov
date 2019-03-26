package ru.job4j;
/**
 * Package  stream task.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertingMantrix {

    public void convertMatrixToList() {
        List<List<Integer>> matrix = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        System.out.println(
                matrix.stream().flatMap(List::stream).collect(Collectors.toList())
        );
    }

    public List<Integer> converting(Integer[][] array) {
        return Stream.of(array)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
