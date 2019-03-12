import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Profiles {
    public List<Adress> collect (List < Profile > profiles, Function<Profile,Adress> ded) {

    return  profiles.stream()
            .map(ded)
            .collect(Collectors.toList());
    }
}
