package banking;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;


public class Bank {

    private TreeMap<User, ArrayList<Account>> userstab = new TreeMap<>();

    /** ПОЛУЧИТЬ ЮЗЕРА ПО ПАСПОРТУ */
    private User getuser(String userpasport) {
        User user = null;
        for (Map.Entry<User, ArrayList<Account>> item : userstab.entrySet()) {
            if (item.getKey().getPasport().equals(userpasport)) {
                user = item.getKey();
                break;
            }
        }
        return user;
    }

    /**ДОБАВЛЕНИЕ ЮЗЕРА*/
    public void addUser(User user) {
        this.userstab.put(user, new ArrayList<>());
    }

    /**  УДАЛЕНИЕ ЮЗЕРА И ВСЕХ ЕГО АККАУНТОВ */
    public void deleteUser(String userpassport) {
        this.userstab.remove(getuser(userpassport));
    }

    /** ДОБАВЛЕНИЕ АККАУНТА К ЮЕЗРУ  */
    public void addAccountToUser(String userpassport, Account account) {
        this.userstab.get(getuser(userpassport)).add(account);
    }

    /** ПОЛУЧИТЬ АККАУНТ ЮЗЕРА  ПО РЕКВЕЗИТАМ*/
    private Account getActualAccount(User user, String userreq) {
        ArrayList<Account> list = this.userstab.get(user);
        Account useracc = null;
        for (Account useraccounts : list) {
            if (useraccounts.getReqs().equals(userreq)) {
                useracc = useraccounts;
                break;
            }
        }
        return useracc;
    }

    /** УДАЛИТЬ АККАУНТ У ЮЗЕРА */
    public void deleteAccountFromUser(String userpassport, Account account) {
        this.userstab.get(getuser(userpassport)).remove(account);
    }

    public List<Account> getUserAccounts(String userpassport) {

        return this.userstab.get(getuser(userpassport));
    }

    public boolean transfer(String userpasport, String srcRequisite,
                            String destPassport, String dstRequisite, double amount) {

        return userstab.get(getuser(userpasport)).contains(getActualAccount(getuser(userpasport), srcRequisite))
                && userstab.get(getuser(destPassport)).contains(getActualAccount(getuser(destPassport), dstRequisite))
                &&  getActualAccount(getuser(userpasport), srcRequisite).transfer(getActualAccount(getuser(destPassport), dstRequisite), amount);
    }

    public String toString() {
        return String.format("Bank{accounts=%s", userstab);
    }
}