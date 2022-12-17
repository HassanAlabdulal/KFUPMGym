package com.example.swe206project;

import java.io.IOException;

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

public class SessionPage implements Initializable{
  

    @FXML
    private ImageView backArrow;

    @FXML
    private Label message;

    @FXML
    private ImageView messageIcon;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private Button startWorkoutButton;

    @FXML
    private TableView<Workouts> sessionsTable;

    @FXML
    private TableColumn<Workouts, String> workoutName;

    @FXML
    private TableColumn<Workouts, String> targetedMuscles;

    @FXML
    private TableColumn<Workouts, Integer> repititionTarget;

    @FXML
    private TableColumn<Workouts, Integer> setsTarget;

    @FXML
    private Trainee trainee = (Trainee) LoginFormController.user;

    public static Session dSession;

    protected static Workouts workout;

    protected String day = PlanPageController.day;

    public Session desiredSession(){
        for (Session session : trainee.getObservableSessionsList()) {
            if(session.day.equals(day))
                return session;
        }
        return new Session(-1);
    }

    @FXML
    public void initialize() {
        
        workoutName.setCellValueFactory(new PropertyValueFactory<Workouts, String>("workoutName"));
        targetedMuscles.setCellValueFactory(new PropertyValueFactory<Workouts, String>("targetedMuscles"));
        repititionTarget.setCellValueFactory(new PropertyValueFactory<Workouts, Integer>("repititionTarget"));
        setsTarget.setCellValueFactory(new PropertyValueFactory<Workouts, Integer>("setsTarget"));

        
       
        // sessionsTable.setItems(trainee.getObservableWorkoutsList());
        dSession = desiredSession();
        sessionsTable.setItems(desiredSession().getObservableWorkoutsList());

        messageIcon.setVisible(false);
        message.setVisible(false);
    }

    @FXML
    public void startWorkoutButtonOnClicked(MouseEvent Event) throws IOException, NullPointerException {
        workout = sessionsTable.getSelectionModel().getSelectedItem();

        try {
            if(!(workout == null)) {
                AnchorPane startWorkout = FXMLLoader.load(getClass().getResource("WorkoutPage.fxml"));
                contentArea.getChildren().removeAll();
                contentArea.getChildren().setAll(startWorkout);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
                messageIcon.setVisible(true);
                message.setVisible(true);
        }
    }

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

    // @FXML
    // void startWorkoutButtonOnClicked(MouseEvent event) throws IOException {
    //     Parent fxml = FXMLLoader.load(getClass().getResource("WorkoutPage.fxml"));
    //     contentArea.getChildren().removeAll();
    //     contentArea.getChildren().setAll(fxml);  
    // }
 
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
