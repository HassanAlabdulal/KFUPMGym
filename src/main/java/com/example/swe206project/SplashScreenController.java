package com.example.swe206project;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashScreenController implements Initializable {

    @FXML
    private ImageView icon;

    @FXML
    private Label loading;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label title;

    public SplashScreenController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new SplashScreen().start();
    }

    class SplashScreen extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        FXMLLoader fxmlLoader;
                        try {
                            fxmlLoader = new FXMLLoader(KFUPMGym.class.getResource("LoginForm.fxml"));
                            Scene loginFormScene = new Scene(fxmlLoader.load());
                            Stage stage = new Stage();
                            stage.setScene(loginFormScene);
                            stage.setTitle("KFUPM Gym");
                            stage.show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        rootPane.getScene().getWindow().hide();
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
