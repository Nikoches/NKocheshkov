package ru.job4j.TicTac;

public class Menu {
    private LogicGame logicGame;

    public static void main(String[] args) {
        new Menu().start();
    }

    /*
    Отображение стартового меню
     */
    private void show(String...args) {
        do {
            int[] ss = Aske.askCord("Добро пожаловать, выберите режим:\n 1.Игра с игроком.\n 2.Игра с пк \n3.Игра Пк-Пк\nЧерез пробел укажите размер поля");
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
    public void start(String...args) {
        int i;
        do {
            show(args);
            logicGame.startGame();
            i = Aske.ask("Повторить?\n1- повторить\n2- выход");
        } while (i != 2);
    }

}
