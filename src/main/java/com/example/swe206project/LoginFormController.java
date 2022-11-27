package com.example.swe206project;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LoginFormController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}