package com.example.project.Model;

import java.util.HashMap;
import java.util.List;

public class AccountManager {
    HashMap<String, Account> accounts = new HashMap<>();
    public void createAccount(String userName, String password, int level, int exp, HashMap<String, Game> library){
        accounts.put(userName, new Account(userName, password, level, exp, library));
    }
    public void deleteAccount(String userName){
        accounts.remove(userName);
    }
}
