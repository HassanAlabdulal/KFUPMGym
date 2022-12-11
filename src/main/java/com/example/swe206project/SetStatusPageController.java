package com.example.swe206project;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SetStatusPageController implements Initializable {

    @FXML
    private Button confirm;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label errorMessage;

    @FXML
    private ComboBox<String> status;

    @FXML
    private TextField username;

    @FXML
    private Label usernameLabel;

    @FXML
    public void initialize() {
        status.setItems(FXCollections.observableArrayList("Reactivate user", "Deactivate user"));
    }

    // Username design
    @FXML
    void usernameInHover(MouseEvent event) {
        username.setStyle("-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void usernameOutHover(MouseEvent event) {
        username.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    // Confirm button design
    @FXML
    void confirmOnClicked(MouseEvent event) {
        if (UsernamePassGen.findUser(username.getText())){
            try {
                switch (status.getValue()) {
                    case "Reactivate user":
                        if (!(User.isActive(username.getText()))) {
                            GymManager.setActivationStatus(username.getText(), true);
                            errorIcon.setVisible(false);
                            errorMessage.setText("User has been reactivated.");
                            errorMessage.setStyle("-fx-text-fill: #43896B");
                            errorMessage.setVisible(true);
                        } else {
                            errorIcon.setVisible(true);
                            errorMessage.setText("User is alrady active.");
                            errorMessage.setStyle("-fx-text-fill: #D53A0B");
                            errorMessage.setVisible(true);
                        } break;
                    case "Deactivate user":
                        if (User.isActive(username.getText())) {
                            GymManager.setActivationStatus(username.getText(), false);
                            errorIcon.setVisible(false);
                            errorMessage.setText("User has been deactivated.");
                            errorMessage.setStyle("-fx-text-fill: #43896B");
                            errorMessage.setVisible(true);
                        } else {
                            errorIcon.setVisible(true);
                            errorMessage.setText("User is alrady not active.");
                            errorMessage.setStyle("-fx-text-fill: #D53A0B");
                            errorMessage.setVisible(true);
                        } break;
                }
            } catch (NullPointerException e) {
                errorIcon.setVisible(true);
                errorMessage.setText("Please select an action on the user's profile status.");
                errorMessage.setStyle("-fx-text-fill: #D53A0B");
                errorMessage.setVisible(true);
            }
        } else {
            errorIcon.setVisible(true);
            errorMessage.setText("User not found, try again!");
            errorMessage.setStyle("-fx-text-fill: #D53A0B");
            errorMessage.setVisible(true);
        }
    }

    @FXML
    void confirmOnPressed(MouseEvent event) {
        confirm.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        confirm.setEffect(new Glow(0.3));
    }

    @FXML
    void confirmOnReleased(MouseEvent event) {
        confirm.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        confirm.setEffect(new Glow(0.0));
    }

    @FXML
    void confirmInHover(MouseEvent event) {
        confirm.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void confirmOutHover(MouseEvent event) {
        confirm.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

}
