package com.example.swe206project;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;

public class KFUPMGym extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
            Scene  splashScreenScene  = new Scene(root);

            SimpleDateFormat f = new SimpleDateFormat("EEEE");        
            String currentDay = f.format(new Date());
            if(currentDay.equals("Friday"))
                Workouts.resetProgress();

            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(splashScreenScene);
            stage.show();
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
