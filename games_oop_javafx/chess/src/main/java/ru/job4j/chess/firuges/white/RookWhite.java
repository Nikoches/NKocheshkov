package ru.job4j.chess.firuges.white;


import ru.job4j.chess.Special;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class RookWhite extends Special implements Figure {
    private final Cell position;

    public RookWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int a = 0, b = 0, c = 0;
        Cell[] steps = new Cell[0];
        switch (direct(dest.x, source.x, dest.y, source.y)) {
            case 4:
                a = source.y;
                c = dest.y;
                b = 1;
                break;
            case 5:
                a = source.y;
                c = dest.y;
                b = -1;
                break;
            case 6:
                a = source.x;
                c = dest.x;
                b = 1;
                break;
            case 7:
                a = source.x;
                c = dest.x;
                b = -1;
                break;
        }
        while (a >= 0 && a <= 7 && direct(dest.x, source.x, dest.y, source.y) != 0) {
            a += b;
            if (a == c) {
                steps = new Cell[]{dest};
                break;
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new RookWhite(dest);
    }
}
