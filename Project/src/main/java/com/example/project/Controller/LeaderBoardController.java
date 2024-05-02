package com.example.project.Controller;

import com.example.project.Model.Account;
import com.example.project.Model.Leaderboard;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LeaderBoardController {

    public Text username1;
    public Text username2;
    public Text username3;
    public Text username4;
    public Text username5;
    public Text user1lvl;
    public Text user2lvl;
    public Text user3lvl;
    public Text user4lvl;
    public Text user5lvl;

    private Account you;


    public void updateCurrentUser(Account you) {
        this.you = you;
        username1.setText(Leaderboard.getInstance().getAccountAtPosition(0).getUserName());
        username2.setText(Leaderboard.getInstance().getAccountAtPosition(1).getUserName());
        username3.setText(Leaderboard.getInstance().getAccountAtPosition(2).getUserName());
        username4.setText(Leaderboard.getInstance().getAccountAtPosition(3).getUserName());
        username5.setText(Leaderboard.getInstance().getAccountAtPosition(4).getUserName());
        user1lvl.setText(String.valueOf(Leaderboard.getInstance().getAccountAtPosition(0).getLevel()));
        user2lvl.setText(String.valueOf(Leaderboard.getInstance().getAccountAtPosition(1).getLevel()));
        user3lvl.setText(String.valueOf(Leaderboard.getInstance().getAccountAtPosition(2).getLevel()));
        user4lvl.setText(String.valueOf(Leaderboard.getInstance().getAccountAtPosition(3).getLevel()));
        user5lvl.setText(String.valueOf(Leaderboard.getInstance().getAccountAtPosition(4).getLevel()));


    }

    @FXML
    void onHomeClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/home.fxml"));
        Scene homeScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.setTitle("Home");
        stage.show();

        HomeController homeController = fxmlLoader.getController();
        homeController.setCurrentAccount(you);
    }
}