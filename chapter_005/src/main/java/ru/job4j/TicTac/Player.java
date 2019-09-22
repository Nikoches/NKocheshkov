package ru.job4j.TicTac;

public abstract class Player {
    public int size;
    public char point;
    public Player(int size,char point) {
        this.size = size;
        this.point =point;
    }

    abstract int[] move(char[][] playtable);
}
