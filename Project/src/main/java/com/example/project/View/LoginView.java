package com.example.project.View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginView extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginView.class.getResource("/com/example/project/View/login.fxml"));
        stage.setTitle("PlayStation Login");
        Scene loginScene = new Scene(fxmlLoader.load());
        stage.setScene(loginScene);
        stage.show();
    }
}
