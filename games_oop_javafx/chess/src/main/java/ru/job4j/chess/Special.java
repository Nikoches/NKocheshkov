package ru.job4j.chess;

public class Special {
    int d1,nn;

    public int direction(int xd, int xs, int yd, int ys) {
        if (yd > ys && xd > xs) {
            d1 = 0;
        } else if (yd < ys && xd < xs) {
            d1 = 1;
        } else if (yd < ys && xd > xs) {
            d1 = 2;
        } else if (yd > ys && xd < xs) {
            d1 = 3;
        }
        return d1;
    }
}



