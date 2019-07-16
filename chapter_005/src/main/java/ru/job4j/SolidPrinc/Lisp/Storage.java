package ru.job4j.SolidPrinc.Lisp;

import java.util.List;

public interface Storage {
    public void add(Food food);
    public List<Food> getFood();
}
