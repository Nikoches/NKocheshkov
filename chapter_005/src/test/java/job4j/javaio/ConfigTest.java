package job4j.javaio;

import org.junit.Test;
import ru.job4j.javaio.Config;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
public class ConfigTest {

    @Test
    public void readingfile() {
        Config con =  new Config("C:\\Projects\\app.properties");
        con.load();
        assertThat(con.value("hibernate.connection.username"),is("postgres"));


    }
}
