package ru.job4j.iterating;

import java.util.Iterator;

public class MatrixIterator implements Iterator {
    final int[][] matrix;
    public MatrixIterator(final  int[][] matrix) {
        this.matrix = matrix;
    }
    private int first_counter = 0;
    private int second_counter = 0;

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {

        return matrix.length > first_counter && matrix[first_counter].length > second_counter;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public Object next() {
        Object ss = null;
        if(matrix[first_counter].length > second_counter && matrix.length > first_counter){
            ss = matrix[first_counter][second_counter++];
        }else if(matrix[first_counter].length < second_counter && matrix.length > first_counter){
            ss = matrix[first_counter++][0];
        }
        return ss;
    }
}
