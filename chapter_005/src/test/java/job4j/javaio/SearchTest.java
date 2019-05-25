package job4j.javaio;

import org.junit.Test;
import ru.job4j.javaio.Search;

import java.util.LinkedList;
import java.util.List;

public class SearchTest {


    @Test
    public void testSearch() {
        Search ss = new Search();
        List<String> listofexts = new LinkedList<>();
        listofexts.add("txt");
        System.out.println(ss.files("ss", listofexts));

    }
}