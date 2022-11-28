package com.example.swe206project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KFUPMGym extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(KFUPMGym.class.getResource("SplashScreen.fxml"));
        Scene splashScreenScene = new Scene(fxmlLoader.load());
        stage.setScene(splashScreenScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
