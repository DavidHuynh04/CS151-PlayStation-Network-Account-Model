package com.example.project.Controller;

import com.example.project.Model.AccountManager;
import com.example.project.Utility.AlertUtility;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;


public class SignupController {

    @FXML
    private TextField emailField;

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
    void createAccountButton(MouseEvent event) {
        try {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            validateUsername(username);
            validateEmail(email);
            validatePassword(password);

            if (accountManager.accountExists(username)) {
                throw new IllegalArgumentException("An account with this username already exists.");
            }

            accountManager.createAccount(username, email, password);
            AlertUtility.showAlert(Alert.AlertType.INFORMATION, "Signup Successful", "Welcome to Playstation " + username + "!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project/View/start.fxml"));
            Scene signupScene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(signupScene);
            stage.setTitle("Signup");
            stage.show();

        } catch (Exception e) {
            AlertUtility.showAlert(Alert.AlertType.ERROR, "Signup Error", e.getMessage());
        }
    }

    private void validateUsername(String username) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty.");
        }
    }

    private void validateEmail(String email) {
        if (email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException("Please enter a valid email address.");
        }
    }

    private void validatePassword(String password) {
        if (password.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain at least one uppercase letter.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new IllegalArgumentException("Password must contain at least one lowercase letter.");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one digit.");
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character.");
        }
    }
}
