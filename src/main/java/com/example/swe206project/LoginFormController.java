package com.example.swe206project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class LoginFormController {

    double x,y = 0;

    @FXML
    private Button loginButton;

    @FXML
    private ImageView clearUsername;

    @FXML
    private ImageView clearPassword;

    @FXML
    private ImageView failedLoginIcon;

    @FXML
    private GridPane rootPane;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Label title;

    @FXML
    private Label failedLoginLabel;

    @FXML
    private Text welcomeLabel;

    @FXML
    private Text promptLabel;

    @FXML
    void checkCredintials(MouseEvent event) throws IOException {
        String credentials = username.getText() + " " + password.getText();
        ReadFiles credentialsFile = new ReadFiles("UserAndPass.txt");
        Boolean autherized = false;
        
        try {
            for (String Username_Pass : credentialsFile.openFile()) {
                if(credentials.equals(Username_Pass)){
                    autherized = true;
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (autherized){
            //failedLoginLabel.setVisible(false); no need for these two lines
            //failedLoginIcon.setVisible(false);
            switchToMenuPage();
        } else{
            failedLoginLabel.setVisible(true);
            failedLoginIcon.setVisible(true);
            username.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
            password.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
         }
    }

    @FXML
    void clearUsernameInput(MouseEvent event) {
        username.clear();
    }

    @FXML
    void clearPasswordInput(MouseEvent event) {
        password.clear();
    }

    @FXML
    void usernameInHover(MouseEvent event) {
        clearUsername.setStyle("-fx-opacity: 1; -fx-cursor: hand");
        username.setStyle("-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void passwordInHover(MouseEvent event) {
        clearPassword.setStyle("-fx-opacity: 1; -fx-cursor: hand");
        password.setStyle("-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void usernameOutHover(MouseEvent event) {
        clearUsername.setStyle("-fx-opacity: 0.4");
        username.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void passwordOutHover(MouseEvent event) {
        clearPassword.setStyle("-fx-opacity: 0.4");
        password.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void loginOnReleased(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        loginButton.setEffect(new Glow(0.0));
    }

    @FXML
    void loginOnPressed(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        loginButton.setEffect(new Glow(0.3));
    }

    @FXML
    void loginInHover(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void loginOutHover(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }


    public void switchToMenuPage () throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuPage.fxml"));
        Stage stage = new Stage();
        stage.initStyle(StageStyle.UNDECORATED);

        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });

        root.setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() - x);
            stage.setY(event.getScreenY() - y);
        });

        Scene menuPaageScene = new Scene(root);
        stage.setScene(menuPaageScene);
        stage.show();

        rootPane.getScene().getWindow().hide();
        }

}
