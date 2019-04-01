package search;

import java.util.ArrayList;
import java.util.List;

public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подошедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (var man:persons) {
            if (String.format("%s+%s+%s+%s", man.getName(), man.getSurname(), man.getAddress(), man.getPhone()).contains(key)) {
                result.add(man);
            }
        }
        return result;
    }
}
