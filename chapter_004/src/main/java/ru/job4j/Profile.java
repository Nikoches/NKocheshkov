package ru.job4j;
/**
 * Package  stream task.
 *
 * @author Nikita Kocheshkov (nikoches@yandex.ru)
 * @version $Id$
 */

public class Profile {

    private Adress adress;

    public Profile(Adress adress) {
        this.adress = adress;
    }

    public Adress getAdress() {
        return this.adress;
    }

    @Override
    public String toString() {
        return adress.toString();
    }
}
