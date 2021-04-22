package ru.job4j.tictac;

import java.util.function.Consumer;

public class LogicGame {
    private final char[][] playtable;
    private final Player firstPlayer;
    private final Player secondPlayer;
    private final WinChecker winChecker;
    private Consumer printDriver;
    private final Consumer<char[][]> printPlayTableTypeOne = playtable -> {
        System.out.println("_______");
        for (char[] x : playtable) {
            for (char a : x) {
                System.out.print("|" + a);
            }
            System.out.println("|");
            System.out.println("_______");
        }
        System.out.println("************************");
    };
    private final Consumer<char[][]> printPlayTableTypeTwo = playtable -> {
        System.out.println("************************");
        for (char[] x : playtable) {
            for (char a : x) {
                System.out.print("|" + a);
            }
            System.out.print("|");
            System.out.println("************************");
        }
        System.out.println("************************");
    };

    /*
    Конструктор с выборож режима и игрока.
     */
    private LogicGame(Player playerF, Player playerS, int size) {
        firstPlayer = playerF;
        playtable = new char[size][size];
        secondPlayer = playerS;
        winChecker = new WinChecker();
    }

    /*
        Печать поля.
     */

    /*
    Проверка введных полей mode и size.
     */
    public static LogicGame getInstance(int mode, int size) {
        LogicGame logicGame = null;
        if (size != 3 && size != 5) {
            return logicGame;
        }
        if (mode == 1) {
            logicGame = new LogicGame(new RealPlayer(size, 'X'), new RealPlayer(size, 'O'), size);
        } else if (mode == 2) {
            logicGame = new LogicGame(new RealPlayer(size, 'X'), new LogicComputer(size, 'O'), size);
        } else if (mode == 3) {
            logicGame = new LogicGame(new LogicComputer(size, 'X'), new RealPlayer(size, 'O'), size);
        }
        return logicGame;
    }

    public int startGame() {
        printDriver = Aske.ask("Выберите отображение 1/2 :") == 1 ? printPlayTableTypeOne : printPlayTableTypeTwo;
        int playerCounter = 0;
        Player[] players = new Player[]{firstPlayer, secondPlayer};
        printDriver.accept(this.playtable);
        while (!winChecker.checkAll()) {
            players[playerCounter].move(this.playtable);
            printDriver.accept(this.playtable);
            playerCounter = playerCounter == 0 ? 1 : 0;
        }
        System.out.println("END OF GAME PLAYER=" + playerCounter);
        return playerCounter;
    }

    private class WinChecker {
        /**
         * Проверка всех полей на победу,универсально для размеров поля.
         *
         * @return boolean;
         */
        public boolean checkAll() {
            return checkHorizontal() || checkVertical() || checkDiagonalOne() || checkDiagonalTwo();
        }

        private boolean checkHorizontal() {
            boolean returned = false;
            for (int i = 0; i < playtable[0].length; i++) {
                char x = playtable[i][0];
                for (int j = 0; j < playtable[0].length; j++) {
                    returned = true;
                    if (playtable[i][j] != x || x == '\u0000') {
                        returned = false;
                        break;
                    }
                }
                if (returned) {
                    return returned;
                }
            }
            return returned;
        }

        private boolean checkVertical() {
            boolean returned = false;
            for (int i = 0; i < playtable[0].length; i++) {
                char x = playtable[0][i];
                for (int j = 0; j < playtable[0].length; j++) {
                    returned = true;
                    if (playtable[j][i] != x || x == '\u0000') {
                        returned = false;
                        break;
                    }
                }
                if (returned) {
                    return returned;
                }
            }
            return returned;
        }

        private boolean checkDiagonalTwo() {
            boolean returned = false;
            char x = playtable[0][0];
            for (int i = 0; i < playtable[0].length; i++) {
                returned = true;
                if (playtable[i][i] != x || x == '\u0000') {
                    returned = false;
                    break;
                }
            }
            return returned;
        }

        private boolean checkDiagonalOne() {
            boolean returned = false;
            char x = playtable[0][0];
            for (int i = 0; i < playtable[0].length; i++) {
                returned = true;
                if (playtable[i][i] != x || x == '\u0000') {
                    returned = false;
                    break;
                }
            }
            return returned;
        }
    }
}

