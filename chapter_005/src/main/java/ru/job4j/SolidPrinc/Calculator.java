package ru.job4j.SolidPrinc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Calculator {
    private UserInput userInput;
    private Calc calc;
    private Menu menu;
    private final Map<String , Function<Double, Boolean>> dispatch = new HashMap<>();
    public Calculator(Calc cc, UserInput us, Menu menu) {
        calc = cc;
        userInput = us;
        this.menu = menu;
    }

    public void setMenu() {
        do {
            menu.printOperation();
            System.out.println(calc.getres(userInput.read()).apply(userInput.read(),userInput.read()));
            System.out.println("exit?");
        }while (!userInput.read().equals("y"));
    }

    public static void main(String[] args) {
        Calculator cc = new Calculator(new Calc(),new UserInput(),new Menu());
        cc.setMenu();
    }

}
