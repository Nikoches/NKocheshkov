package job4j.iterating.Map;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterating.map.Simplemap;
import ru.job4j.iterating.map.User;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

public class Mapofuserstest {
    private HashMap<User, Object> mymap;
    @Before
    public void before() {
      mymap = new HashMap<>();
    }

    @Test
    public void printingMap() {
        mymap.put(new User("Vova", 0, Calendar.getInstance()), new Object());
        mymap.put(new User("Vova", 0, Calendar.getInstance()), new Object());
        System.out.println(new User("Vova", 0, Calendar.getInstance()).equals(new User("Vova", 0, Calendar.getInstance())));
        System.out.println(new User("Vova", 0, Calendar.getInstance()).hashCode() == new User("Vova", 0, Calendar.getInstance()).hashCode());
        System.out.println(mymap);
    }
    @Test
    public void myMap() {
         Simplemap<Integer, String> mymap = new Simplemap<>();
         mymap.insert(0, "ss");

        Iterator<String> it = mymap.iterator();
        System.out.println(it.hasNext());
        System.out.println(it.hasNext());
        System.out.println(it.next());
    }

}