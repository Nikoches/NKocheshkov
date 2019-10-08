package ru.job4j.TicTac;

public class RealPlayer extends Player {

    public RealPlayer(int size,char point) {
        super(size,point);
    }

    @Override
    public int[] move(char[][] playtable) {
        int[] answ;
        do {
            answ = Aske.askCord("Ваш ход:");
            if (answ[0] < size && answ[1] < size) {
                char c = playtable[answ[0]][answ[1]];
                if (c != 'X' && c != 'O') {
                    playtable[answ[0]][answ[1]] = point;
                    break;
                }
            }
            System.out.println("Введите верные координаты точки.");
        } while (true);
        return answ;
    }
}
