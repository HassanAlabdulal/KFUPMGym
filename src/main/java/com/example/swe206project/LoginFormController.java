package com.example.swe206project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class LoginFormController {

    @FXML
    private Button loginButton;

    @FXML
    private ImageView clearUsername;

    @FXML
    private ImageView clearPassword;

    @FXML
    private ImageView failedLoginIcon;

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
    void checkCredintials(MouseEvent event) {
        String credentials = username.getText() + password.getText();
        ReadFiles credentialsFile = new ReadFiles("D:\\KFUPM\\Sophomore\\Term 221\\SWE 206\\project\\Phase 3\\Code\\SWE206-Project-main\\UserAndPass.txt");
        Alert alert = new Alert(AlertType.NONE);
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
            alert.setAlertType(AlertType.INFORMATION);
            alert.setContentText("success");
            alert.show();
        } else{
            //alert.setAlertType(AlertType.WARNING);
            //alert.setContentText("failed login");
            //alert.show();
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
    void changeUsernameIconOpacity(MouseEvent event) {
        clearUsername.setStyle("-fx-opacity: 1");
        username.setStyle("-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void changePasswordIconOpacity(MouseEvent event) {
        clearPassword.setStyle("-fx-opacity: 1");
        password.setStyle("-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void setUsernameIconOpacityToOriginal(MouseEvent event) {
        clearUsername.setStyle("-fx-opacity: 0.4");
    }

    @FXML
    void setPasswordIconOpacityToOriginal(MouseEvent event) {
        clearPassword.setStyle("-fx-opacity: 0.4");
    }

    @FXML
    void removeBorder(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    @FXML
    void setBorder(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #262B2B; -fx-background-radius: 15; -fx-border-color: #366D55; -fx-border-radius: 15px; -fx-border-width: 2px");
    }

    @FXML
    void setColor(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void setOriginalColor(MouseEvent event) {
        loginButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

}