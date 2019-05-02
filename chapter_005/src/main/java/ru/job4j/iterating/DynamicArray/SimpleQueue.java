package ru.job4j.iterating.DynamicArray;

public class SimpleQueue<T> {
    SimpleStack<T> queue1 = new SimpleStack<>();
    SimpleStack<T> queue2 = new SimpleStack<>();
    private int stack1 = 0;
    public T poll() {
        for(int i = 0;i < stack1;i++){
            queue2.push(queue1.poll());
        }
        stack1 = 0;
        return  queue2.poll();
    }

    public void push(T value) {
       stack1++;
       queue1.push(value);
        }
    }

