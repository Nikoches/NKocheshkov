package ru.job4j.SolidPrinc.Isp;

import java.util.ArrayList;

public class CElement implements Element {
    private ArrayList<Element> elements = new ArrayList<>();
    private int lvl;
    private String name;

    public String getName() {
        return this.name;
    }

    public CElement(String name, int lvl) {
        this.name = name;
        this.lvl = lvl;
    }

    @Override
    public void addElement(Element element) {
        this.elements.add(element);
    }

    @Override
    public int getLvl() {
        return this.lvl;
    }

    @Override
    public void doit() {
        System.out.println("SMTH");
    }

    @Override
    public void print() {
        System.out.println(this.name + " " + this.lvl);
        if (!this.elements.isEmpty()) {
            for (Element e : elements) {
                System.out.println(e.getName() + " " + e.getLvl());
            }
        }
    }
}
