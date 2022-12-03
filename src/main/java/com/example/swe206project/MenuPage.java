package com.example.swe206project;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class MenuPage implements Initializable {

    @FXML
    private ImageView closeMenu;

    @FXML
    private ImageView closePage;

    @FXML
    private ImageView openMenu;

    @FXML
    private AnchorPane slider;

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