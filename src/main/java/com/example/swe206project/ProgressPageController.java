package com.example.swe206project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class ProgressPageController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView back;

    @FXML
    private ComboBox<Session> sessionDays;

    @FXML
    private TableView<Workouts> progressTable;

    @FXML
    private TableColumn<Workouts, String> workoutName;

    @FXML
    private TableColumn<Workouts, String> weightProgress;

    @FXML
    private TableColumn<Workouts, String> setsProgress;

    @FXML
    private TableColumn<Workouts, String> repititionProgress;

    @FXML
    private TableColumn<Workouts, String> volumeProgress;

    @FXML
    private Trainee trainee = ViewTraineesPageController.trainee;

    protected Session session;
    protected static Session desiredSession;

    @FXML
    public void initialize() {
        sessionDays.setItems(trainee.getObservableSessionsList());
        
        sessionDays.setCellFactory(new Callback<ListView<Session>, ListCell<Session>>() {
            @Override
            public ListCell<Session> call(ListView<Session> param) {
                return new ListCell<Session>() {
                        @Override 
                        protected void updateItem(Session session, boolean empty) {
                            super.updateItem(session, empty);
                            
                            if (session == null || empty) {
                                setText(null);
                            } else { 
                                setText(session.getDay()); //Set the text to be displayed as the name property of your object.            
                            }                   
                        }  
                };
            }
        });

        sessionDays.setConverter(new StringConverter<Session>() {
            @Override
            public String toString(Session session) {
                if (session == null){
                    return null;
                } else {
                    return session.getDay();
                }
            }

            @Override
            public Session fromString(String arg0) {
                // TODO Auto-generated method stub
                return new Session(Integer.valueOf(arg0));
            }
        });
    }

    @FXML
    void setSessionWorkouts(ActionEvent event) {
        session = sessionDays.getValue();
        desiredSession = session;
        
        workoutName.setCellValueFactory(new PropertyValueFactory<Workouts, String>("workoutName"));
        weightProgress.setCellValueFactory(new PropertyValueFactory<Workouts, String>("weightProgress"));
        setsProgress.setCellValueFactory(new PropertyValueFactory<Workouts, String>("setsProgress"));
        repititionProgress.setCellValueFactory(new PropertyValueFactory<Workouts, String>("repitionsProgress"));
        volumeProgress.setCellValueFactory(new PropertyValueFactory<Workouts, String>("volumeProgress"));

        progressTable.setItems(session.getObservableWorkoutsList());
    }

    // Back icon design
    @FXML
    public void backToViewTraineesPage(MouseEvent event) throws IOException {
        AnchorPane viewTraineesPage = FXMLLoader.load(getClass().getResource("ViewTraineesPage.fxml"));
        rootPane.getChildren().removeAll();
        rootPane.getChildren().setAll(viewTraineesPage);
    }

    @FXML
    void backInHover(MouseEvent event) {
        back.setStyle("-fx-cursor: hand");
    }

    @FXML
    void backOnPressed(MouseEvent event) {
        back.setStyle("-fx-cursor: hand");
        back.setEffect(new Glow(0.3));
    }

    @FXML
    void backOnReleased(MouseEvent event) {
        back.setStyle("-fx-cursor: hand");
        back.setEffect(new Glow(0.0));
    }



}
