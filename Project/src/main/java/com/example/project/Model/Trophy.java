package com.example.project.Model;

public class Trophy {
    private String trophyTitle;
    private int trophyPoints;
    private boolean completed;
    public Trophy(String trophyTitle, int trophyPoints){
        this.trophyTitle = trophyTitle;
        this.trophyPoints = trophyPoints;
    }
    public String getTrophyTitle() {
        return trophyTitle;
    }
    public void setTrophyTitle(String trophyTitle) {
        this.trophyTitle = trophyTitle;
    }
    public int getTrophyPoints() {
        return trophyPoints;
    }
    public void setTrophyPoints(int trophyPoints) {
        this.trophyPoints = trophyPoints;
    }
}
