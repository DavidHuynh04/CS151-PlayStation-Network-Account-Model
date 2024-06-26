package com.example.project.View;

import com.example.project.Model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GamesLibrary gamesLibrary = new GamesLibrary();
        gamesLibrary.initializeLibrary();
        Leaderboard leaderboard = new Leaderboard();
        AccountManager accountManager = new AccountManager();
        AccountInitializer.initializeAccounts();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/start.fxml"));
        stage.setTitle("PlayStation Network");
        Scene startScene = new Scene(fxmlLoader.load());
        stage.setScene(startScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}