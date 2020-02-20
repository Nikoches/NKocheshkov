package ServletExample;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ValidateService {
    private static final ValidateService validateService = new ValidateService();
    private final Map<String, Function<HttpServletRequest, Boolean>> dispatch = new HashMap<>();
    private final UsersStorage usersStorage = UsersStorage.getInstance();
    private PrintWriter printWriter;
    private ValidateService() {
        dispatch.put("add", add());
        dispatch.put("update", update());
        dispatch.put("delete", delete());
        dispatch.put("findbyid", findById());
        dispatch.put("removeAll", removeAll());
        dispatch.put("findAll", findAll());
    }

    public static ValidateService getInstance() {
        return validateService;
    }

    public boolean process(HttpServletRequest key, PrintWriter printWriter) {
        this.printWriter = printWriter;
        return dispatch.get(key.getParameter("action")).apply(key);
    }

    public Function<HttpServletRequest, Boolean> add() {

        return key-> usersStorage.add(processUser(key));
    }

    public Function<HttpServletRequest, Boolean> update() {
        return key-> usersStorage.update(processUser(key),key.getParameter("id"));
    }

    public Function<HttpServletRequest, Boolean> delete() {
        return key->usersStorage.delete(key.getParameter("id"));
    }


    public Function<HttpServletRequest, Boolean> findAll() {
        return user -> {
            printWriter.append(usersStorage.findlAll());
            return true;
        };
    }
    public Function<HttpServletRequest, Boolean> removeAll() {
        return user -> {
            usersStorage.removeAll();
            printWriter.append(usersStorage.toString());
            return true;
        };
    }
    public Function<HttpServletRequest, Boolean> findById() {
        return user -> {
            printWriter.append(usersStorage.findById(user.getParameter("id")).toString());
            return true;
        };
    }
    private User processUser(HttpServletRequest stringUser)  {
        return new User(stringUser.getParameter("name"), stringUser.getParameter("login"), stringUser.getParameter("email"), 2020);
    }
}
