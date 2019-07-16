package ru.job4j.SolidPrinc.Lisp;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
    public ArrayList<Food> str = new ArrayList<>();

    @Override
    public void add(Food food) {
        this.str.add(food);
    }

    @Override
    public List<Food> getFood() {
        return this.str;
    }
}
