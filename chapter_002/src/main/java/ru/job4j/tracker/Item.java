package ru.job4j.tracker;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "items")

public class Item {
    @Id
    private String id;
    private String name;
    private String description;
    private long create;
    public Item(String learnHibernate) {
    }
    public Item() {

    }

    Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public long getCreate() {
        return this.create;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toString() {
        return "name = " + this.name + " desc = " + this.description + " created = " + this.create + " id = " + this.id;
    }
}