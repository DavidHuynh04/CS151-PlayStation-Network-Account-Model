package com.example.project.Model;

import java.util.HashMap;
import java.util.List;

public class Account implements Comparable<Account>{
    private String userName;
    private String password;
    private int level;
    private int exp;
    private int position;
    private HashMap<String, Game> library;
    public Account(String userName, String password, int level, int exp,  HashMap<String, Game> library){
        this.userName = userName;
        this.password = password;
        this.level = level;
        this.exp = exp;
        this.library = library;
    }
    public int compareTo(Account other){
        if (this.getLevel() != other.getLevel()){
            return Integer.compare(this.getLevel(), other.getLevel());
        }
        return Integer.compare(this.getExp(), this.getExp());
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getExp() {
        return exp;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public HashMap<String, Game> getLibrary() {
        return library;
    }
    public void setLibrary(HashMap<String, Game> library) {
        this.library = library;
    }
    public void addGame(String gameKey, Game game) {
        // currently being set to game if change when we added achievements/trophy
        library.put(gameKey, game);
        int gameExp = 15;
        exp += gameExp;
        while (canLevelUp()) {
            levelUp();
        }
    }

    private boolean canLevelUp() {
        int expRequired;
        if (level >= 1 && level <= 100) {
            expRequired = 60;
        } else if (level >= 101 && level <= 200) {
            expRequired = 90;
        } else {
            expRequired = Integer.MAX_VALUE;
        }
        return exp >= expRequired;
    }

    private void levelUp() {
        int expRequired;
        if (level >= 0 && level <= 100) {
            expRequired = 60;
        } else if (level >= 101 && level <= 200) {
            expRequired = 90;
        } else {
            expRequired = Integer.MAX_VALUE;
        }
        if (exp >= expRequired) {
            level++;
            exp -= expRequired;
        }
    }
}
