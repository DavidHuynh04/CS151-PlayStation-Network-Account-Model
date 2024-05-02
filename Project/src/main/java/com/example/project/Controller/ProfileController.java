package com.example.project.Controller;

import com.example.project.Model.Account;
import com.example.project.Model.Game;
import com.example.project.Model.GamesLibrary;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ProfileController {
    @FXML
    public Text exp;

    public TextField searchBar;

    public HBox cardsContainer;

    @FXML
    private Text level;

    @FXML
    private Text username;

    private Account currentAccount;

    public void setCurrentProfileAccount(Account account) {
        this.currentAccount = account;
        updateProfile();

    }

    @FXML
    private void updateProfile() {
        if (currentAccount != null) {
            username.setText(currentAccount.getUserName());
            level.setText(String.valueOf(currentAccount.getLevel()));
            exp.setText(currentAccount.getExp() + " XP");
        }
    }
    @FXML
    void searchingClicked(MouseEvent event) {
        System.out.println("You typed: " + searchBar.getCharacters());
        String input = searchBar.getCharacters().toString().toUpperCase();
        Game game= GamesLibrary.getInstance().getGame(input);
        if (game != null) {
            cardsContainer.getChildren().clear();
            Node gameNode = createGameNode(game);
            cardsContainer.getChildren().add(gameNode);
        }
        else {
            System.out.println("Game not found: " + input);
            cardsContainer.getChildren().clear();
        }
    }
    private Node createGameNode(Game game) {
        ImageView imageView = new ImageView();
        Text gameText = new Text(game.getGameTitle());
        Image image = new Image(game.getImage());
        imageView.setImage(image);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        gameText.setFont(Font.font(16));
        VBox vbox = new VBox();
        vbox.getChildren().addAll(imageView, gameText);

        return vbox;
    }


}
