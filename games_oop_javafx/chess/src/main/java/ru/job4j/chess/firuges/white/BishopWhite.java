package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
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
        int x1=source.x,y1=source.y;
        if (dest.y>source.y && dest.x>source.x) {
            for (;x1<=7 && y1<=7;x1++,y1++){
                if (dest.x==x1 & dest.y==y1){
                    steps = new Cell[] { dest };
                    break;
                }
            }
        }else if (dest.y<source.y && dest.x<source.x) {
            for (;x1>=0 && y1>=0;x1--,y1--){
                if (dest.x==x1 & dest.y==y1){
                    steps = new Cell[] { dest };
                    break;
                }
            }
        }else if (dest.y>source.y && dest.x<source.x) {
            for (;x1>=0 && y1<=7;x1--,y1++){
                if (dest.x==x1 & dest.y==y1){
                    steps = new Cell[] { dest };
                    break;
                }
            }
        }else if (dest.y<source.y && dest.x>source.x) {
            for (;x1<=7 && y1>=0;x1++,y1--){
                if (dest.x==x1 & dest.y==y1){
                    steps = new Cell[] { dest };
                    break;
                }
            }
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
