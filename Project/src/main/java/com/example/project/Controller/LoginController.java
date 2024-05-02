package com.example.project.Controller;

import com.example.project.Model.Account;
import com.example.project.Model.AccountManager;
import com.example.project.Utility.AlertUtility;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    private AccountManager accountManager = AccountManager.getInstance();

    @FXML
    void homeButtonClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/start.fxml"));
        Scene startScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("PlayStation Network");
        stage.setScene(startScene);
        stage.show();
    }
    @FXML
    void Login(MouseEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (accountManager.validateLogin(username, password)) {
            try {
                AlertUtility.showAlert(Alert.AlertType.INFORMATION, "Login Successful", "Welcome to Playstation " + username + "!");
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/project/View/home.fxml"));


                Scene homeScene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(homeScene);
                stage.setTitle("Home");
                stage.show();

                HomeController homeController = fxmlLoader.getController();
                Account currentAccount = accountManager.getAccount(username);
                homeController.setCurrentAccount(currentAccount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password. Please try again.");
            alert.showAndWait();
        }
    }
}