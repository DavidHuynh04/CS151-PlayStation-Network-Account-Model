package com.example.project.Model;
import java.util.HashMap;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class GamesLibrary {
    private static HashMap<String, Game> library = new HashMap<>();
    public void initializeLibrary(){
        JSONParser parser = new JSONParser();
        try{
            InputStream gamesList = GamesLibrary.class.getResourceAsStream("/com/example/project/Model/GamesList.json");
            JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(gamesList));
            JSONArray games = (JSONArray) obj.get("games");
            for (Object game: games){
                JSONObject gameJSONObject = (JSONObject) game;
                String title = (String) gameJSONObject.get("gameTitle");
                String imageString = (String) gameJSONObject.get("image");
                InputStream image = GamesLibrary.class.getResourceAsStream(STR."/com/example/project/gameCovers/\{imageString}");
                List<Trophy> trophyList = new ArrayList<>();
                JSONArray trophies = (JSONArray) gameJSONObject.get("trophies");
                for (Object trophy: trophies){
                    JSONObject trophyJSONObject = (JSONObject) trophy;
                    String trophyTitle = (String) trophyJSONObject.get("trophy");
                    String description = (String) trophyJSONObject.get("description");
                    int points = ((Long) trophyJSONObject.get("value")).intValue();
                    trophyList.add(new Trophy(trophyTitle, description, points));
                }
                library.put(title, new Game(title, image, trophyList));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public HashMap<String, Game> getLibrary() {
        return library;
    }
    public static void main(String[] args) {
        GamesLibrary gamesLibrary = new GamesLibrary();
        gamesLibrary.initializeLibrary();

        // Print the contents of the library HashMap
        for (String title : library.keySet()) {
            Game game = library.get(title);
            System.out.println("Title: " + title);
            System.out.println("Image: " + game.getImage()); // Assuming getImage() returns a string representation
            System.out.println("Trophies:");
            for (Trophy trophy : game.getTrophyList()) {
                System.out.println("  Trophy Title: " + trophy.getTrophyTitle());
                System.out.println("  Description: " + trophy.getDescription());
                System.out.println("  Points: " + trophy.getTrophyPoints());
            }
            System.out.println();
        }
    }
}
