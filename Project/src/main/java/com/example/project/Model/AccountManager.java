package com.example.project.Model;

import java.util.HashMap;

public class AccountManager {
    private static AccountManager instance = null;
    private HashMap<String, Account> accounts;
    private AccountManager() {
        accounts = new HashMap<>();
    }
    public static AccountManager getInstance() {
        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;
    }
    public void createAccount(String username, String email, String password){
        accounts.put(username, new Account(username, email, password));
    }
    public void deleteAccount(String userName){
        accounts.remove(userName);
    }
    public boolean accountExists(String username) {
        return accounts.containsKey(username);
    }
    public boolean validateLogin(String username, String password) {
        Account account = accounts.get(username);
        if (account != null) {
            return account.getPassword().equals(password);
        }
        return false;
    }
}
