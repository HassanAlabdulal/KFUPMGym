package com.example.swe206project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuPage implements Initializable {

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
    void todaysSessionInHover(MouseEvent event) {
        todaysSession.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void todaysSessionOutHover(MouseEvent event) {
        todaysSession.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void myProfileInHover(MouseEvent event) {
        myProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void myProfileOutHover(MouseEvent event) {
        myProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void myPlanInHover(MouseEvent event) {
        myPlan.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void myPlanOutHover(MouseEvent event) {
        myPlan.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void closePageInHover(MouseEvent event) {
        closePage.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void openMenuInHover(MouseEvent event) {
         openMenu.setStyle("-fx-cursor: hand;");
    }

    @FXML
    void closeMenuInHover(MouseEvent event) {
        closeMenu.setStyle("-fx-cursor: hand;");
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