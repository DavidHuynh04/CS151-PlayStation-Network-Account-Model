package com.example.project.Controller;
import com.example.project.Model.Account;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TilePane tilePane;
    @FXML
    private Text usernameText;
    @FXML
    private Text levelText;
    @FXML
    private Text expText;
    @FXML
    private Button viewProfileButton;
    @FXML
    private Button friendListButton;
    @FXML
    private Button leaderboardButton;
    @FXML
    public void initialize(Account account) {
        usernameText.setText("Name: " + account.getUserName());
        levelText.setText(account.getLevel() + " LvL");
        expText.setText(account.getExp() + " exp");
    }
    @FXML
    void  leaderboardButtonClicked(MouseEvent event){

    }
    @FXML
    void  profileButtonClicked(MouseEvent event){

    }
    @FXML
    void  friendButtonClicked(MouseEvent event){

    }

    @FXML
    void homeButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("PlayStation Network");
        stage.setScene(startScene);
        stage.show();
    }
}
