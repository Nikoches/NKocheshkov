package ru.job4j.solidprinc.isp;

public interface Element extends ElementMethod, ElementPrint {
    void addElement(Element element);

    int getLvl();

    String getName();
}
