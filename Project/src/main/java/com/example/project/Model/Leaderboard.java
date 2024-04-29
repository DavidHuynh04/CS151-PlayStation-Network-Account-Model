package com.example.project.Model;

import java.util.*;

public class Leaderboard{
    private Account account;
    private TreeSet<Account> leaderboards;


    public Leaderboard () {
        this.leaderboards = new TreeSet<>(new AccountComparator());
    }

    public void addAccount(Account account){
        leaderboards.add(account);
    }
    public int getPosition(Account account){
        return leaderboards.headSet(account, false).size()+1;
    }
    private static class AccountComparator implements Comparator<Account>{
        @Override
        public int compare(Account a1, Account a2) {
            if(a1.getLevel() != a2.getLevel()){
                return  Integer.compare(a2.getLevel(),a1.getLevel());
            }
            return Integer.compare(a2.getExp(), a1.getExp());
        }

    }
}




