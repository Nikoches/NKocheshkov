package ru.job4j.magnit;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Entry {

    private  int field;

    public  int getField() {
        return field;
    }

    public Entry(int field) {
        this.field = field;
    }
}
