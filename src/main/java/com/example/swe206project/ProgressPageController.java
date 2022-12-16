package com.example.swe206project;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class ProgressPageController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView back;

    @FXML
    private ComboBox<Session> sessionDays;

    @FXML
    private TableView<?> progressTable;

    @FXML
    private TableColumn<?, ?> workoutName;

    @FXML
    private TableColumn<?, ?> weightProgress;

    @FXML
    private TableColumn<?, ?> setsProgress;

    @FXML
    private TableColumn<?, ?> repititionProgress;

    @FXML
    private TableColumn<?, ?> volumeProgress;

    @FXML
    private Trainee trainee = ViewTraineesPageController.trainee;

    @FXML
    public void initialize() {
        

    }



}
