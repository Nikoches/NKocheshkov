package ru.job4j.SolidPrinc.Lisp;

import java.util.Date;

public class Food {
    private String name;
    private Date created;
    private int price;
    private long expire;
    private boolean discount;
    private long qtime;
    private long quality;

    public Food(String name, Date created, int price, long expire, long qtime) {
        this.name = name;
        this.created = created;
        this.price = price;
        this.expire = expire;
        this.qtime = qtime;
        this.quality = (new Date(System.currentTimeMillis()).getTime() - created.getTime()) * 100 / qtime > 0 ? (new Date(System.currentTimeMillis()).getTime() - created.getTime()) * 100 / qtime : 0;
    }

    public void setDiscount() {
        this.discount = true;
    }

    public String getName() {
        return this.name;
    }

    public long getExpireData() {
        return this.expire;
    }

    public Date getCreated() {
        return this.created;
    }

    public int getPrice() {
        return this.price;
    }

    public long getQuality() {
        return this.quality;
    }

    public static class Cheese extends Food {
        public Cheese(String name, Date created, int price, long expire, long qtime) {
            super(name, created, price, expire, qtime);
        }
    }

    public static class Milk extends Food {
        public Milk(String name, Date created, int price, long expire, long qtime) {
            super(name, created, price, expire, qtime);
        }
    }

    public static class Bread extends Food {
        public Bread(String name, Date created, int price, long expire, long qtime) {
            super(name, created, price, expire, qtime);
        }
    }
}
