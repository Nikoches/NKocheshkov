package ru.job4j;

public class Triangle implements Shape {
    public String draw() {
    StringBuilder pic = new StringBuilder();
        pic.append("   *  ");
        pic.append("  *** ");
        pic.append(" ***** ");
        return pic.toString();
    }
}
