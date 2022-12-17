package com.example.swe206project;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class ViewTraineesPageController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    
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
   

    protected static Trainee trainee = new Trainee();

    @FXML
    public void initialize() {
        
        name.setCellValueFactory(new PropertyValueFactory<Trainee, String>("name"));
        height.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("weight"));
        plan.setCellValueFactory(new PropertyValueFactory<Trainee, Plan>("plan"));
        status.setCellValueFactory(new PropertyValueFactory<Trainee, String>("status"));
       
        viewTraineesTable.setItems(trainer.getObservableTraineesList());
    }

    // Add new trainee button design
    @FXML
    public void addNewTraineePage(ActionEvent Event) throws IOException {
        AnchorPane addNewTrainee = FXMLLoader.load(getClass().getResource("AddTraineePage.fxml"));
        rootPane.getChildren().removeAll();
        rootPane.getChildren().setAll(addNewTrainee);
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
    public void assignPlanPage(ActionEvent Event) throws IOException, NullPointerException {
        trainee = viewTraineesTable.getSelectionModel().getSelectedItem();

        try {
            if(!(trainee == null)) {
                AnchorPane assignPlan = FXMLLoader.load(getClass().getResource("AssignPlanPage.fxml"));
                rootPane.getChildren().removeAll();
                rootPane.getChildren().setAll(assignPlan);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
                messageIcon.setVisible(true);
                message.setText("Please select a trainee from the table to proceed.");
                message.setStyle("-fx-text-fill: #D53A0B");
                message.setVisible(true);
        }
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
    public void progressPage(ActionEvent Event) throws IOException, NullPointerException {
        trainee = viewTraineesTable.getSelectionModel().getSelectedItem();

        try {
            if(!(trainee == null) && !(trainee.getPlan().id == 0)) {
                AnchorPane progress = FXMLLoader.load(getClass().getResource("ProgressPage.fxml"));
                rootPane.getChildren().removeAll();
                rootPane.getChildren().setAll(progress);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
                messageIcon.setVisible(true);
                message.setText("Please select a trainee that has a plan from the table to proceed.");
                message.setStyle("-fx-text-fill: #D53A0B");
                message.setVisible(true);
        }
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
