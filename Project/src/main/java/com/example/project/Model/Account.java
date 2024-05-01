package com.example.project.Model;

import java.util.HashMap;
import java.util.List;

public class Account implements Comparable<Account>{
    private String username;
    private String email;
    private String password;
    private int level;
    private int exp;
    private int position;
    private HashMap<String, Game> library;
    public Account(String username, String email, String password, int level, int exp,  HashMap<String, Game> library){
        this.username = username;
        this.email = email;
        this.password = password;
        this.level = level;
        this.exp = exp;
        this.library = library;
    }
    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.level = 0;
        this.exp = 0;
        this.library = new HashMap<String, Game>();
    }
    public int compareTo(Account other){
        if (this.getLevel() != other.getLevel()){
            return Integer.compare(this.getLevel(), other.getLevel());
        }
        return Integer.compare(this.getExp(), this.getExp());
    }
    public String getUserName() {
        return username;
    }
    public void setUserName(String userName) {
        this.username = userName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
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
    public void addGame(String gameTitle, Game game) {
        HashMap<String, Trophy> emptyMap = new HashMap<>();
        library.put(gameTitle, new Game (game.getGameTitle(), game.getImage(), emptyMap));
    }
    public void addTrophy(Trophy t, Game game){
        if(game.addTrophyToGame(t)){
            exp += t.getTrophyPoints();
            while (canLevelUp()) {
                levelUp();
            }
        }
        else{
            System.out.println("Trophy Already exist");
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
