package com.example.project.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaderBoardController {

    @FXML
    private Text yourUsername;
    @FXML
    private Text yourLvl;

    public void updateCurrentUser(String username, int level) {
        yourUsername.setText(username);
        yourLvl.setText(String.valueOf(level));
    }

    @FXML
    void onHomeClicked(MouseEvent event) throws IOException {
        // Returning to home screen
        Stage stage = (Stage) yourUsername.getScene().getWindow();
        stage.setTitle("Home");

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project/View/home.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }
}