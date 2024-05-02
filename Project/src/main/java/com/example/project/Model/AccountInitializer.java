package com.example.project.Model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class AccountInitializer {
    public static void initializeAccounts(){
        AccountManager accountManager = AccountManager.getInstance();
        GamesLibrary gamesLibrary = GamesLibrary.getInstance();
        JSONParser parser = new JSONParser();
        try{
            InputStream accountList = AccountInitializer.class.getResourceAsStream("/com/example/project/Model/AccountList.json");
            JSONObject obj = (JSONObject) parser.parse(new InputStreamReader(accountList));
            JSONArray accounts = (JSONArray) obj.get("Accounts");
            for (Object account: accounts){
                JSONObject accountJSONObject = (JSONObject) account;
                String userName = (String) accountJSONObject.get("userName");
                String email = (String) accountJSONObject.get("email");
                String password = (String) accountJSONObject.get("password");
                int level = ((Long) accountJSONObject.get("level")).intValue();
                int exp = ((Long) accountJSONObject.get("exp")).intValue();
                JSONArray gameJSONLibrary = (JSONArray) accountJSONObject.get("gameLibrary");
                HashMap<String, Game> gamesList = new HashMap<>();
                for (Object game: gameJSONLibrary){
                    JSONObject gameJSONObject = (JSONObject) game;
                    String gameTitle = (String) gameJSONObject.get("gameTitle");
                    InputStream image = gamesLibrary.getGame(gameTitle).getImage();
                    JSONArray trophies = (JSONArray) gameJSONObject.get("trophies");
                    HashMap<String, Trophy> trophyList = new HashMap<>();
                    for (Object trophy : trophies) {
                        if (trophy instanceof String) {
                            String trophyTitle = (String) trophy;
                            Trophy tempTrophy = gamesLibrary.getGame(gameTitle).getTrophy(trophyTitle);
                            trophyList.put(trophyTitle, tempTrophy);
                        }
                    }
                    gamesList.put(gameTitle, new Game(gameTitle, image, trophyList));
                }
                accountManager.createAccount(userName, email, password, level, exp, gamesList);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
