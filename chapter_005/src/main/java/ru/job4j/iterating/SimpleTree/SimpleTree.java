package ru.job4j.iterating.SimpleTree;

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

        final Optional<Node<E>> byParent = findBy(parent);
        final Optional<Node<E>> byChild = findBy(child);

        if (!byChild.isPresent()) {
            if (byParent.isPresent()) {
                byParent.get().leaves().add(new Node<>(child));
            }else {
                final Node<E> eNode = new Node<>(parent);
                eNode.leaves().addAll(root.leaves());
                eNode.leaves().add(new Node<>(child));
                this.root = eNode;
            }
            checker = true;
            size++;
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
    public boolean isBinary() {
        Iterator it = this.iterator();
        boolean checker = true;
        while(it.hasNext()) {
            LinkedList<Node<E>> childrenGen = new LinkedList<Node<E>>((findBy((E)it.next()).get().leaves()));
            if(childrenGen.size() > 2 ){
                checker = false;
                break;
            }
        }
        return checker;
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
            @Override
            public boolean hasNext() {

                return !children.isEmpty();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E result = null;
                final Node<E> poll = children.poll();
                if (poll != null) {
                    result = poll.getValue();
                    children.addAll(poll.leaves());
                }
                return result;
            }
        };
    }


}
