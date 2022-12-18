package com.example.swe206project;

import java.io.IOException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.json.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

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
    private ImageView forgotPassIcon;

    @FXML
    private Label forgotPassLabel;

    @FXML
    private Text forgotPassMessage;

    @FXML
    protected static User user;

    @FXML
    protected static GymManager manager;

    @FXML
    void checkCredintials(MouseEvent event) throws IOException {

        String credentials = username.getText() + " " + password.getText();
        ReadFiles credentialsFile = new ReadFiles("UserAndPass.txt");
        Boolean autherized = false;
        
        try {
            String types = "trainee , trainer , GymManager";
            if(types.contains(API.get(username.getText(), password.getText()))){
                autherized = true;
                System.out.println("successfull login via API");
            }
            else{
                for (String Username_Pass : credentialsFile.openFile()) { 
                    if(credentials.equals(Username_Pass.replaceAll("\\p{Sc}\\p{ASCII}*$", ""))){
                        autherized = true;
                        System.out.println("successfull login via offline data");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (autherized && User.isActive(username.getText())){
            switch (User.getType(username.getText())) {
                case "trainee":
                    user = (Trainee) new Trainee(username.getText());
                    switchToMenu();
                    break;
                case "trainer":
                    user = (Trainer) new Trainer(username.getText());
                    switchToMenu();
                    break;
                case "GymManager":
                    manager = new GymManager(username.getText());
                    switchToGymManagerMenu();
                    break;
                default:
                    break;
            }      
        }else{
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

    @FXML
    void showMessage(MouseEvent event) {
        forgotPassIcon.setVisible(true);
        forgotPassMessage.setVisible(true);
        forgotPassLabel.setStyle("-fx-cursor: hand");
    }

    @FXML
    void hideMessage(MouseEvent event) {
        forgotPassIcon.setVisible(false);
        forgotPassMessage.setVisible(false);
    }

    public void switchToMenu () throws IOException {
        this.user = user;
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
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

        Scene menuScene = new Scene(root);
        stage.setScene(menuScene);
        stage.show();

        rootPane.getScene().getWindow().hide();
        }

        public void switchToGymManagerMenu() throws IOException {
            this.user = user;
            Parent root = FXMLLoader.load(getClass().getResource("GymManagerMenu.fxml"));
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
        
            Scene GymManagerMenuScene = new Scene(root);
            stage.setScene(GymManagerMenuScene);
            stage.show();
        
            rootPane.getScene().getWindow().hide();
        }

}