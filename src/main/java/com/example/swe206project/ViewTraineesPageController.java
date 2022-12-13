package com.example.swe206project;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;

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
    private TableColumn<Trainee, String> name;

    @FXML
    private TableColumn<User, Double> height;

    @FXML
    private TableColumn<User, Double> weight;

    @FXML
    private TableColumn<Plan, String> plan;

    @FXML
    private TableColumn<User, String> status;

    @FXML
    public void initialize() {
        Trainer trainer = (Trainer) LoginFormController.user;

        name.setCellValueFactory(new PropertyValueFactory<Trainee, String>("name"));
        //height.setCellValueFactory(new PropertyValueFactory<User, Double>("height"));
        //weight.setCellValueFactory(new PropertyValueFactory<User, Double>("weight"));
        //plan.setCellValueFactory(new PropertyValueFactory<Plan, String>("planName"));
        //status.setCellValueFactory(new PropertyValueFactory<User, String>("status"));

        viewTraineesTable.setItems(FXCollections.observableArrayList(trainer.getTraineeList(trainer.userName)));
    }

}
