package ru.job4j.SolidPrinc.Isp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CElement implements Element {
    private ArrayList<Element> elements = new ArrayList<>();
    private int lvl;
    private String name;

    public CElement(String name, int lvl) {
        this.name = name;
        this.lvl = lvl;
    }

    public String getName() {
        return this.name;
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
        LinkedList<Element> cElements = new LinkedList<>(getAll());
        while (!cElements.isEmpty()) {
            Element cc = cElements.poll();
            cElements.addAll(cc.getAll());
            cc.print();
            System.out.println(cc.getName() + " " + cc.getLvl());
        }
    }

    public List<Element> getAll() {
        return this.elements;
    }
}
