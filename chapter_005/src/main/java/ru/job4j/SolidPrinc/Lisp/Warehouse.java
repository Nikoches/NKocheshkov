package ru.job4j.SolidPrinc.Lisp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    public ArrayList<Food> str = new ArrayList<>();
    private int capacity = 0;

    @Override
    public void add(Food food) {
        this.str.add(food);
    }

    @Override
    public List<Food> getFood() {
        return this.str;
    }

    @Override
    public boolean accept(Food food) {
        return 0 < food.getQuality() & food.getQuality() < 25;
    }
    @Override
    public boolean getSpace() {
        return capacity <= 10;
    }

    @Override
    public Storage getExpansion() {
        return new Warehouse();
    }
    @Override
    public String getMark() {
        return "usual";
    }
}
