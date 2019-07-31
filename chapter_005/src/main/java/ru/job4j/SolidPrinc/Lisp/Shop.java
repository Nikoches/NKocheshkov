package ru.job4j.SolidPrinc.Lisp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
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
        if (food.getQuality() > 75 & food.getQuality() < 100){
            food.setDiscount();
            return true;
        }return false;
    }

    @Override
    public boolean getSpace() {
        return capacity <= 10;
    }

    @Override
    public Storage getExpansion() {
        return new Shop();
    }

    @Override
    public String getMark() {
        return "usual";
    }
}
