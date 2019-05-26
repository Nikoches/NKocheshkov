package ru.job4j.iterating.simpletree;

import java.util.Optional;

public interface Simpletreeinterface<E extends Comparable<E>> extends Iterable<E> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);
}
