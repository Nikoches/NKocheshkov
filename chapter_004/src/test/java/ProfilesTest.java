import org.junit.Test;
import java.util.LinkedList;
import java.util.stream.Collectors;
public class ProfilesTest {

    @Test
    public void creatingProfilis() {
            LinkedList<Adress> adreses = new LinkedList<>();
            LinkedList<Profile> profili;
            adreses.add(new Adress("SPB", "Popova", 10, 4));
            adreses.add(new Adress("SPB", "Popova", 666, 4));
            adreses.add(new Adress("SPB", "Popova", 122, 4));
            adreses.add(new Adress("SPB", "Popova", 7, 4));
            profili = adreses.stream()
                    .map(Profile::new)
                    .collect(Collectors.toCollection(LinkedList::new));
            System.out.println(profili);
        }

    }

