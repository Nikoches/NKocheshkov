package ru.job4j.gccheck;

public class User {
    private static final Integer FIRST = 12;
    private final String second = "";
    private final String name;
    public User(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws Throwable {
        System.out.println("Start");
        User s = new User("valera");
        s.generator(1);
        System.out.println("Finish");
    }

    @Override
    public String toString() {
        return "Name: " + this.name;
    }

    @Override
    public void finalize() throws Throwable {
        System.out.println("OUT");
        super.finalize();
    }

    public void generator(int i) {
        for (; i < 10000; i++) {
            User user = new User("valera");
        }
    }
}
