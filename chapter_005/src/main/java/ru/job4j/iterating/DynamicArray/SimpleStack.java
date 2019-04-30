package ru.job4j.iterating.DynamicArray;

public class SimpleStack<T> {
    DynArrayList<T> stack;

    public T poll() {
        T value = stack.get(stack.getSize());
        stack.remove();
        return value;
    }

    public void push(T value) {
        stack.add(value);
    }
}
