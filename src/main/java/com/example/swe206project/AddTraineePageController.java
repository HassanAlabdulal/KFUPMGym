package com.example.swe206project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AddTraineePageController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button addTrainee;

    @FXML
    private ImageView back;

    @FXML
    private Label message;

    @FXML
    private ImageView confirmIcon;

    @FXML
    private ImageView errorIcon;

    @FXML
    private TableView<Trainee> traineesTable;

    @FXML
    private TableColumn<Trainee, String> name;

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

    private Trainee trainee = new Trainee();

    @FXML
    public void initialize() {
        name.setCellValueFactory(new PropertyValueFactory<Trainee, String>("name"));
        height.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("height"));
        weight.setCellValueFactory(new PropertyValueFactory<Trainee, Double>("weight"));
        plan.setCellValueFactory(new PropertyValueFactory<Trainee, Plan>("plan"));
        status.setCellValueFactory(new PropertyValueFactory<Trainee, String>("status"));
        
        traineesTable.setItems(trainee.getTraineesNoTrainerList());
    }

    // Add trainee button design
    @FXML
    public void addTraineeOnClicked(MouseEvent event) throws NullPointerException {
        trainee = traineesTable.getSelectionModel().getSelectedItem();

        try {
            if(!(trainee == null)) {
                trainer.addTrainee(trainee);
                confirmIcon.setVisible(true);
                message.setText(trainee.getName() + " has been added.");
                message.setStyle("-fx-text-fill: #43896B");
                message.setVisible(true);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
                errorIcon.setVisible(true);
                message.setText("Please select a trainee from the table to proceed.");
                message.setStyle("-fx-text-fill: #D53A0B");
                message.setVisible(true);
        }
    }

    @FXML
    void addTraineeOnPressed(MouseEvent event) {
        addTrainee.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        addTrainee.setEffect(new Glow(0.3));
    }

    @FXML
    void addTraineeOnReleased(MouseEvent event) {
        addTrainee.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        addTrainee.setEffect(new Glow(0.0));
    }

    @FXML
    void addTraineeInHover(MouseEvent event) {
        addTrainee.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void addTraineeOutHover(MouseEvent event) {
        addTrainee.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
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
