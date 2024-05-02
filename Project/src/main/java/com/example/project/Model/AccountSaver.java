package com.example.project.Model;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class AccountSaver {

    public void saveAccounts(){
        AccountManager accountManager = AccountManager.getInstance();
        JSONArray accountList = new JSONArray();
        for (HashMap.Entry<String, Account> account: accountManager.getAccounts().entrySet()){
            Account temp = account.getValue();
            JSONObject tempAccount = new JSONObject();
            tempAccount.put("userName", temp.getUserName());
            tempAccount.put("email", temp.getEmail());
            tempAccount.put("password", temp.getPassword());
            tempAccount.put("level", temp.getLevel());
            tempAccount.put("exp", temp.getExp());
            JSONArray gameLibrary = new JSONArray();
            HashMap <String, Game> games = temp.getLibrary();
            for (HashMap.Entry<String, Game> game: games.entrySet()){
                Game tempGame = game.getValue();
                JSONObject tempJSONGame = new JSONObject();
                tempJSONGame.put("gameTitle", tempGame.getGameTitle());
                JSONArray trophyList = new JSONArray();
                for (HashMap.Entry<String, Trophy> JSONTrophy: game.getValue().getTrophyList().entrySet()){
                    Trophy trophy = JSONTrophy.getValue();
                    trophyList.add(trophy.getTrophyTitle());
                }
                tempJSONGame.put("trophies", trophyList);
                gameLibrary.add(tempJSONGame);
            }
            tempAccount.put("gameLibrary", gameLibrary);
            accountList.add(tempAccount);
        }
    }
}
