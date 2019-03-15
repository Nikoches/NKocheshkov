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
}
