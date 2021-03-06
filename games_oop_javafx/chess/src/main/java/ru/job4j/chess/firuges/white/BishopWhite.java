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
public class BishopWhite extends Special implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }



    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        int x1 = source.x, y1 = source.y; int a = 0, b = 0;
        switch (direction(dest.x, source.x, dest.y, source.y)) {
            case 0:a = 1; b = 1; break;
            case 1:a = -1; b = 1; break;
            case 2:a = -1; b = -1; break;
            case 3:a = 1; b = -1; break;
            case 13:a = 13; b = -1; break;
        }
            while (0<=x1 && x1<=7 && 0<=y1 && y1<=7) {
                x1 += a; y1 += b;
                if (dest.x == x1 & dest.y == y1) {
                    steps = new Cell[] {dest};
                    break;
                }
            }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
