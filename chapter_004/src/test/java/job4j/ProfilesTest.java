package job4j;

import org.junit.Test;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ProfilesTest {

    @Test
    public void creatingProfilis() {
            Profiles link = new Profiles();
            LinkedList<Profile> profiles = new LinkedList<>();
            profiles.add(new Profile(new Adress("SPB", "Popova", 10, 4)));
            profiles.add(new Profile(new Adress("SPB", "Popova", 12, 3)));
            profiles.add(new Profile(new Adress("SPB", "Popova", 666, 42)));
            profiles.add(new Profile(new Adress("SPB", "Popova", 7, 4)));
            List<Adress> chkadresa = new LinkedList<>();
            chkadresa.add(new Adress("SPB", "Popova", 10, 4));
            chkadresa.add(new Adress("SPB", "Popova", 12, 3));
            chkadresa.add(new Adress("SPB", "Popova", 666, 42));
            chkadresa.add(new Adress("SPB", "Popova", 7, 4));
            List<Adress> adresa;
            adresa = link.collect(profiles);
            assertThat(adresa, is( chkadresa));
        }
    @Test
    public void checkingMathes() {
        Profiles pro = new Profiles();
        List<Profile> profili = pro.checkingMathes();
        System.out.println(profili);
        }
    }

