package Model;

import java.util.HashMap;

public class AccountManager {
    HashMap<String, Account> accounts = new HashMap<>();
    public void createAccount(String userName, String password, int level, int exp){
        accounts.put(userName, new Account(userName, password, level, exp));
    }
    public void deleteAccount(String userName){
        accounts.remove(userName);
    }
}
