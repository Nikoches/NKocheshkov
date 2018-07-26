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
public class KnightWhite extends Special implements Figure {
    private final Cell position;

    public KnightWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
       switch (direction(dest.x, source.x, dest.y, source.y)) {
           case 0:
               if ((dest.y  == source.y + 1) && (dest.x  == source.x + 2)) {
                   steps = new Cell[] {dest};
               } else if ((dest.y  == source.y + 2) && (dest.x  == source.x + 1)) {
                   steps = new Cell[] {dest};
               }
               break;
           case 1:
               if ((dest.y == source.y + 1) && (dest.x  == source.x- 2)) {
                   steps = new Cell[] {dest};
               } else if ((dest.y == source.y+ 2) && (dest.x  == source.x- 1)) {
                   steps = new Cell[] {dest};
               }
               break;
           case 2:
               if ((dest.y == source.y- 1) && (dest.x  == source.x- 2)) {
                   steps = new Cell[] {dest};
               } else if ((dest.y  == source.y- 2) && (dest.x  == source.x- 1)) {
                   steps = new Cell[] {dest};
               }
               break;
           case 3:
               if ((dest.y  == source.y- 1) && (dest.x  == source.x+ 2)) {
                   steps = new Cell[] {dest};
               } else if ((dest.y  == source.y- 2) && (dest.x  == source.x+ 1)) {
                   steps = new Cell[] {dest};
               }
               break;
       }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KnightWhite(dest);
    }
}
