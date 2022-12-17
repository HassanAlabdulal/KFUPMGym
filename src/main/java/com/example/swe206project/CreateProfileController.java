package com.example.swe206project;

import java.util.HexFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class CreateProfileController {

    @FXML
    private Button createProfileButton;

    @FXML
    private ImageView failIcon;

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
    private Label errorMessage;

    boolean trainerCreateProfileIsClicked = false;
    boolean traineeCreateProfileIsClicked = false;



    @FXML
    void trainerButtonOnClicked(MouseEvent event) {
      trainerButton.setVisible(false);
      traineeButton.setVisible(false);
      trainerOrTrainee.setVisible(false);
      trainerIcon.setVisible(false);
      traineeIcon.setVisible(false);

      createProfileButton.setVisible(true);
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
      trainerCreateProfileIsClicked = true;
      traineeCreateProfileIsClicked = false;
      
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


      createProfileButton.setVisible(true);
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
      traineeCreateProfileIsClicked = true;
      trainerCreateProfileIsClicked = false;

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

        createProfileButton.setVisible(false);
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
        errorMessage.setVisible(false);
        failIcon.setVisible(false);
        traineeCreateProfileIsClicked = false;
        trainerCreateProfileIsClicked = false;

        name.clear();
        height.clear();
        weight.clear();
        speciality.clear();

        name.setStyle(
                "-fx-border-color: #43896B; -fx-border-width:  1px 0px 0px 1px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 5px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 5px;"
        );
        clearNameInput.setStyle("-fx-opacity: 0.4");

        height.setStyle(
             "-fx-border-color: #43896B; -fx-border-width:   0px 1px 0px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 0px;"
        );
        clearHeightInput.setStyle("-fx-opacity: 0.4");

        weight.setStyle(
             "-fx-border-color: #43896B; -fx-border-width: 0px 0px 0px 1px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 5px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 5px;"
        );
        clearWeightInput.setStyle("-fx-opacity: 0.4");

        speciality.setStyle(
             "-fx-border-color: #43896B; -fx-border-width: 0px 1px 1px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1; -fx-border-radius:  5px 5px 5px 0px;"
        );
        clearSpecialityInput.setStyle("-fx-opacity: 0.4");
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


    @FXML
    void createProfileButtonOnClicked(MouseEvent event) {
        if(traineeCreateProfileIsClicked){
            if(name.getText().isEmpty() || height.getText().isEmpty() || weight.getText().isEmpty()){
                if(name.getText().isEmpty()){
                    name.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    errorMessage.setText("Please enter all required credentials!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true);

                }

                if(height.getText().isEmpty()){
                    height.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    errorMessage.setText("Please enter all required credentials!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true);

                }

                if(weight.getText().isEmpty()){
                    weight.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    errorMessage.setText("Please enter all required credentials!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true);

                }
            }else{

                try{ 
                    int test1, test2;
                    test1 = Integer.parseInt(height.getText());
                    test2 = Integer.parseInt(weight.getText());
                    // boolean allLettersName = name.getText().chars().allMatch(Character::isLetter);
                    Pattern pattern = Pattern.compile("\\p{Digit}|\\p{Punct}|\\p{Sc}");
                    Matcher match = pattern.matcher(name.getText());
                    boolean allLettersName = !match.find();
                    if(allLettersName){
                        GymManager.createProfile(name.getText(),  Double.parseDouble(height.getText()),Double.parseDouble(weight.getText()));
                        errorMessage.setText("A trainer profile has been created!");
                        errorMessage.setStyle("-fx-text-fill: #43896B");
                        errorMessage.setVisible(true);
                        failIcon.setVisible(false); 
                        name.clear();
                        height.clear();
                        weight.clear();
                        speciality.clear();
                    }else{
                        errorMessage.setText("Please enter only letters!");
                        errorMessage.setStyle("-fx-text-fill: #D53A0B");
                        errorMessage.setVisible(true);
                        failIcon.setVisible(true); 
                        name.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    }
                }catch(Exception e){
                    e.printStackTrace();
                    errorMessage.setText("Please enter correct information!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true); 
                }
            }
        }

        if(trainerCreateProfileIsClicked){
            if(name.getText().isEmpty() || height.getText().isEmpty() || weight.getText().isEmpty() || speciality.getText().isEmpty()){
                if(name.getText().isEmpty()){
                    name.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    errorMessage.setText("Please enter all required credentials!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true);

                }

                if(height.getText().isEmpty()){
                    height.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    errorMessage.setText("Please enter all required credentials!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true);

                }

                if(weight.getText().isEmpty()){
                    weight.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    errorMessage.setText("Please enter all required credentials!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true);

                }

                if(speciality.getText().isEmpty()){
                    speciality.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                    errorMessage.setText("Please enter all required credentials!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true);
                }
            }else{

                try{ 
                    int test1, test2;
                    test1 = Integer.parseInt(height.getText());
                    test2 = Integer.parseInt(weight.getText());
                    //boolean allLettersName = name.getText().chars().allMatch(Character::isLetter);
                    //boolean allLettersSpeciality = speciality.getText().chars().allMatch(Character::isLetter);
                    Pattern pattern = Pattern.compile("\\p{Digit}|\\p{Punct}|\\p{Sc}");
                    Matcher match = pattern.matcher(name.getText());
                    Matcher match2 = pattern.matcher(speciality.getText());
                    boolean allLettersName = !match.find();
                    boolean allLettersSpeciality = !match2.find();
                    if(allLettersName && allLettersSpeciality){
                        GymManager.createProfile(name.getText(),  Double.parseDouble(height.getText()),Double.parseDouble(weight.getText()), speciality.getText());
                        errorMessage.setText("A trainer profile has been created!");
                        errorMessage.setStyle("-fx-text-fill: #43896B");
                        errorMessage.setVisible(true);
                        failIcon.setVisible(false); 
                        name.clear();
                        height.clear();
                        weight.clear();
                        speciality.clear();
                    }else{
                        errorMessage.setText("Please enter only letters!");
                        errorMessage.setStyle("-fx-text-fill: #D53A0B");
                        errorMessage.setVisible(true);
                        failIcon.setVisible(true); 
                        speciality.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
                        name.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");

                    }
                }catch(Exception e){
                    errorMessage.setText("Please enter correct information!");
                    errorMessage.setStyle("-fx-text-fill: #D53A0B");
                    errorMessage.setVisible(true);
                    failIcon.setVisible(true); 
                }
                
                
            }
        }
    }

    @FXML
    void createProfileButtonOnPressed(MouseEvent event) {
        createProfileButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        createProfileButton.setEffect(new Glow(0.3));
    }

    @FXML
    void createProfileButtonOnReleased(MouseEvent event) {
        createProfileButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        createProfileButton.setEffect(new Glow(0.0));
    }

    @FXML
    void createProfileButtonInHover(MouseEvent event) {
        createProfileButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void createProfileButtonOutHover(MouseEvent event) {
        createProfileButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }
}


