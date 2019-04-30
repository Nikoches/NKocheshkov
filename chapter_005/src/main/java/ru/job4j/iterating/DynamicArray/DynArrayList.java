package ru.job4j.iterating.DynamicArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynArrayList<E> implements Iterable<E> {
    public int modCount = 0;
    private int size;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E date) {
        modCount++;
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
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
            public Node<E> result =first;
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

    private static class Node<E> {

        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
}
