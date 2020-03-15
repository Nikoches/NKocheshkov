package ServletExample.Model;

public class User {
    private String name;
    private String login;
    private String email;
    private long createDate;
    private int id;
    public User(String name, String login, String email, long createDate,int id) {
        this.name = name;
        this.login = login;
        this.email = email;
        this.createDate = createDate;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
}
