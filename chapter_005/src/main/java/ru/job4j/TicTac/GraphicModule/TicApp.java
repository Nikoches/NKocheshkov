package ru.job4j.TicTac.GraphicModule;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.job4j.TicTac.LogicGame;


public class TicApp extends Application {

    @FXML
    GridPane gridPane;
    private LogicGame logicGame;
    private char[][] playtable = new char[3][3];
    private int clicker=0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/TicTacSample.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void click(ActionEvent event) {
        Button btn = (Button) event.getSource();
        move(GridPane.getRowIndex(btn), GridPane.getColumnIndex(btn), btn);
        clicker++;
        computerMove();
        clicker++;
    }

    private void move(int x, int y, Button btn) {
        if (playtable[x][y] != 'X' && playtable[x][y] != 'O') {
            playtable[x][y] = 'X';
            btn.setText("X");
        }
        btn.setDisable(true);
    }

    private void computerMove() {
        if(clicker==8) {
            return;
        }
        int x, y;
        char c;
        Button btn;
        do {
            x = (int) (Math.random() * 3);
            y = (int) (Math.random() * 3);
            c = playtable[x][y];
        } while (c == 'O' || c == 'X');
            playtable[x][y]='O';
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == x && GridPane.getRowIndex(node) == y) {
                btn = (Button) node;
                System.out.println(GridPane.getRowIndex(btn) +" "+ GridPane.getColumnIndex(btn));
                btn.setText("O");
                btn.setDisable(true);
                break;
            }
        }
    }
}
