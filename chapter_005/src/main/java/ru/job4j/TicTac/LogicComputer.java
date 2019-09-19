package ru.job4j.TicTac;

public class LogicComputer extends Player {

    public LogicComputer(int size) {
        super(size);
    }

    @Override
    public int[] move(char[][] playtable) {
        int x, y;
        char c;
        do {
            x = (int) (Math.random() * size);
            y = (int) (Math.random() * size);
            c = playtable[x][y];
        } while (c == 'O' || c == 'X');
        playtable[x][y] = 'O';
        return new int[]{x, y};
    }

}
