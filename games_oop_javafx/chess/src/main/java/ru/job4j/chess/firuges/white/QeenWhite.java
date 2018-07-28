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
public class QeenWhite extends Special implements Figure {
    private final Cell position;

    public QeenWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        if(direction(dest.x, source.x, dest.y, source.y)==13) {
            int a = 0, b = 0, c = 0;
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
        }else {
            int x1 = source.x, y1 = source.y;
            int v = 0, n = 0;
            switch (direction(dest.x, source.x, dest.y, source.y)) {
                case 0:
                    v = 1;
                    n = 1;
                    break;
                case 1:
                    v = -1;
                    n = 1;
                    break;
                case 2:
                    v = -1;
                    n = -1;
                    break;
                case 3:
                    v = 1;
                    n = -1;
                    break;
                case 13:
                    v = 13;
                    n = -1;
                    break;
            }
            while (0 <= x1 && x1 <= 7 && 0 <= y1 && y1 <= 7) {
                x1 += v;
                y1 += n;
                if (dest.x == x1 & dest.y == y1) {
                    steps = new Cell[]{dest};
                    break;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new QeenWhite(dest);
    }
}
