package ru.job4j.magnit;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Entry {
    @XmlElement
    private  int field;
    public  int getField() {
        return field;
    }
    public Entry(){

    }
    public Entry(int field) {
        this.field = field;
    }
}
