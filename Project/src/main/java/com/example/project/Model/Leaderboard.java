package com.example.project.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
public class Leaderboard{
    private Account account;
    List<Account> inOrder;

    public int compareTo(Account other){
        if (this.account.getLevel() != other.getLevel()){
            return Integer.compare(this.account.getLevel(), other.getLevel());
        }
        return Integer.compare(this.account.getExp(), other.getExp());
    }

    public List<Account> leaderboard(HashMap<String, Account> accounts){
        inOrder = new ArrayList<>(accounts.values());
        Collections.sort(inOrder);
        return inOrder;
    }
    public int getPosition(Account account){
        int position = 1;
        for (int i = 0; i < inOrder.size(); i++){
            if (!account.equals(inOrder.get(i))){
                position++;
            }
            else{
                break;
            }
        }
        return position;
    }
}
