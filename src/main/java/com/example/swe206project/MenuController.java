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
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuController implements Initializable {

    private User user = LoginFormController.user;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private VBox contentArea;

    // Header variables
    @FXML
    private ImageView closeMenu;

    @FXML
    private ImageView openMenu;

    @FXML
    private ImageView closePage;

    // Slider variables
    @FXML
    private AnchorPane slider;

    @FXML
    private ImageView userPicture;

    @FXML
    private Label userName;

    @FXML
    private Button myProfile;

    @FXML
    private Button myPlan;

    @FXML
    private Button viewTrainees;

    @FXML
    private ImageView logoutIcon;

    @FXML
    private Label logoutLabel;

    private boolean myPlanIsClicked = false;
    private boolean myProfileIsClicked = false;
    private boolean viewTraineesIsClicked = false;

    // Header design
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
    void closePageOnClicked(MouseEvent event) {
        System.exit(0);
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

    // Profile page design
    @FXML
    public void profilePage(ActionEvent Event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);
    }

    @FXML
    void myProfileOnClicked(MouseEvent event) {
        if (!myProfileIsClicked){
            myProfile.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );
            
            myPlan.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );
            viewTrainees.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );

            myProfileIsClicked = true;
            myPlanIsClicked = false;
            viewTraineesIsClicked = false;
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


    // Plan page design
    @FXML
    public void planPage(ActionEvent Event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("PlanPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);    
    }

    @FXML
    void myPlanOnClicked(MouseEvent event) {
        if (!myPlanIsClicked){
            myProfile.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );
            
            myPlan.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );
            viewTrainees.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );

            myProfileIsClicked = false;
            myPlanIsClicked = true;
            viewTraineesIsClicked = false;
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

    // View Trainees page
    @FXML
    public void viewTraineesPage(ActionEvent Event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ViewTraineesPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);    
    }

    @FXML
    void viewTraineesOnClicked(MouseEvent event) {
        if (!myPlanIsClicked){
            myProfile.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );
            
            myPlan.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );
            viewTrainees.setStyle(
                "-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1"
            );

            myProfileIsClicked = false;
            myPlanIsClicked = false;
            viewTraineesIsClicked = true;
        }
    }

    @FXML
    void viewTraineesInHover(MouseEvent event) {
        if (!viewTraineesIsClicked){
            viewTrainees.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void viewTraineesOutHover(MouseEvent event) {
        if (viewTraineesIsClicked){
            viewTrainees.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color:  #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        } else {
            viewTrainees.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color:  #303030; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
        }
    }

    @FXML
    void viewTraineesOnPressed(MouseEvent event) {
        if (!viewTraineesIsClicked){
            viewTrainees.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 4px 0px; -fx-background-color: #3A4141; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            viewTrainees.setEffect(new Glow(0.3));
        }
    }

    @FXML
    void viewTraineesOnReleased(MouseEvent event) {
        if (!viewTraineesIsClicked){
            viewTrainees.setStyle("-fx-cursor: hand; -fx-border-color: #43896B; -fx-border-width: 0px 0px 2px 0px; -fx-background-color: #212121; -fx-background-radius: 0px 0px 0px 0px; -fx-text-fill: #F4F9F1");
            viewTrainees.setEffect(new Glow(0.0));
        }
    }


    // Logout design
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
        //myProfile.fire();

        userName.setText(user.getName());

        if (user instanceof Trainer) {
            viewTrainees.setVisible(true);
            viewTrainees.setDisable(false);
            myPlan.setVisible(false);
            myPlan.setDisable(true);
        }

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
            Parent fxml = FXMLLoader.load(getClass().getResource("ProfilePage.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml);
        } 
        catch(IOException ex){
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE,null,ex);
        } 
    }

}