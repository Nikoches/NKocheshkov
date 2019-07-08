package ru.job4j.SolidPrinc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {
    private double prev;

    private double add(double first, double second) {
        return this.prev = first + second;
    }

    private double subtract(double first, double second) {
        return this.prev = first - second;
    }

    private double multiple(double first, double second) {
        return this.prev = first * second;
    }

    private double div(double first, double second) {
        return this.prev = first / second;
    }

    public void menu() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            do {
                System.out.println("Input values:");
                String ask1 = reader.readLine();
                //String ask2 = reader.readLine();
                double x = ask1.equals("prev")?Double.valueOf(prev):Double.valueOf(ask1);
                double y = ask1.equals("prev")?Double.valueOf(prev):Double.valueOf(ask1);
                    System.out.println("Act:\n1=add\n2=subsctract\n3=multiply\n4=div\n5=res");
                    int act;
                    act = reader.read();
                    switch (act) {
                        case 1:
                            add(x, y);
                        case 2:
                            subtract(x, y);
                        case 3:
                            multiple(x, y);
                        case 4:
                            div(x, y);
                    }
                    System.out.println("res = " + this.prev);
                System.out.println("exit?");
            } while (!reader.readLine().equals("y"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
