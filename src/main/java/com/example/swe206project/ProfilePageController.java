package com.example.swe206project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfilePageController {

    private User user = LoginFormController.user;

    @FXML
    protected static Button cancel;

    @FXML
    protected static ImageView editPhotoIcon;

    @FXML
    protected static Button editProfile;

    @FXML
    protected static TextField height;

    @FXML
    protected static TextField name;

    @FXML
    protected static ImageView profilePhoto;

    @FXML
    protected static Button save;

    @FXML
    protected static TextField statusOrCount;

    @FXML
    protected static Label statusOrCountLabel;

    @FXML
    protected static ImageView subscriptionButton;

    @FXML
    protected static TextField trainerOrSpeciality;

    @FXML
    protected static Label trainerOrSpecialityLabel;

    @FXML
    protected static TextField username;

    @FXML
    protected static TextField weight;

    
}
