package com.example.swe206project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CreateProfileController {

    @FXML
    private Button createProfile;

    @FXML
    private ImageView clearHeightInput;

    @FXML
    private ImageView clearSpecialityInput;

    @FXML
    private ImageView clearNameInput;

    @FXML
    private ImageView clearWeightInput;

    @FXML
    private ImageView backArrow;

    @FXML
    private TextField height;

    @FXML
    private Label heightLable;

    @FXML
    private TextField name;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField speciality;

    @FXML
    private Label specialityLabel;

    @FXML
    private Button traineeButton;

    @FXML
    private ImageView traineeIcon;

    @FXML
    private Button trainerButton;

    @FXML
    private ImageView trainerIcon;

    @FXML
    private Label trainerOrTrainee;

    @FXML
    private TextField weight;

    @FXML
    private Label weightLable;



    @FXML
    void trainerButtonOnClicked(MouseEvent event) {
      trainerButton.setVisible(false);
      traineeButton.setVisible(false);
      trainerOrTrainee.setVisible(false);
      trainerIcon.setVisible(false);
      traineeIcon.setVisible(false);

      createProfile.setVisible(true);
      name.setVisible(true);
      nameLabel.setVisible(true);
      height.setVisible(true);
      heightLable.setVisible(true);
      weight.setVisible(true);
      weightLable.setVisible(true);
      speciality.setVisible(true);
      specialityLabel.setVisible(true);
      clearNameInput.setVisible(true);
      clearWeightInput.setVisible(true);
      clearHeightInput.setVisible(true);
      clearSpecialityInput.setVisible(true);
      backArrow.setVisible(true);
      name.setEditable(true);
      height.setEditable(true);
      weight.setEditable(true);
      speciality.setEditable(true);
      
    }

    @FXML
    void trainerButtonOnPressed(MouseEvent event) {
      trainerButton.setStyle(
            "-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand"
        );
        trainerButton.setEffect(new Glow(0.3));
    }

    @FXML
    void trainerButtonOnReleased(MouseEvent event) {
        trainerButton.setStyle(
            "-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand"
        );
        trainerButton.setEffect(new Glow(0.0));
    }

    @FXML
    void trainerButtonInHover(MouseEvent event) {
        trainerButton.setStyle(
            "-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand"
        );
    }

    @FXML
    void trainerButtonOutHover(MouseEvent event) {
        trainerButton.setStyle(
            "-fx-background-color: #43896B; -fx-background-radius: 15"
        );
    }



    @FXML
    void traineeButtonOnClicked(MouseEvent event) {
      trainerButton.setVisible(false);
      traineeButton.setVisible(false);
      trainerOrTrainee.setVisible(false);
      trainerIcon.setVisible(false);
      traineeIcon.setVisible(false);
      speciality.setVisible(false);
      specialityLabel.setVisible(false);


      createProfile.setVisible(true);
      name.setVisible(true);
      nameLabel.setVisible(true);
      height.setVisible(true);
      heightLable.setVisible(true);
      weight.setVisible(true);
      weightLable.setVisible(true);
      clearNameInput.setVisible(true);
      clearWeightInput.setVisible(true);
      clearHeightInput.setVisible(true);
      backArrow.setVisible(true);
      name.setEditable(true);
      height.setEditable(true);
      weight.setEditable(true);
    }

    @FXML
    void traineeButtonOnPressed(MouseEvent event) {
        traineeButton.setStyle(
            "-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand"
        );
        traineeButton.setEffect(new Glow(0.3));
    }

    @FXML
    void traineeButtonOnReleased(MouseEvent event) {
        traineeButton.setStyle(
            "-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand"
        );
        traineeButton.setEffect(new Glow(0.0));
    }

    @FXML
    void traineeButtonInHover(MouseEvent event) {
        traineeButton.setStyle(
            "-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand"
        );
    }

    @FXML
    void traineeButtonOutHover(MouseEvent event) {
        traineeButton.setStyle(
            "-fx-background-color: #43896B; -fx-background-radius: 15"
        );
    }

    @FXML
    void clearNameInputOnClicked(MouseEvent event) {
        name.clear();
    }

    @FXML
    void nameInHover(MouseEvent event) {
            name.setStyle(
                "-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width:  1px 0px 0px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 5px; -fx-text-fill: #F4F9F1; fx-border-radius:5px 5px 0px 5px;"
            );
            clearNameInput.setStyle("-fx-opacity: 1; -fx-cursor: hand");
    }

    @FXML
    void nameOutHover(MouseEvent event) {
            name.setStyle(
                "-fx-border-color: #43896B; -fx-border-width:  1px 0px 0px 1px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 5px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 5px;"
            );
            clearNameInput.setStyle("-fx-opacity: 0.4");
    }

    @FXML
    void clearHeightInputOnClicked(MouseEvent event) {
        height.clear();
    }

    @FXML
    void heightInHover(MouseEvent event) {
            height.setStyle(
                "-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width:   0px 1px 0px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 0px;"
            );
            clearHeightInput.setStyle("-fx-opacity: 1; -fx-cursor: hand");
    }

    @FXML
    void heightOutHover(MouseEvent event) {
            height.setStyle(
                "-fx-border-color: #43896B; -fx-border-width:   0px 1px 0px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 0px;"
            );
            clearHeightInput.setStyle("-fx-opacity: 0.4");
            
    }

    @FXML
    void clearWeightInputOnClicked(MouseEvent event) {
        weight.clear();
    }

    @FXML
    void weightInHover(MouseEvent event) {
         weight.setStyle(
                "-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width: 0px 0px 0px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 5px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 5px;"
            );
            clearWeightInput.setStyle("-fx-opacity: 1; -fx-cursor: hand");
    }

    @FXML
    void weightOutHover(MouseEvent event) {
            weight.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 0px 1px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 5px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 5px;"
            );
            clearWeightInput.setStyle("-fx-opacity: 0.4");
    }

    @FXML
    void clearSpecialityInputOnClicked(MouseEvent event) {
        speciality.clear();
    }

    @FXML
    void specialityInHover(MouseEvent event) {
            speciality.setStyle(
                "-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width:   0px 1px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius:  5px 5px 5px 0px;"
            );
            clearSpecialityInput.setStyle("-fx-opacity: 1; -fx-cursor: hand");
    }

    @FXML
    void specialityOutHover(MouseEvent event) {
            speciality.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 1px 1px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1; -fx-border-radius:  5px 5px 5px 0px;"
            );
            clearSpecialityInput.setStyle("-fx-opacity: 0.4");
    }
    
    @FXML
    void backArrowOnclicked(MouseEvent event) {
        trainerButton.setVisible(true);
        traineeButton.setVisible(true);
        trainerOrTrainee.setVisible(true);
        trainerIcon.setVisible(true);
        traineeIcon.setVisible(true);

        createProfile.setVisible(false);
        name.setVisible(false);
        nameLabel.setVisible(false);
        height.setVisible(false);
        heightLable.setVisible(false);
        weight.setVisible(false);
        weightLable.setVisible(false);
        speciality.setVisible(false);
        specialityLabel.setVisible(false);
        clearNameInput.setVisible(false);
      clearWeightInput.setVisible(false);
      clearHeightInput.setVisible(false);
      clearSpecialityInput.setVisible(false);
        backArrow.setVisible(false);

        name.clear();
        height.clear();
        weight.clear();
        speciality.clear();
    }

    @FXML
    void backArrowOnPressed(MouseEvent event) {
        backArrow.setStyle("-fx-cursor: hand");
        backArrow.setEffect(new Glow(0.3));
    }

    @FXML
    void backArrowOnReleased(MouseEvent event) {
        backArrow.setStyle("-fx-cursor: hand");
        backArrow.setEffect(new Glow(0.0));
    }
}
