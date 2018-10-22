package ru.job4j.Tracker;

import java.util.*;

public interface Input {
    String ask(String question);
    int ask(String question, List<Integer> ranges);
}
