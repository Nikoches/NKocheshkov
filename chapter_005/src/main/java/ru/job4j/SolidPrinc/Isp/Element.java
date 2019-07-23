package ru.job4j.SolidPrinc.Isp;

public interface Element extends ElementMethod,ElementPrint {
    public void addElement(Element element);
    public int getLvl();
}
