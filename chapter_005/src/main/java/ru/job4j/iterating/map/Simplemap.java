package ru.job4j.iterating.map;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Simplemap<K, V> implements Iterable<V> {
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
                if (oldvalue.keyindex.equals(key)) {
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
        Node<V, K> oldvalue;
        int index = key.hashCode() & (size - 1);
        if (array[index] != null) {
            for (Node<V, K> vkNode : array[index]) {
                oldvalue = vkNode;
                if (oldvalue.keyindex.equals(key)) {
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
            for (Node<V, K> oldvalue : array[index]) {
                if (oldvalue.keyindex.equals(key)) {
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
        for (var list : array) {
            if (list != null) {
                for (Node<V, K> oldv : list) {
                    arraynew[oldv.keyindex.hashCode() & (size - 1)].add(new Node(oldv.keyindex, oldv.value, oldv.keyindex.hashCode()));
                }
            }
        }
        return arraynew;
    }

    public Iterator<V> iterator() {
        return new Iterator<>() {
            int indexlist = 0;
            int index = 0;

            @Override
            public boolean hasNext() {
                boolean cheker = false;
                if (array[indexlist] != null) {
                    Iterator it = array[indexlist].iterator();
                    while (!cheker && indexlist < size) {
                        for (; index > 0; index++) {
                            it.next();
                        }
                        if (it.hasNext()) {
                            cheker = true;
                            break;
                        } else {
                            indexlist++;
                        }
                    }

                }
                return cheker;
            }
            @Override
            public V next()throws NoSuchElementException {
                Node<V, K> value = null;
                Iterator it = array[indexlist].iterator();
                if (hasNext()) {
                    for (; index > 0; index++) {
                        it.next();
                    }
                    value = (Node) it.next();
                    index++;
                } else if (!hasNext() && indexlist < array.length) {
                    indexlist++;
                } else {
                    throw new NoSuchElementException("no,no,no");
                }
                return value.value;
            }
        };
    }
    private class Node<V, K> {
        K keyindex;
        int hash;
        V value;

        public Node(K key, V value, int hash) {
            this.keyindex = key;
            this.value = value;
            this.hash = hash;
        }
    }
}
