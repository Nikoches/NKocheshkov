package ru.job4j.solidprinc.lisp;

import java.util.Date;

public class Food implements Markable {
    private final String name;
    private final Date created;
    private final int price;
    private final long expire;
    private boolean discount;
    private final long qtime;
    private final long quality;

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

    @Override
    public String getMark() {
        return "usual";
    }

    public static class Cheese extends Food {
        public Cheese(String name, Date created, int price, long expire, long qtime) {
            super(name, created, price, expire, qtime);
        }

        @Override
        public String getMark() {
            return "usual";
        }
    }

    public static class Milk extends Food {
        public Milk(String name, Date created, int price, long expire, long qtime) {
            super(name, created, price, expire, qtime);
        }

        @Override
        public String getMark() {
            return "usual";
        }
    }

    public static class Bread extends Food {
        public Bread(String name, Date created, int price, long expire, long qtime) {
            super(name, created, price, expire, qtime);
        }

        @Override
        public String getMark() {
            return "usual";
        }
    }

    public static class Vegetable extends Food implements Markable {
        public Vegetable(String name, Date created, int price, long expire, long qtime) {
            super(name, created, price, expire, qtime);
        }

        @Override
        public String getMark() {
            return "vegetable";
        }
    }

}
