package com.example.project.Model;

import java.util.List;

public class Game {
    private String gameTitle;
    private List<Trophy> trophyList;

    public Game(String gameTitle, List<Trophy> trophyList){
        this.gameTitle = gameTitle;
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
}
