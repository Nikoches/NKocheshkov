package ru.job4j.iterating;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<>() {
            private Iterator<Integer> start = it.next();
            @Override
            public boolean hasNext() {
                boolean answer = false;
                boolean checker = true;
                while(!start.hasNext() && it.hasNext()) {
                   start = it.next();
                }
                return start.hasNext();



            }

            @Override
            public Integer next()throws NoSuchElementException {
                var returned = 0;
                if (start != null && start.hasNext()) {
                    returned = start.next();
                } else if (start == null || !start.hasNext()) {
                    start = it.next();
                    returned = start.next();
                }
                return returned;
            }
        };
    }
}
