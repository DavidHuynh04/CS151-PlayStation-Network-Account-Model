package com.example.project.Controller;
import com.example.project.Model.Account;
import com.example.project.Model.AccountManager;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    @FXML
    private Text levelField;

    @FXML
    private Text usernameField;

    @FXML
    private Text xpField;
    private Account currentAccount;
    AccountManager accountManger = AccountManager.getInstance();
    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
        updateFields();
    }
    private void updateFields() {
        if (currentAccount != null) {
            usernameField.setText(currentAccount.getUserName());
            levelField.setText(String.valueOf(currentAccount.getLevel()));
            xpField.setText(currentAccount.getExp() + " XP");
        }
    }
    @FXML
    void viewProfileClicked(MouseEvent event) {
    }
    @FXML
    void viewFriendsClicked(MouseEvent event) {
    }
    @FXML
    void viewLeaderboardsClicked(MouseEvent event) {
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
