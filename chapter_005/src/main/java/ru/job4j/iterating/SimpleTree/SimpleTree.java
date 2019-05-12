package ru.job4j.iterating.SimpleTree;

import java.util.*;

public class SimpleTree<E extends Comparable<E>> implements SimpleTreeInterface<E> {
    private Node<E> root;
    private int size = 0;
    public boolean add(E parent, E child) {
        boolean checker = false;
        if(size == 0){
            this.root = new Node<>(child);
            size++;
            return checker = true;
        }
        if(size != 0) {
            if(findBy(parent).isPresent()){
                Node<E> parent_finded = findBy(parent).get();
                Node<E> ss = new Node<>(child);
                parent_finded.add(ss);
                size++;
                checker = true;
            }

        }

        return checker;
    }

    public Optional<Node<E>> findBy(E value){
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }


    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return null;
    }


}
