package ru.job4j.SolidPrinc;

public class Calculator {
    private UserInput userInput;
    private Calc calc;
    private Menu menu;

    public Calculator(Calc cc, UserInput us, Menu menu) {
        calc = cc;
        userInput = us;
        this.menu = menu;
    }

    public void setMenu() {
        do {
            menu.printOperation();
            switch (userInput.read()) {
                case "0":
                    menu.printValues();
                    calc.add(userInput.read(), userInput.read());
                    break;
                case "1":
                    menu.printValues();
                    calc.subtract(userInput.read(), userInput.read());
                    break;
                case "2":
                    menu.printValues();
                    calc.multiple(userInput.read(), userInput.read());
                    break;
                case "3":
                    menu.printValues();
                    calc.div(userInput.read(), userInput.read());
                    break;
            }
            System.out.println("exit?");
        }while (!userInput.read().equals("y"));
    }

    public static void main(String[] args) {
        Calculator cc = new Calculator(new Calc(),new UserInput(),new Menu());
        cc.setMenu();
    }

}
