package ru.job4j.iterating.DynamicArray;

public class SimpleStack<T> {
    DynArrayList<T> stack = new DynArrayList<>();

    public T poll() {
        T value = stack.get(0);
        stack.remove();
        return value;
    }

    public void push(T value) {
        stack.add(value);
    }
}
