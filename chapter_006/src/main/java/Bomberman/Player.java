package Bomberman;

public class Player extends Playable implements Runnable {

    public Player(int x, int y) {
        super(x, y);
    }
    public Player(){
        super();
    }

    @Override
    public void run() {
        //TODO сделать задержку проверки
        moveX(0);
        moveY(0);
        while (!Thread.currentThread().isInterrupted()) {
            if (moveX(1)) {
                logicGame.printBoard(this, 1,1);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (moveY(1)) {
                logicGame.printBoard(this, 1,0);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                Thread.currentThread().interrupt();
            }
        }
    }
}
