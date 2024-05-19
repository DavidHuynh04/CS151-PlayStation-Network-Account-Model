package com.example.project.Controller;

import com.example.project.Model.Account;
import com.example.project.Model.Game;
import com.example.project.View.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class InfoController {
    public HBox game1;
    public HBox game2;
    public HBox game3;
    private Account currentAccount;
    @FXML
    public Text usernameField;
    @FXML
    public Text levelField;
    @FXML
    public Text expField;
    private final HBox[] items = new HBox[]{game1,game2,game3};
    public void setCurrentProfileAccount(Account account) {
        this.currentAccount = account;
        updateProfile();
    }

    @FXML
    private void updateProfile() {
        if (currentAccount != null) {
            ArrayList<Game> gameList = new ArrayList<>();
            usernameField.setText(currentAccount.getUserName());
            levelField.setText(String.valueOf(currentAccount.getLevel()));
            expField.setText(currentAccount.getExp() + " XP");
            for (Map.Entry<String, Game> e : currentAccount.getLibrary().entrySet()) {
                gameList.add(e.getValue());
            }
            try{
                Node gameNode = createGameNode(gameList.get(0));
                game1.getChildren().add(gameNode);
            }
            catch (Exception e){
                System.out.println("too little game");
            }
            try{
                Node gameNode = createGameNode(gameList.get(1));
                game2.getChildren().add(gameNode);
            }
            catch (Exception e){
                System.out.println("too little game");
            }
            try{
                Node gameNode = createGameNode(gameList.get(2));
                game3.getChildren().add(gameNode);
            }
            catch (Exception e){
                System.out.println("too little game");
            }


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
    private Node createGameNode(Game game) {
        ImageView imageView = new ImageView();
        Text gameText = new Text(game.getGameTitle());
        Image image = new Image(game.getImage());
        imageView.setImage(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        gameText.setFont(Font.font(16));
        HBox vbox = new HBox();
        vbox.getChildren().addAll(imageView, gameText);

        return vbox;
    }


}
