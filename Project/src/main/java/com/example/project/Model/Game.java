package com.example.project.Model;

import java.util.List;

public class Game {
    private String gameTitle;
    private List<Trophy> trophyList;

    public Game(String gameTitle, List<Trophy> trophyList){
        this.gameTitle = gameTitle;
        this.trophyList = trophyList;
    }
}
