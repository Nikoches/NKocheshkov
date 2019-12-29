package SafeUserStorage;

public class User {
    private int amount;
    private String name;
    private int id;

    public User(String name, int amount, int id) {
        this.name = name;
        this.amount = amount;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmout(int amount) {
        this.amount += amount;
    }
}
