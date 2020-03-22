package Bomberman;

public class Enemy extends Playable implements Runnable {
    public Enemy(int x, int y) {
       super(x,y);
    }

    public Enemy() {
        super();
    }
    @Override
    public void run() {
        while (true) {
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
}
