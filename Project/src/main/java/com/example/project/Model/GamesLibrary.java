package com.example.project.Model;
import java.util.HashMap;
import java.io.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.*;

public class GamesLibrary {
    private HashMap<String, Game> library;
    public void initializeLibrary(){
        JSONParser parser = new JSONParser();
        try{
            InputStream gamesList = GamesLibrary.class.getResourceAsStream("/com/example/project/Model/GamesList.json");
            Object obj = parser.parse(new InputStreamReader(gamesList));
            JSONArray games = (JSONArray) obj;
            for (Object game: games){
                JSONObject gameJSONObject = (JSONObject) game;
                String title = (String) gameJSONObject.get("title");
                String imageString = (String) gameJSONObject.get("image");
                InputStream image = GamesLibrary.class.getResourceAsStream(STR."/com/example/project/gameCovers/\{imageString}");
                List<Trophy> trophyList = new ArrayList<>();
                JSONArray trophies = (JSONArray) gameJSONObject.get("tropies");
                for (Object trophy: trophies){
                    JSONObject trophyJSONObject = (JSONObject) trophy;
                    String trophyTitle = (String) trophyJSONObject.get("trophyTitle");
                    String description = (String) trophyJSONObject.get("description");
                    int points = (Integer) trophyJSONObject.get("value");
                    trophyList.add(new Trophy(trophyTitle, description, points));
                }
                library.put(title, new Game(title, image, trophyList));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
