package ru.job4j.iterating;

import java.util.Iterator;

public class MatrixIterator implements Iterator {
    final int[][] matrix;
    public MatrixIterator(final  int[][] matrix) {
        this.matrix = matrix;
    }
    private int i = 0;
    private int j = 0;

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {

        return matrix.length > i && matrix[i].length > j;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public Object next() {
        Object res = matrix[i][j++];
        if (j == matrix[i].length) {
            j = 0;
            i++;
        }

        return res; // matrix[i].length == j ? matrix[i++][j=0] : matrix[i][j++];
    }
}
