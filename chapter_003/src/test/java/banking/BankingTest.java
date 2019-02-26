package banking;

import org.junit.Test;

public class BankingTest {
    @Test
    public void whenCreatingUser() {
        Bank bank = new Bank();
        bank.addUser(new User("pass1", "Andy"));
        bank.addAccountToUser("pass1", new Account(2.1, "req1"));
        bank.addUser(new User("pass2", "Jack"));
        bank.addAccountToUser("pass2", new Account(3, "req2"));
        System.out.println(bank.transfer("pass1", "req1", "pass2", "re2", 1));
        System.out.println(bank.toString());
    }

}
