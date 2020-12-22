package ru.job4j.tracker.di;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<String> data = new ArrayList<String>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
