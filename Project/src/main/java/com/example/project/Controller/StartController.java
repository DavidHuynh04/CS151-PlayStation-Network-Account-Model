package com.example.project.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class StartController {
    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;
    @FXML
    void loadLoginScene(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project/View/login.fxml"));
        Scene loginScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(loginScene);
        stage.setTitle("Login");
        stage.show();
    }
    @FXML
    void loadSignupScene(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/project/View/signup.fxml"));
        Scene signupScene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) signupButton.getScene().getWindow();
        stage.setScene(signupScene);
        stage.setTitle("Signup");
        stage.show();
    }
}
