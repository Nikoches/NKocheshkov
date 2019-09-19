package ru.job4j.TicTac;

public abstract class Player {
    public int size;
    public Player(int size) {
        this.size = size;
    }

    abstract int[] move(char[][] playtable);
}
