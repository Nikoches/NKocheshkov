package Bomberman;

public class MainGame {
    public static void main(String[] args) {
        Thread player2 = new Thread(new Enemy(3,3));
        Thread player1 = new Thread(new Player());
        player1.start();
        player2.start();
    }
}
