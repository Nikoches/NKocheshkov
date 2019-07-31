package ru.job4j.SolidPrinc.Lisp;

import java.util.List;

public interface Storage extends Markable {
     void add(Food food);
     List<Food> getFood();
     boolean accept(Food food);
     boolean getSpace();
     Storage getExpansion();
}
