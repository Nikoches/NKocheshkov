package PingPongApp;


import javafx.scene.shape.Rectangle;

import java.util.Random;

public class RectangleMove implements Runnable {
    final Random random = new Random();
    private final Rectangle rect;

    public RectangleMove(Rectangle rect) {
        this.rect = rect;
    }

    @Override
    public void run() {
        int col = 1;
        while (true) {
            if (this.rect.getX() == 300) {
                col = -1;
            }
            this.rect.setX(this.rect.getX() + col);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}