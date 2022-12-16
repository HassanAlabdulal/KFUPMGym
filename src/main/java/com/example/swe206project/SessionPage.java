package com.example.swe206project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SessionPage {
  

    @FXML
    private ImageView backArrow;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private TableColumn<?, ?> height;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> plan;

    @FXML
    private TableView<?> sessionsTable;

    @FXML
    private Button startWorkoutButton;

    @FXML
    private TableColumn<?, ?> weight;

    @FXML
    void backArrowOnClicked(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("PlanPage.fxml"));
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
    void startWorkoutButtonOnClicked(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("WorkoutPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);  
    }
 
    @FXML
    void startWorkoutButtonOnPressed(MouseEvent event) {
        startWorkoutButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        startWorkoutButton.setEffect(new Glow(0.3));
    }

    @FXML
    void startWorkoutButtonOnReleased(MouseEvent event) {
        startWorkoutButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        startWorkoutButton.setEffect(new Glow(0.0));
    }

    @FXML
    void startWorkoutButtonInHover(MouseEvent event) {
        startWorkoutButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void startWorkoutButtonOutHover(MouseEvent event) {
        startWorkoutButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }



    


}
