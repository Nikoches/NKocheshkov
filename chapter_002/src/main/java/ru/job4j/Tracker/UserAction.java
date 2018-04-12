package ru.job4j.Tracker;

public interface UserAction {
    int key();
    void execute(Input input,Tracker tracker);
    String info();
}
