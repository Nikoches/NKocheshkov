package ru.job4j.iterating;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    private Iterator<Integer> start = null;

    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                if (start == null || it.hasNext()&& !start.hasNext()){
                    start = it.next();
                }
                return start.hasNext();
            }

            @Override
            public Integer next()throws NoSuchElementException {
                var returned = 0;
                if(start != null && start.hasNext()){
                    returned = start.next();
                } else if(start == null || !start.hasNext()){
                    start =it.next();
                    returned = start.next();
                }
                return returned;
            }
        };
    }
}
