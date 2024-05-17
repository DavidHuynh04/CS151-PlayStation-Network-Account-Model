package com.example.project.Controller;

import com.example.project.Model.Account;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Button leaderboardButton;
    @FXML
    private Text levelField;

    @FXML
    private Text usernameField;

    @FXML
    private Text xpField;
    private Account currentAccount;

    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
        updateFields();
    }

    private void updateFields() {
        if (currentAccount != null) {
            usernameField.setText(currentAccount.getUserName());
            levelField.setText(String.valueOf(currentAccount.getLevel()));
        }
    }

    @FXML
    void viewProfileClicked(MouseEvent event) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/trophy.fxml"));
            Scene profileScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(profileScene);
            stage.setTitle("Profile Scene");

            ProfileController profileController = fxmlLoader.getController();
            profileController.setCurrentProfileAccount(currentAccount);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewFriendsClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/friend.fxml"));
        Scene homeScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.setTitle("PlayStation Friend");
        FriendController friendController = fxmlLoader.getController();
        friendController.setCurrentProfileAccount(currentAccount);
        stage.show();
    }

    @FXML
    void viewLeaderboardsClicked(MouseEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/leaderboards.fxml"));
        Scene homeScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(homeScene);
        stage.setTitle("PlayStation Leaderboards");
        LeaderBoardController leaderBoardController = fxmlLoader.getController();
        leaderBoardController.updateCurrentUser(currentAccount);
        stage.show();
    }

    @FXML
    void homeButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("PlayStation Home");
        stage.setScene(startScene);
        stage.show();
    }
}