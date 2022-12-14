package com.example.swe206project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    Trainer trainer = (Trainer) LoginFormController.user;

    @FXML
   ObservableList<Trainee> list = FXCollections.observableArrayList();


   //ObservableList<Trainee> list = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        //Trainer trainer = (Trainer) LoginFormController.user;
        //ObservableList<Trainee> list = FXCollections.observableArrayList(trainer.getTraineesList());
        
        name.setCellValueFactory(new PropertyValueFactory<Trainee, String>("name"));
        height.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("weight"));
        plan.setCellValueFactory(new PropertyValueFactory<Trainee, Plan>("plan"));
        status.setCellValueFactory(new PropertyValueFactory<Trainee, String>("status"));
       
        //viewTraineesTable.setItems(FXCollections.observableArrayList(trainer.getTraineesListTest()));
        viewTraineesTable.setItems(trainer.getObservableTraineesList());
    }

}
