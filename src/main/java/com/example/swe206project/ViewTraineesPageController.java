package com.example.swe206project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ViewTraineesPageController implements Initializable {

    @FXML
    private Button addNewTrainee;

    @FXML
    private Button assignPlan;

    @FXML
    private Button progress;

    @FXML
    private Label message;

    @FXML
    private ImageView messageIcon;

    @FXML
    private TableView<Trainee> viewTraineesTable;

    @FXML
    public TableColumn<Trainee, String> name;

    @FXML
    private TableColumn<Trainee, Double> height;

    @FXML
    private TableColumn<Trainee, Double> weight;

    @FXML
    private TableColumn<Trainee, Plan> plan;

    @FXML
    private TableColumn<Trainee, String> status;

    @FXML
    private Trainer trainer = (Trainer) LoginFormController.user;

    @FXML
    public void initialize() {
        
        name.setCellValueFactory(new PropertyValueFactory<Trainee, String>("name"));
        height.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("weight"));
        plan.setCellValueFactory(new PropertyValueFactory<Trainee, Plan>("plan"));
        status.setCellValueFactory(new PropertyValueFactory<Trainee, String>("status"));
       
        viewTraineesTable.setItems(trainer.getTest());
    }

    // Add new trainee button design
    @FXML
    void addNewTraineeOnClicked(MouseEvent event) {

    }

    @FXML
    void addNewTraineeOnPressed(MouseEvent event) {
        addNewTrainee.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        addNewTrainee.setEffect(new Glow(0.3));
    }

    @FXML
    void addNewTraineeOnReleased(MouseEvent event) {
        addNewTrainee.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        addNewTrainee.setEffect(new Glow(0.0));
    }

    @FXML
    void addNewTraineeInHover(MouseEvent event) {
        addNewTrainee.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void addNewTraineeOutHover(MouseEvent event) {
        addNewTrainee.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    // Assign plan button design
    @FXML
    void assignPlanOnClicked(MouseEvent event) {

    }

    @FXML
    void assignPlanOnPressed(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        assignPlan.setEffect(new Glow(0.3));
    }

    @FXML
    void assignPlanOnReleased(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        assignPlan.setEffect(new Glow(0.0));
    }

    @FXML
    void assignPlanInHover(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void assignPlanOutHover(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    // Progress button style
    @FXML
    void progressPlanOnClicked(MouseEvent event) {

    }
    @FXML
    void progressOnPressed(MouseEvent event) {
        progress.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        progress.setEffect(new Glow(0.3));
    }

    @FXML
    void progressOnReleased(MouseEvent event) {
        progress.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        progress.setEffect(new Glow(0.0));
    }

    @FXML
    void progressInHover(MouseEvent event) {
        progress.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void progressOutHover(MouseEvent event) {
        progress.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

}
