package ru.job4j.chess;

public class Special {
    protected int d1;

    public int direction(int xd, int xs, int yd, int ys) {
        if (xd > xs && yd > ys) {
            d1 = 0;
        } else if (xd < xs && yd > ys) {
            d1 = 1;
        } else if (xd < xs && yd < ys) {
            d1 = 2;
        } else if (xd > xs && yd < ys) {
            d1 = 3;
        }else d1 =13;
        return d1;
    }
    public int direct(int xd, int xs, int yd, int ys) {
        if (xd == xs && yd>ys) {
            d1 = 4;
        } else if (xd == xs && yd<ys) {
            d1 = 5;
        } else if (xd > xs && yd == ys) {
            d1 = 6;
        } else if (xd < xs && yd == ys) {
            d1 = 7;
        }
        return d1;


    }
}



