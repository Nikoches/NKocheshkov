package ru.job4j.sparser;

public class Vacancy {
    private final String name;
    private final String description;
    private final String date;
    private final String url;

    public Vacancy(String name, String desc, String date, String url) {
        this.name = name;
        this.description = desc;
        this.date = date;
        this.url = url;

    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDate() {
        return this.date;
    }

    public boolean equals(Object obj) {
        boolean equality;
        if (obj == this) {
            equality = true;
        }
        Vacancy vac = (Vacancy) obj;

        equality = vac.getName().equals(this.name);

        if (obj == null || obj.getClass() != this.getClass()) {
            equality = false;
        }
        return equality;
    }

    public int hashCode() {
        int res = 17;
        res = 31 * res + name.hashCode();
        return res;
    }
}
