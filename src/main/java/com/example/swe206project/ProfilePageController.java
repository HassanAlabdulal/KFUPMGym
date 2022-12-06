package com.example.swe206project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfilePageController {

    private User user = LoginFormController.user;

    @FXML
    private ImageView editPhotoIcon;

    @FXML
    private TextField height;

    @FXML
    private TextField name;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private TextField username;

    @FXML
    private TextField weight;

    @FXML
    private TextField x;

    @FXML
    private Label y;

    public ProfilePageController() {
        username.setText(user.getUsername());
        name.setText(user.getName());
        height.setText(user.getHeight() + "");
        weight.setText(user.getWeight() + "");
        if (user instanceof Trainee) {
            user = (Trainee) user;
            x.setText("user.getTrainer()");
        } else {
            user = (Trainer) user;
            y.setText("Speciality");
            x.setText("user.getSpeciality()");
        }
    }
}
