package ServletExample;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ValidateService {
    private static final ValidateService validateService = new ValidateService();
    private final Map<String, Function<User, Boolean>> dispatch = new HashMap<>();
    private UsersStorage usersStorage = UsersStorage.getInstance();

    private ValidateService() {
            dispatch.put("add",add());
    }

    public static ValidateService getInstance() {
        return validateService;
    }

    public boolean process(HttpServletRequest key) {
        return dispatch.get(key.getParameter("action")).apply(processUser(key));
    }

    public Function<User, Boolean> add() {
        return user -> {
            if(usersStorage.alreadyHas(user)){
                return false;
            }
            usersStorage.add(user);
            return true;
        };
    }


    public void update() {

    }

    public void delete() {

    }

    public Map<Integer,User> findAll() {
        return usersStorage.findlAll();
    }

    public void findById() {

    }

    public User processUser(HttpServletRequest stringUser) {

        return new User(stringUser.getParameter("name"),stringUser.getParameter("login"),stringUser.getParameter("email"),12,1200);
    }
}
