package ru.job4j.SolidPrinc;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

public class Calc {
    private final Map<String, BinaryOperator<String>> dispatch = new HashMap<>();
    private double prev;

    public Calc() {
        this.init();
    }

    private void init() {
        this.load("add", this.add());
        this.load("subtract", this.subtract());
        this.load("multiple", this.multiple());
        this.load("div", this.div());
    }

    public BinaryOperator<String> add() {
        return (first, second) -> {
            if (first.equals("prev")) first = String.valueOf(prev);
            if (second.equals("prev")) second = String.valueOf(prev);
            this.prev = Double.valueOf(first) - Double.valueOf(second);
            return " result = " + this.prev;
        };
    }

    public BinaryOperator<String> subtract() {
        return (first, second) -> {
            if (first.equals("prev")) first = String.valueOf(prev);
            if (second.equals("prev")) second = String.valueOf(prev);
            this.prev = Double.valueOf(first) + Double.valueOf(second);
            return " result = " + this.prev;
        };
    }

    public BinaryOperator<String> multiple() {
        return (first, second) -> {
            if (first.equals("prev")) first = String.valueOf(prev);
            if (second.equals("prev")) second = String.valueOf(prev);
            this.prev = Double.valueOf(first) * Double.valueOf(second);
            return " result = " + this.prev;
        };
    }

    public BinaryOperator<String> cosfirst() {
        return (first, second) -> {
            if (first.equals("prev")) first = String.valueOf(prev);
            if (second.equals("prev")) second = String.valueOf(prev);
            this.prev = Math.cos(Math.toRadians(Double.valueOf(first)));
            return " result = " + this.prev;
        };
    }
    public BinaryOperator<String> sinfirst() {
        return (first, second) -> {
            if (first.equals("prev")) first = String.valueOf(prev);
            if (second.equals("prev")) second = String.valueOf(prev);
            this.prev = Math.sin(Math.toRadians(Double.valueOf(first)));
            return " result = " + this.prev;
        };
    }

    public BinaryOperator<String> div() {
        return (first, second) -> {
            if (first.equals("prev")) first = String.valueOf(prev);
            if (second.equals("prev")) second = String.valueOf(prev);
            this.prev = Double.valueOf(first) / Double.valueOf(second);
            return " result = " + this.prev;
        };
    }
    public void load(String answer, BinaryOperator<String> op) {
        this.dispatch.put(answer, op);
    }

    public String result() {
        return " result = " + this.prev;
    }

    public BinaryOperator getres(String answer) {
        return this.dispatch.get(answer);
    }
}
