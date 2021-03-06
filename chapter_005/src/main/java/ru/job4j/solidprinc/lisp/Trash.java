package ru.job4j.solidprinc.lisp;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {
    public ArrayList<Food> str = new ArrayList<>();
    private int capacity = 0;

    @Override
    public void add(Food food) {
        capacity++;
        this.str.add(food);
    }

    @Override
    public List<Food> getFood() {
        return this.str;
    }

    @Override
    public boolean accept(Food food) {
        return food.getQuality() < 0;
    }

    @Override
    public boolean getSpace() {
        return capacity <= 10;
    }

    @Override
    public Storage getExpansion() {
        return new Trash();
    }

    @Override
    public String getMark() {
        return "usual";
    }
}
