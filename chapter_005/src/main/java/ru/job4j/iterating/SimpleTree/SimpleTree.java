package ru.job4j.iterating.SimpleTree;

import ru.job4j.iterating.DynamicArray.SimpleStack;

import java.util.*;

public class SimpleTree<E extends Comparable<E>> implements SimpleTreeInterface<E> {
    private Node<E> root;
    private int size = 0;

    public SimpleTree(E kr) {
        this.root = new Node<>(kr);
        size++;
    }

    public boolean add(E parent, E child) {
        boolean checker = false;
        if (size == 0) {
            this.root = new Node<>(child);
            size++;
            return checker = true;
        } else {
            Node<E> parent_finded = findBy(parent).isPresent() ? findBy(parent).get() : null;
            if (parent_finded != null) {
                Node<E> ss = new Node<>(child);
                parent_finded.add(ss);
                size++;
                checker = true;
            }
        }
        return checker;
    }

    public Optional<Node<E>> findBy(E value) {
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
        return new Iterator<E>() {
            private final LinkedList<Node<E>> children = new LinkedList<>(Collections.singletonList(root));
            private boolean nextExist = root != null;
            private int childCount = (root != null) ? root.leaves().size() : -1;

            @Override
            public boolean hasNext() {

                return nextExist;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = null;
                if (children.size() != 0) {
                    Node<E> firstOfChildren = children.pollFirst();
                    if (firstOfChildren != null) {
                        children.addAll(firstOfChildren.leaves());
                        result = firstOfChildren.getValue();
                        childCount = firstOfChildren.leaves().size();
                        nextExist = children.size() != 0;
                    }
                }
                return result;
            }
        };
    }


}
