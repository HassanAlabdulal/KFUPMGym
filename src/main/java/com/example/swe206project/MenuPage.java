package com.example.swe206project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuPage implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView closeMenu;

    @FXML
    private ImageView closePage;

    @FXML
    private Button myPlan;

    @FXML
    private Button myProfile;

    @FXML
    private ImageView openMenu;

    @FXML
    private AnchorPane slider;

    @FXML
    private Button todaysSession;

    @FXML
    private Label userName;

    @FXML
    private ImageView userPicture;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private Label logoutLabel;

    private boolean todaysSessionIsClicked = false;
    private boolean myPlanIsClicked = false;
    private boolean myProfileIsClicked = false;

    @FXML
    void openMenuInHover(MouseEvent event) {
        openMenu.setStyle("-fx-cursor: hand");
    }

    @FXML
    void openMenuOnPressed(MouseEvent event) {
        openMenu.setStyle("-fx-cursor: hand");
        openMenu.setEffect(new Glow(0.3));
    }

    @FXML
    void openMenuOnReleased(MouseEvent event) {
        openMenu.setStyle("-fx-cursor: hand");
        openMenu.setEffect(new Glow(0.0));
    }

    @FXML
    void closeMenuInHover(MouseEvent event) {
        closeMenu.setStyle("-fx-cursor: hand");
    }

    @FXML
    void closeMenuOnPressed(MouseEvent event) {
        closeMenu.setStyle("-fx-cursor: hand");
        closeMenu.setEffect(new Glow(0.3));
    }

    @FXML
    void closeMenuOnReleased(MouseEvent event) {
        closeMenu.setStyle("-fx-cursor: hand");
        closeMenu.setEffect(new Glow(0.0));
    }

    @FXML
    void closePageInHover(MouseEvent event) {
        closePage.setStyle("-fx-cursor: hand");
    }

    @FXML
    void closePageOnPressed(MouseEvent event) {
        closePage.setStyle("-fx-cursor: hand");
        closePage.setEffect(new Glow(0.3));
    }

    @FXML
    void closePageOnReleased(MouseEvent event) {
        closePage.setStyle("-fx-cursor: hand");
        closePage.setEffect(new Glow(0.0));
    }

    @FXML
    void todaysSessionOnClicked(MouseEvent event) {
        if (!todaysSessionIsClicked){
            todaysSession.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myPlan.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            todaysSessionIsClicked = true;
            myPlanIsClicked = false;
            myProfileIsClicked = false;
        }
    }

    @FXML
    void todaysSessionInHover(MouseEvent event) {
        if (!todaysSessionIsClicked){
            todaysSession.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void todaysSessionOutHover(MouseEvent event) {
        if (todaysSessionIsClicked){
            todaysSession.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        } else {
            todaysSession.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void todaysSessionOnPressed(MouseEvent event) {
        if (!todaysSessionIsClicked){
            todaysSession.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            todaysSession.setEffect(new Glow(0.3));
        }
    }

    @FXML
    void todaysSessionOnReleased(MouseEvent event) {
        if (!todaysSessionIsClicked){
            todaysSession.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            todaysSession.setEffect(new Glow(0.0));
        }
    }

    @FXML
    void myPlanOnClicked(MouseEvent event) {
        if (!myPlanIsClicked){
            todaysSession.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myPlan.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            todaysSessionIsClicked = false;
            myPlanIsClicked = true;
            myProfileIsClicked = false;
        }
    }

    @FXML
    void myPlanInHover(MouseEvent event) {
        if (!myPlanIsClicked){
            myPlan.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void myPlanOutHover(MouseEvent event) {
        if (myPlanIsClicked){
            myPlan.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        } else {
            myPlan.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void myPlanOnPressed(MouseEvent event) {
        if (!myPlanIsClicked){
            myPlan.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myPlan.setEffect(new Glow(0.3));
        }
    }

    @FXML
    void myPlanOnReleased(MouseEvent event) {
        if (!myPlanIsClicked){
            myPlan.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myPlan.setEffect(new Glow(0.0));
        }
    }

    @FXML
    void myProfileOnClicked(MouseEvent event) {
        if (!myProfileIsClicked){
            todaysSession.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myPlan.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            todaysSessionIsClicked = false;
            myPlanIsClicked = false;
            myProfileIsClicked = true;
        }
    }

    @FXML
    void myProfileInHover(MouseEvent event) {
        if (!myProfileIsClicked){
            myProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void myProfileOutHover(MouseEvent event) {
        if (myProfileIsClicked){
            myProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        } else {
            myProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void myProfileOnPressed(MouseEvent event) {
        if (!myProfileIsClicked){
            myProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myProfile.setEffect(new Glow(0.3));
        }
    }

    @FXML
    void myProfileOnReleased(MouseEvent event) {
        if (!myProfileIsClicked){
            myProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            myProfile.setEffect(new Glow(0.0));
        }
    }

    @FXML
    void logoutOnClicked(MouseEvent event) {
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

    @FXML
    void logoutInHover(MouseEvent event) {
        logoutLabel.setStyle("-fx-cursor: hand");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        closePage.setOnMouseClicked(event -> {
            System.exit(0);
        });
        slider.setTranslateX(-225);
        openMenu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(0);
            slide.play();

            slider.setTranslateX(-225);

            slide.setOnFinished((ActionEvent e)-> {
                openMenu.setVisible(false);
                closeMenu.setVisible(true);
            });
        });

        closeMenu.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.4));
            slide.setNode(slider);

            slide.setToX(-225);
            slide.play();

            slider.setTranslateX(0);

            slide.setOnFinished((ActionEvent e)-> {
                openMenu.setVisible(true);
                closeMenu.setVisible(false);
            });
        });
    }
}