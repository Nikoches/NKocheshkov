package Bomberman;

public class LogicGame {
    volatile private Cell[][] board = new Cell[9][9];
    final static private LogicGame logicGame = new LogicGame();
    final private String[][] printedBoard;

    private LogicGame() {
        printedBoard = new String[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                printedBoard[i][j] = "[ ]";
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = new Cell();
            }
        }
        board[0][2].setlock();
        board[2][0].setlock();
    }

    public static LogicGame getInstance() {
        return logicGame;
    }
    //TODO сделать стирание клеток по вертикали и горизонтали
    public synchronized void printBoard(Playable player,int c,int j) {
        if(j==1){
            printedBoard[player.getCoordX()+c][player.getCoordY()]="[ ]";
        }else {
            printedBoard[player.getCoordX()][player.getCoordY()+c]="[ ]";
        }
        printedBoard[player.getCoordX()][player.getCoordY()]="[ ]";
        printedBoard[player.getCoordX()][player.getCoordY()] = "[X]";
        System.out.println("--------------------------------");
        for (String[] x : printedBoard) {
            for (String z : x) {
                System.out.print(z);
            }
            System.out.println();
        }
    }

    public void lockCell(int x, int y) {
        board[x][y].setlock();
    }

    public void unlockCell(int x, int y) {
        board[x][y].unlock();
    }

    public Cell[][] getBoard() {
        return board;
    }
}
