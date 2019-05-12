package ru.job4j.iterating.Map;


import java.util.Iterator;
import java.util.LinkedList;

public class SimpleMap<K, V> implements Iterable<V> {
    private int size = 16;
    private LinkedList<Node<V, K>>[] array = new LinkedList[size];
    private int capacity = 0;

    public boolean insert(K key, V value) {
        boolean checker = false;
        int index = key.hashCode() & (size - 1);
        //если емкость превышена
        if (capacity == size - 1) {
            this.array = explore();
        }

        //если корзина пустая
        if (array[index] == null) {
            array[index] = new LinkedList<>();
            array[index].add(new Node(key, value, key.hashCode()));
            checker = true;
            capacity++;
            //если корзина не пустая
        } else if (array[index] != null) {
            Iterator<Node<V, K>> it = array[index].iterator();
            boolean rewrited = false;
            //ищем ключ в корзине
            while (it.hasNext() && !rewrited) {
                Node<V, K> oldvalue = it.next();
                if (oldvalue.key_index.equals(key)) {
                    oldvalue.value = value;
                    rewrited = true;
                    checker = true;
                }
            }
            if (!rewrited) {
                array[index].add(new Node(key, value, key.hashCode()));
                checker = true;
            }
        }
        return checker;
    }

    public V get(K key) {
        V value = null;
        Node<V, K> oldvalue = null;
        int index = key.hashCode() & (size - 1);
        if (array[index] != null) {
            Iterator<Node<V, K>> it = array[index].iterator();
            while (it.hasNext()) {
                oldvalue = it.next();
                if (oldvalue.key_index.equals(key)) {
                    oldvalue.value = value;
                }
            }
        }
        return value;
    }

    public boolean delete(K key) {
        boolean checker = false;
        int index = key.hashCode() & (size - 1);
        if (array[index] != null) {
            Iterator<Node<V, K>> it = array[index].iterator();
            while (it.hasNext()) {
                Node<V, K> oldvalue = it.next();
                if (oldvalue.key_index.equals(key)) {
                    array[index].remove(oldvalue);
                    checker = true;
                }
            }
        }
        return checker;
    }

    private LinkedList[] explore() {
        LinkedList<Node<V, K>>[] arraynew = new LinkedList[size * 2];
        size *= 2;
        for(var list : array) {
            if(list != null) {
                var it =  list.iterator();
                while (it.hasNext()) {
                    var oldv = it.next();
                    arraynew[oldv.key_index.hashCode() & (size - 1)].add(new Node(oldv.key_index, oldv.value, oldv.key_index.hashCode()));
                }
            }
        }
        return arraynew;
    }

    public Iterator<V> iterator() {
        return new Iterator<V>() {

            /**
             * Returns {@code true} if the iteration has more elements.
             * (In other words, returns {@code true} if {@link #next} would
             * return an element rather than throwing an exception.)
             *
             * @return {@code true} if the iteration has more elements
             */
            int index_list = 0;

            @Override
            public boolean hasNext() {
                boolean cheker = false;
                Iterator it = array[index_list].iterator();
                while (cheker == false && index_list < size) {
                    if (it.hasNext()) {
                        cheker = true;
                        break;
                    } else index_list++;
                }
                return cheker;
            }

            /**
             * Returns the next element in the iteration.
             *
             * @return the next element in the iteration
             * @throws //NoSuchElementException if the iteration has no more elements
             */
            @Override
            public V next() {
                Node<V, K> value = null;
                Iterator it = array[index_list].iterator();
                if (hasNext()) {
                    value = (Node) it.next();
                } else index_list++;
                return value.value;
            }
        };
    }

    private class Node<V, K> {
        K key_index;
        int hash;
        V value;

        public Node(K key, V value, int hash) {
            this.key_index = key;
            this.value = value;
            this.hash = hash;
        }
    }
}
