package job4j.javaio;

import org.junit.Test;
import ru.job4j.javaio.Analizy;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Analizytest {
    @Test
    public void testAnalizy() {
        Analizy ss = new Analizy();
        StringBuffer bufer = new StringBuffer();
        ss.unavailable("C:\\Projects\\server.log", "C:\\Projects\\unavailable.csv");
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Projects\\unavailable.csv"))) {
            String s;
            while ((s = br.readLine()) != null) {
                bufer.append(s);
            }
        } catch (IOException ex) {
            ex.printStackTrace();

        }
        StringBuffer bufer2 = new StringBuffer();
        bufer2.append("400 11:03:20500 11:03:46400 11:04:00");
        assertThat(bufer2, is(bufer));


    }
}
