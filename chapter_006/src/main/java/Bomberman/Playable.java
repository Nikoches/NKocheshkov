package Bomberman;

public abstract class Playable {
     int coordY = 0;
     int coordX = 0;
     LogicGame logicGame = LogicGame.getInstance();
    public Playable(int x, int y) {
        this.coordY = y;
        this.coordX = x;
    }

    public Playable() {
    }

    public boolean moveY(int y) {
        Cell[][] board = logicGame.getBoard();
        if ((coordY + y) < 9 && (coordY + y) >= 0 && board[coordX][coordY + y].setlock()) {
            board[coordX][coordY].unlock();
            coordY += y;
            return true;
        }
        return false;
    }

    public boolean moveX(int x) {
        Cell[][] board = logicGame.getBoard();
        if ((this.coordX + x) < 9 && (this.coordX + x) >= 0 && board[this.coordX + x][this.coordY].setlock()) {
            board[this.coordX][this.coordY].unlock();
            this.coordX += x;
            return true;
        }
        return false;
    }
    public int getCoordX() {
        return this.coordX;
    }
    public int getCoordY() {
        return this.coordY;
    }
}
