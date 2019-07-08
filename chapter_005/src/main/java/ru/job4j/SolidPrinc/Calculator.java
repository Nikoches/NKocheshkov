package ru.job4j.SolidPrinc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {
    private double prev;

    private void add(double first, double second) {
         this.prev = first + second;
    }

    private void subtract(double first, double second) {
         this.prev = first - second;
    }

    private void multiple(double first, double second) {
         this.prev = first * second;
    }

    private void div(double first, double second) {
         this.prev = first / second;
    }

    public void menu() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
           do{
                System.out.println("Input values:");
                String ask1 = reader.readLine();
                String ask2 = reader.readLine();
                double x = ask1.equals("prev")?prev:Double.valueOf(ask1);
                double y = ask2.equals("prev")?prev:Double.valueOf(ask2);
                    System.out.println("Act:\n1=add\n2=subsctract\n3=multiply\n4=div");
                    String act;
                    act = reader.readLine();
                    switch (act) {
                        case "1":
                            add(x, y);
                            break;
                        case "2":
                            subtract(x, y);
                            break;
                        case "3":
                            multiple(x, y);
                            break;
                        case "4":
                            div(x, y);
                            break;
                    }
                    System.out.println("res = " + this.prev+" x="+x+" y="+y);
                System.out.println("exit?");
            } while (!reader.readLine().equals("y"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Calculator ss = new Calculator();
        ss.menu();
    }
}
