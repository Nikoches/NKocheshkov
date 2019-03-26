package ru.job4j;

/**
 * Package  stream task.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Adress> collect(List<Profile> profiles) {
        LinkedList<Adress> adreses = profiles.stream()
                .map(Profile::getAdress)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(adreses);
        return adreses;
    }
    public List<Profile> checkingMathes(LinkedList<Adress> adreses) {
        LinkedList<Profile> profili;
        profili = adreses.stream()
                .sorted(Adress::compareTo)
                .distinct()
                .map(Profile::new)
                .collect(Collectors.toCollection(LinkedList::new));
        return profili;
    }
}
