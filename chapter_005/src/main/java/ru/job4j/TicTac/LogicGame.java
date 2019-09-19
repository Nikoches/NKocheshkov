package ru.job4j.TicTac;

public class LogicGame {
    private char[][] playtable;
    private Player firstPlayer;
    private Player secondPlayer;
    private WinChecker winChecker;

    /*
    Конструктор с выборож режима и игрока.
     */
    private LogicGame(Player player, int size) {
        firstPlayer = new RealPlayer(size);
        playtable = new char[size][size];
        secondPlayer = player;
        winChecker = new WinChecker();
    }

    /*
    Проверка введных полей mode и size.
     */
    public static LogicGame getInstance(int mode, int size) {
        LogicGame logicGame = null;
        if (size != 3 && size != 5) {
            return logicGame;
        }
        if (mode == 1) {
            logicGame = new LogicGame(new RealPlayer(size), size);
        } else if (mode == 2) {
            logicGame = new LogicGame(new LogicComputer(size), size);
        }
        return logicGame;
    }

    public int startGame() {
        int playerCounter = 0;
        Player[] players = new Player[]{firstPlayer, secondPlayer};
        printPlayTable(this.playtable);
        while (!winChecker.checkAll()) {
            players[playerCounter].move(this.playtable);
            printPlayTable(this.playtable);
            playerCounter = playerCounter == 0 ? 1 : 0;
        }
        System.out.println("END OF GAME PLAYER=" + playerCounter);
        return playerCounter;
    }

    /*
        Печать поля.
     */
    private void printPlayTable(char[][] playtable) {
        for (char[] x : playtable) {
            for (char a : x) {
                System.out.print("|" + a);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("----------------------");
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

