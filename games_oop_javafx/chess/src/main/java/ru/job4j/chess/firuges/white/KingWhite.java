package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.Special;
/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class KingWhite extends Special implements Figure  {
    private final Cell position;

    public KingWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[0];
        switch (direct(dest.x, source.x, dest.y, source.y)){
            case 4: if ( source.y+1 == dest.y){ steps = new Cell[] {dest};} break;
            case 5: if ( source.y-1 == dest.y){ steps = new Cell[] {dest};} break;
            case 6: if ( source.x+1 == dest.x){ steps = new Cell[] {dest};} break;
            case 7: if ( source.x-1 == dest.x){ steps = new Cell[] {dest};} break;
        }
        switch (direction(dest.x, source.x, dest.y, source.y)) {
            case 0:
                if (source.x + 1 == dest.x && source.y + 1 == dest.y) {
                    steps = new Cell[]{dest};
                }
                break;
            case 1:
                if (source.x - 1 == dest.x && source.y + 1 == dest.y) {
                    steps = new Cell[]{dest};
                }
                break;
            case 2:
                if  (source.x - 1 == dest.x && source.y - 1 == dest.y){
                    steps = new Cell[]{dest};
                }
                break;
            case 3:
                if (source.x + 1 == dest.x && source.y - 1 == dest.y) {
                    steps = new Cell[]{dest};
                }
                break;
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new KingWhite(dest);
    }
}
