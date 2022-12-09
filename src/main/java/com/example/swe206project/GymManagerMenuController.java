package com.example.swe206project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class GymManagerMenuController implements Initializable {

    @FXML
    private GymManager manager = LoginFormController.manager;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ImageView closeMenu;

    @FXML
    private ImageView closePage;

    @FXML
    private Button setStatus;

    @FXML
    private ImageView openMenu;

    @FXML
    private AnchorPane slider;

    @FXML
    private Button createProfile;

    @FXML
    private Label userName;

    @FXML
    private ImageView userPicture;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private Label logoutLabel;

    @FXML
    private VBox contentArea;

    private boolean createProfileIsClicked = false;
    private boolean setStatusIsClicked = false;
  

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
    void createProfileOnClicked(MouseEvent event) {
        if (!createProfileIsClicked){
            createProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            setStatus.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            createProfileIsClicked = true;
            setStatusIsClicked = false;
            
        }
    }

    @FXML
    void createProfileInHover(MouseEvent event) {
        if (!createProfileIsClicked){
            createProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void createProfileOutHover(MouseEvent event) {
        if (createProfileIsClicked){
            createProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        } else {
            createProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void createProfileOnPressed(MouseEvent event) {
        if (!createProfileIsClicked){
            createProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            createProfile.setEffect(new Glow(0.3));
        }
    }

    @FXML
    void createProfileOnReleased(MouseEvent event) {
        if (!createProfileIsClicked){
            createProfile.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            createProfile.setEffect(new Glow(0.0));
        }
    }

    @FXML
    void setStatusOnClicked(MouseEvent event) {
        if (!setStatusIsClicked){
            createProfile.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            setStatus.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            createProfileIsClicked = false;
            setStatusIsClicked = true;
            
        }
    }

    @FXML
    void setStatusInHover(MouseEvent event) {
        if (!setStatusIsClicked){
            setStatus.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void setStatusOutHover(MouseEvent event) {
        if (setStatusIsClicked){
            setStatus.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        } else {
            setStatus.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void setStatusOnPressed(MouseEvent event) {
        if (!setStatusIsClicked){
            setStatus.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            setStatus.setEffect(new Glow(0.3));
        }
    }

    @FXML
    void setStatusOnReleased(MouseEvent event) {
        if (!setStatusIsClicked){
            setStatus.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            setStatus.setEffect(new Glow(0.0));
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


        try{
            Parent fxml = FXMLLoader.load(getClass().getResource("CreateProfile.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } 
        catch(IOException ex){
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE,null,ex);
        } 
    }

    @FXML
    public void createProfile(ActionEvent Event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("CreateProfile.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);    
    }

    @FXML
    public void setStatus(ActionEvent Event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("SetStatus.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);    
    }


}