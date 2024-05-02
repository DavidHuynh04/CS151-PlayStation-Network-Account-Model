package com.example.project.Model;

public class Trophy {
    private String trophyTitle;
    private String description;
    private int trophyPoints;

    public Trophy(String trophyTitle, String description, int trophyPoints){
        this.trophyTitle = trophyTitle;
        this.description = description;
        this.trophyPoints = trophyPoints;
    }
    public String getTrophyTitle() {
        return trophyTitle;
    }
    public String getDescription() {
        return description;
    }
    public int getTrophyPoints() {
        return trophyPoints;
    }

}
