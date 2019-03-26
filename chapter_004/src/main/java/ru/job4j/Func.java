package ru.job4j;
/**
 * Package  stream task.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Func {


   static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> list = new LinkedList<>();
        for (int index = start; index != end; index++) {
            list.add(func.apply((double) index));
        }
        return list;
    }
}
