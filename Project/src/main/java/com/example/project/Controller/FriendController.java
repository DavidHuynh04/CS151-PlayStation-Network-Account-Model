package com.example.project.Controller;

import com.example.project.Model.Account;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class FriendController {
    private Account currentAccount;
    public Text usernameField;
    public Text levelField;
    public Text expField;
    public HBox friend3;
    public HBox friend2;
    public HBox friend1;
    public void setCurrentProfileAccount(Account account) {
        this.currentAccount = account;
        updateProfile();
    }

    @FXML
    private void updateProfile() {
        if (currentAccount != null) {
            usernameField.setText(currentAccount.getUserName());
            levelField.setText(String.valueOf(currentAccount.getLevel()));
            expField.setText(currentAccount.getExp() + " XP");
        }
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
        homeController.setCurrentAccount(currentAccount);
    }
}
