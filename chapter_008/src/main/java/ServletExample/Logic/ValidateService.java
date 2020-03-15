package ServletExample.Logic;

import ServletExample.Model.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class ValidateService<T> {
    private static final ValidateService validateService = new ValidateService();
    private final Map<String, Function<HttpServletRequest, Optional>> dispatch = new HashMap<>();
    private final UsersStorage usersStorage = UsersStorage.getInstance();
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

    public Optional process(HttpServletRequest key,String action) {
        return dispatch.get(action).apply(key);
    }
    /*
        Add user
        @return boolean
    */
    private Function<HttpServletRequest, Optional> add() {
        return key-> Optional.of(usersStorage.add(processUser(key)));
    }
    /*
        Update user
        @return boolean
     */
    private Function<HttpServletRequest, Optional> update() {
        return key-> Optional.of(usersStorage.update(processUser(key),key.getParameter("id")));
    }
    /*
        Remove user by id
        @return boolean
     */
    private Function<HttpServletRequest, Optional> delete() {
        return key-> Optional.of(usersStorage.delete(key.getParameter("id")));
    }
    /*
        Remove all users
        @return boolean
     */
    private Function<HttpServletRequest, Optional> removeAll() {
        return user -> {
            usersStorage.removeAll();
            return Optional.of(true);
        };
    }
    /*
        Get all users
        @return List
     */
    private Function<HttpServletRequest, Optional> findAll() {
        return user -> Optional.of(usersStorage.findlAll());
    }
    /*
        Return user by id
        @return User;
     */
    private Function<HttpServletRequest, Optional> findById() {
        return key -> Optional.of(usersStorage.findById(key.getParameter("id")));
    }
    private User processUser(HttpServletRequest stringUser)  {
        return new User(stringUser.getParameter("name"), stringUser.getParameter("login"), stringUser.getParameter("email"), 2020,usersStorage.getCounterId());
    }
}
