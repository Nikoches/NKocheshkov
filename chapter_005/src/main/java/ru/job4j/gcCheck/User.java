package ru.job4j.gcCheck;

public class User {
    public User(String name){
        this.name = name;
    }
    private static Integer first = 12;
    private String second = "";
    private String name;
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
    public void generator(int i){
        for (;i<10000;i++){
            User user = new User("valera");
        }
    }
}
