package ru.job4j.magnit;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Entrys {
    private List<Entry> values;

    public Entrys() {

    }

    public Entrys(List<Entry> values) {
        this.values = values;
    }

    public List<Entry> getValues() {
        return values;
    }

    public void setValues(List<Entry> values) {
        this.values = values;
    }

}
