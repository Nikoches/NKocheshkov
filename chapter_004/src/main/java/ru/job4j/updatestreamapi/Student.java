package ru.job4j.updatestreamapi;

import java.util.Comparator;

/**
 * Package for new features stream task.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */
public class Student implements Comparator<Student> {
    /** Поле имя */
    private String name;
    /** Поле кол-во баллов */
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }
        @Override
        public int compare(Student a, Student b){int rez;
        if (a == null && b == null) {
        rez = 0;
    } else if (a == null) {
        rez = 1;
    } else if (b == null) {
        rez = -1;
    } else {
        rez = Integer.compare(b.getScope(), a.getScope());
    }
        return rez;
        }
        @Override
        public boolean equals(final Object obj) {
            if (obj == null || !this.getClass().equals(obj.getClass())) {
                return false;
         }
            final Student std = (Student) obj;
            if (this == std) {
             return true;
            } else {
                return (this.name.equals(std.name) && (this.scope == std.scope));
            }
    }
        @Override
        public int hashCode() {
            int hashno = 7;
            hashno = 13 * hashno + (name == null ? 0 : name.hashCode());
            return hashno;
        }
    /** @return scope */
    public int getScope() {
        return this.scope;
    }
    public String toString() {
        return "Name=" + " " + this.name + " " + "Scope=" + this.scope;
    }
}
