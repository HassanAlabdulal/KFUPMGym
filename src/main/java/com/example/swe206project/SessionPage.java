package com.example.swe206project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class SessionPage {
  

  @FXML
  private ImageView backArrow;

  @FXML
  private AnchorPane contentArea;

  @FXML
  private TableColumn<?, ?> name;

  @FXML
  private Button startWorkoutButton;

  @FXML
  private TableColumn<?, ?> targetedMuscles;

  @FXML
  private TableColumn<?, ?> targetedRepetitions;

  @FXML
  private TableColumn<?, ?> targetedSets;

  @FXML
  private TableView<?> viewTraineesTable;

    @FXML
    void switchToWorkoutPage(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("WorkoutPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);  
    }

    @FXML
    void switchToPlanPage(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("PlanPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);  
    }


}
