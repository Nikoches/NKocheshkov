package ru.job4j.iterating.DynamicArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynArrayList<E> implements Iterable<E> {
    public int modCount = 0;
    private int size = 0;
    private Node<E> first = null;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
        modCount++;
    }
    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E remove() {
        modCount++;
        Node<E> exp = this.first;
        this.first = this.first.next;
        exp.next = null;
        return exp.date;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }
    public Node<E> getFirst(){
        return this.first;
    }

    public boolean cycled(Node<E> first){
        if(first == null) {
            return false;
        }
        Node slow, fast;

        slow = fast = first;

        while(true) {

            slow = slow.next;

            if(fast.next != null){
                fast = fast.next.next;
            } else {return false;
                }

            if(slow == null || fast == null) {
                return false;
            }
            if(slow == fast) {
                return true;
            }
        }
    }
    public int getSize() {
        return this.size;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {

        Iterator<E> iterator = new Iterator<>() {
            public Node<E> result = first;
            private int expModCount = modCount;

            @Override
            public boolean hasNext() {
                boolean checker = false;
                if (result != null) {
                    checker = true;
                }
                return checker;
            }

            @Override
            public E next() throws NullPointerException {
                Node<E> ss = null;
                if (expModCount != modCount) {
                    throw new ConcurrentModificationException("Modification detected");
                }
                if (!hasNext()) {
                    throw new NullPointerException("no no no");
                }
                ss = result;
                result = result.next;
                return ss.date;
            }
        };
        return iterator;
    }

    public static class Node<E> {

        E date;
        Node<E> next;

        public Node(E date) {
            this.date = date;
        }
    }
}
