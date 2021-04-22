package ru.job4j.solidprinc.lisp;

import java.util.List;

public interface Storage extends Markable {
    void add(Food food);

    List<Food> getFood();

    boolean accept(Food food);

    boolean getSpace();

    Storage getExpansion();
}
