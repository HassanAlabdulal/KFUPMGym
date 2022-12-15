package com.example.swe206project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkoutPage implements Initializable{
  
    @FXML
    private TextField actualRepetitions;

    

    @FXML
    private Label errorMessage;

    @FXML
    private ImageView failIcon;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private TextField actualSets;

    @FXML
    private ImageView backArrow;

    @FXML
    private Button submitButton;

    @FXML
    private TextField targetedMuscles;

    @FXML
    private Label targetedMusclesLabel;

    @FXML
    private Label successfullMessage;

    @FXML
    private TextField targetedRepetitions;

    @FXML
    private Label targetedRepetitionsLabel;

    @FXML
    private TextField targetedSets;

    @FXML
    private Label targetedSetsLabel;

    @FXML
    private Button videoButton;

    @FXML
    private TextField weightUsed;

    // @Override
    // public void initialize(URL url, ResourceBundle resourceBundle) {
    //   videoButtonOnClicked();
    // }

    

    @FXML
    void backArrowOnClicked(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);  
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
    void submitButtonOnClicked(MouseEvent event) throws IOException {
      if(actualRepetitions.getText().isEmpty() || actualSets.getText().isEmpty() || weightUsed.getText().isEmpty()){
        if(actualRepetitions.getText().isEmpty()){
            actualRepetitions.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
            errorMessage.setVisible(true);
            failIcon.setVisible(true);
            successfullMessage.setVisible(false);


        }

        if(actualSets.getText().isEmpty()){
            actualSets.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
            errorMessage.setVisible(true);
            failIcon.setVisible(true);
            successfullMessage.setVisible(false);


        }

        if(weightUsed.getText().isEmpty()){
            weightUsed.setStyle("-fx-border-color: #D53A0B; -fx-border-width: 1px 1px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
            errorMessage.setVisible(true);
            failIcon.setVisible(true);
            successfullMessage.setVisible(false);


        }
    }else{
        successfullMessage.setVisible(true);
        errorMessage.setVisible(false);
        failIcon.setVisible(false);
        actualRepetitions.clear();
        actualSets.clear();
        weightUsed.clear();
        
    }
  }
 
    @FXML
    void submitButtonOnPressed(MouseEvent event) {
        submitButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        submitButton.setEffect(new Glow(0.3));
    }

    @FXML
    void submitButtonOnReleased(MouseEvent event) {
        submitButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        submitButton.setEffect(new Glow(0.0));
    }

    @FXML
    void submitButtonInHover(MouseEvent event) {
        submitButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void submitButtonOutHover(MouseEvent event) {
        submitButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    @FXML
    void actualRepetitionsInHover(MouseEvent event) {
          actualRepetitions.setStyle(
                "-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width:   0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius:  5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 0px;"
            );
          actualRepetitions.setEditable(true);
    }

    @FXML
    void actualRepetitionsOutHover(MouseEvent event) {
          actualRepetitions.setStyle(
                "-fx-border-color: #43896B; -fx-border-width:   0px 0px 1px 0px; -fx-background-color: #313131; -fx-background-radius:  5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius:  5px 5px 0px 0px;"
            );
          actualRepetitions.setEditable(true);
    }

    @FXML
    void actualSetsInHover(MouseEvent event) {
          actualSets.setStyle(
                "-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width:   0px 1px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius:  5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 0px;"
            );
          actualSets.setEditable(true);
    }

    @FXML
    void actualSetsOutHover(MouseEvent event) {
          actualSets.setStyle(
                "-fx-border-color: #43896B; -fx-border-width:   0px 1px 1px 0px; -fx-background-color: #313131; -fx-background-radius:  5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius:  5px 5px 0px 0px;"
            );
          actualSets.setEditable(true);
    }

    @FXML
    void weightUsedInHover(MouseEvent event) {
          weightUsed.setStyle(
                "-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width:   0px 0px 1px 1px; -fx-background-color: #3A4141; -fx-background-radius:  5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius: 5px 5px 0px 0px;"
            );
          weightUsed.setEditable(true);
    }

    @FXML
    void weightUsedOutHover(MouseEvent event) {
          weightUsed.setStyle(
                "-fx-border-color: #43896B; -fx-border-width:   0px 0px 1px 1px; -fx-background-color: #313131; -fx-background-radius:  5px 5px 0px 0px; -fx-text-fill: #F4F9F1; fx-border-radius:  5px 5px 0px 0px;"
            );
          weightUsed.setEditable(true);
    }


    

    @FXML
    void videoButtonOnClicked(MouseEvent event) throws IOException {
      
      
      
      
    }


    @FXML
    void videoButtonOnPressed(MouseEvent event) {
        videoButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        videoButton.setEffect(new Glow(0.3));
    }

    @FXML
    void videoButtonOnReleased(MouseEvent event) {
        videoButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        videoButton.setEffect(new Glow(0.0));
    }

    @FXML
    void videoButtonInHover(MouseEvent event) {
        videoButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void videoButtonOutHover(MouseEvent event) {
        videoButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }
}

