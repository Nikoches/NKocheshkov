package ru.job4j.iterating;
import org.junit.Test;
import ru.job4j.iterating.Analize;
import java.util.LinkedList;
import java.util.List;
public class Analizetest {

    @Test
    public void testAdd() {
        List<Analize.User> old = new LinkedList<>();
        old.add(new Analize.User(0, "Kol"));
        List<Analize.User> newlist = new LinkedList<>();
        newlist.add(new Analize.User(0, "Kol"));
        newlist.add(new Analize.User(2, "Avz"));
        newlist.add(new Analize.User(1, "vova"));
        Analize az = new Analize();
        Analize.Info info = az.diff(old, newlist);
        System.out.println(info.toString());
    }
    @Test
    public void testChanges() {
        List<Analize.User> old = new LinkedList<>();
        old.add(new Analize.User(0, "Kol"));
        old.add(new Analize.User(1, "Zil"));
        List<Analize.User> newlist = new LinkedList<>();
        newlist.add(new Analize.User(0, "Kol"));
        newlist.add(new Analize.User(1, "Avz"));
        Analize az = new Analize();
        Analize.Info info = az.diff(old, newlist);
        System.out.println(info.toString());
    }
    @Test
    public void testRemove() {
        List<Analize.User> old = new LinkedList<>();
        old.add(new Analize.User(0, "Kol"));
        old.add(new Analize.User(1, "Zil"));
        List<Analize.User> newlist = new LinkedList<>();
        newlist.add(new Analize.User(1, "Zil"));
        Analize az = new Analize();
        Analize.Info info = az.diff(old, newlist);
        System.out.println(info.toString());
    }
    @Test
    public void testAllofthat() {
        List<Analize.User> old = new LinkedList<>();
        old.add(new Analize.User(0, "Kol"));
        old.add(new Analize.User(1, "Zil"));
        old.add(new Analize.User(2, "Avz"));
        List<Analize.User> newlist = new LinkedList<>();
        newlist.add(new Analize.User(0, "Kol"));
        newlist.add(new Analize.User(1, "Avz"));
        newlist.add(new Analize.User(3, "Zaz"));
        Analize az = new Analize();
        Analize.Info info = az.diff(old, newlist);
        System.out.println(info.toString());
    }
}

