package banking;

/*

*/
public class Account {

    private double values;
    private String reqs;

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs() {
        return this.reqs;
    }

    protected boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    public String toString() {
        return String.format("Account{ values = %s, reqs='%s\\ }", this.values, this.reqs);
    }

    public boolean equals(Object o) {
        boolean equality = false;
        Account account = (Account) o;
        if (o == null || getClass() != o.getClass()) {
            equality = false;
        } else  if (this == o && this.reqs.equals(account.reqs)) {
            equality = true;
        }
        return equality;
    }

    public int hashCode() {
        return this.reqs.hashCode();
    }
}