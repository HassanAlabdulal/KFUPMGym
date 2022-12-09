package com.example.swe206project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ProfilePageController implements Initializable {

    private User user = LoginFormController.user;

    @FXML
    private Button cancel;

    @FXML
    private ImageView editPhotoIcon;

    @FXML
    private Button editProfile;

    @FXML
    private TextField height;

    @FXML
    private TextField name;

    @FXML
    private ImageView profilePhoto;

    @FXML
    private Button save;

    @FXML
    private TextField statusOrCount;

    @FXML
    private Label statusOrCountLabel;

    @FXML
    private ImageView subscriptionButton;

    @FXML
    private TextField trainerOrSpeciality;

    @FXML
    private Label trainerOrSpecialityLabel;

    @FXML
    private TextField username;

    @FXML
    private TextField weight;

    @FXML
    public void initialize() {
        name.setText(user.getName());
        height.setText(user.getHeight() + " cm");
        weight.setText(user.getWeight() + " kg");

        if (user instanceof Trainee) {
            Trainee trainee = (Trainee) user;

            if (trainee.isActive(trainee.getUsername())) {
                statusOrCount.setText("Active");
            } else {
                statusOrCount.setText("not Active");
            }
            username.setText(trainee.getUsername());
            trainerOrSpeciality.setText(trainee.trainer);
        } else {
            Trainer trainer = (Trainer) user;

            username.setText(trainer.getUsername());
            trainerOrSpecialityLabel.setText("Speciality");
            trainerOrSpeciality.setText(trainer.getSpeciality());
            statusOrCountLabel.setText("Trainees count");
            statusOrCount.setText(trainer.getTraineesList().size() + " trainees");
        }
    }

}
