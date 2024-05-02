package com.example.project.Model;

import java.util.*;

public class Leaderboard{
    private static Leaderboard intan = null;
    private ArrayList<Account> leaderboards;
    private TreeSet<Account> comparelist = new TreeSet<>(new AccountComparator());
    public Leaderboard () {
        leaderboards = new ArrayList<>();
    }
    public static Leaderboard getInstance(){
        if (intan == null){
            intan = new Leaderboard();
        }
        return intan;
    }
    public Account getAccountAtPosition(int i){
        if (leaderboards.isEmpty()){
            Sort();
        }

        return leaderboards.get(i);
    }
    public void addAccount(Account account){
        comparelist.add(account);
    }
    public void Sort(){
        leaderboards = new ArrayList<>(comparelist);
    }
    public int getPosition(Account account){
        for (int i = 0; i < leaderboards.size(); i++){
            if (account == leaderboards.get(i))
            {
                return i;
            }
        }
        return Integer.MAX_VALUE;
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




