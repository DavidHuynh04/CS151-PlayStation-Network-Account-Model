package com.example.project.Model;

import java.io.InputStream;
import java.util.List;

public class Game {
    private String gameTitle;
    private InputStream image;
    private List<Trophy> trophyList;

    public Game(String gameTitle, InputStream image, List<Trophy> trophyList){
        this.gameTitle = gameTitle;
        this.image = image;
        this.trophyList = trophyList;
    }
    public boolean addTropphyToGame(Trophy t){
        if (!this.trophyList.contains(t)){
            trophyList.add(t);
            return true;
        }
        return false;
    }
    public int getTotalTrophyPoints() {
        int totalPoints = 0;
        for (Trophy trophy : trophyList) {
            totalPoints += trophy.getTrophyPoints();
        }
        return totalPoints;
    }
    public String getGameTitle() {
        return gameTitle;
    }
    public InputStream getImage() {
        return image;
    }
    public List<Trophy> getTrophyList() {
        return trophyList;
    }
}
