package ru.job4j.TicTac;

public class Menu {
    private LogicGame logicGame;

    public static void main(String[] args) {
        new Menu().start();
    }

    /*
    Отображение стартового меню
     */
    private void show() {
        do {
            int[] ss = Asker.askCord("Добро пожаловать, выберите режим:\n 1.Игра с игроком.\n 2.Игра с пк.\n3.Игра Пк-Пк\nЧерез пробел укажите размер поля");
            logicGame = LogicGame.getInstance(ss[0], ss[1]);
            if (logicGame != null) {
                break;
            }
            System.out.println("Укажите корректные поля и режим.");
        }
        while (logicGame == null);
    }

    /*
    Старт игры
    Инициализация логики и отображения меню.
     */
    public void start() {
        int i;
        do {
            show();
            logicGame.startGame();
            i = Asker.ask("Повторить?\n1- повторить\n2- выход");
        } while (i != 2);
    }

}
