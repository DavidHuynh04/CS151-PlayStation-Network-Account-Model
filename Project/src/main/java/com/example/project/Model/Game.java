package com.example.project.Model;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class Game {
    private String gameTitle;
    private InputStream image;
    private HashMap<String, Trophy> trophyList;

    public Game(String gameTitle, InputStream image, HashMap<String, Trophy> trophyList){
        this.gameTitle = gameTitle;
        this.image = image;
        this.trophyList = trophyList;
    }
    public boolean addTrophyToGame(Trophy t){
        if (!this.trophyList.containsKey(t.getTrophyTitle())){
            trophyList.put(t.getTrophyTitle(), t);
            return true;
        }
        return false;
    }
    public String getGameTitle() {
        return gameTitle;
    }
    public InputStream getImage() {
        return image;
    }
    public HashMap<String, Trophy> getTrophyList() {
        return trophyList;
    }
    public Trophy getTrophy(String title){
        return trophyList.get(title);
    }
}
