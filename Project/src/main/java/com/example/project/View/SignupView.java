package com.example.project.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SignupView.class.getResource("/com/example/project/View/signup.fxml"));
        stage.setTitle("PlayStation Signup");
        Scene signupScene = new Scene(fxmlLoader.load());
        stage.setScene(signupScene);
        stage.show();
    }
}
