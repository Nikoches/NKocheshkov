package job4j;



import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Adress> collect (List <Profile> profiles) {
        LinkedList<Adress> adreses = profiles.stream()
                .map(Profile::getAdress)
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(adreses);
        return adreses;
    }
    public List<Profile> checkingMathes() {
        LinkedList<Adress> adreses = new LinkedList<>();
        LinkedList<Profile> profili;
        adreses.add(new Adress("SPB", "Popova", 10, 4));
        adreses.add(new Adress("Msk", "Popova", 666, 4));
        adreses.add(new Adress("SPB", "Popova", 7, 4));
        adreses.add(new Adress("SPB", "Popova", 7, 4));
        profili = adreses.stream()
                .distinct()
                .sorted(Adress::compareTo)
                .map(Profile::new)
                .collect(Collectors.toCollection(LinkedList::new));
        return profili;
    }
}
