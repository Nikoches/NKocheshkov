package banking;

import java.util.*;
import java.util.stream.Collectors;


public class Bank {

    private Map<User, ArrayList<Account>> userstab = new HashMap<>();

    /** ПОЛУЧИТЬ ЮЗЕРА ПО ПАСПОРТУ */
    private User getuser(String userpasport) {
        return userstab.entrySet().stream()
                 .filter(User -> User.getKey().getPasport().equals(userpasport))
                 .findAny().get().getKey();


    }

    /**ДОБАВЛЕНИЕ ЮЗЕРА*/
    public void addUser(User user) {
        this.userstab.putIfAbsent(user, new ArrayList<>());
    }

    /**  УДАЛЕНИЕ ЮЗЕРА И ВСЕХ ЕГО АККАУНТОВ */
    public void deleteUser(String userpassport) {
        this.userstab.remove(getuser(userpassport));
    }

    /** ДОБАВЛЕНИЕ АККАУНТА К ЮЕЗРУ  */
    public void addAccountToUser(String userpassport, Account account) {
        final User user = getuser(userpassport);
        if (user != null) {
            this.userstab.get(user).add(account);
        }
    }

    /** ПОЛУЧИТЬ АККАУНТ ЮЗЕРА  ПО РЕКВЕЗИТАМ И ЮЗЕРА*/
    private Account getActualAccount(User user, String userreq) {
        ArrayList<Account> list = this.userstab.get(user);
        return list.stream()
                .filter(account -> account.getReqs().equals(userreq))
                .findAny().orElse(null);
    }
    private Account getActualAccount(String pasport, String userreq) {
        ArrayList<Account> list = this.userstab.get(getuser(pasport));
        return list.stream()
                .filter(account -> account.getReqs().equals(userreq))
                .findAny().orElse(null);

    }

    /** УДАЛИТЬ АККАУНТ У ЮЗЕРА */
    public void deleteAccountFromUser(String userpassport, Account account) {
        if (userstab.entrySet().stream()
                .filter(User -> User.getKey().getPasport().equals(userpassport))
                .map(User -> User.getValue())
                .anyMatch(Account -> Account == null)){

            this.userstab.get(getuser(userpassport)).remove(account);
        }
    }

    public List<Account> getUserAccounts(String userpassport) {
        return this.userstab.get(getuser(userpassport));
    }

    public boolean transfer(String userpasport, String srcRequisite,
                            String destPassport, String dstRequisite, double amount) {
        boolean change;
        if (getActualAccount(userpasport, srcRequisite) == null) {
            change = false;
        } else change = getActualAccount(userpasport, srcRequisite).transfer(getActualAccount(destPassport, dstRequisite), amount);

        return change;
    }

    public String toString() {
        return String.format("Bank{accounts=%s", userstab);
    }
}