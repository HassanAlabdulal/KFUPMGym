package com.example.swe206project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class PlanPageController implements Initializable {

    @FXML
    private AnchorPane mondayCard;

    @FXML
    private Button progressButton;

    @FXML
    private Label errorMessage;

    @FXML
    private ImageView failIcon;

    @FXML
    private AnchorPane contentArea;

    @FXML
    private HBox mondayCardHeader;

    @FXML
    private ImageView mondayDetailsIcon;

    @FXML
    private AnchorPane saturdayCard;

    @FXML
    private HBox saturdayCardHeader;

    @FXML
    private ImageView saturdayDetailsIcon;

    @FXML
    private AnchorPane sundayCard;

    @FXML
    private HBox sundayCardHeader;

    @FXML
    private ImageView sundayDetailsIcon;

    @FXML
    private AnchorPane thursdayCard;

    @FXML
    private HBox thursdayCardHeader;

    @FXML
    private ImageView thursdayDetailsIcon;

    @FXML
    private AnchorPane tuesdayCard;

    @FXML
    private HBox tuesdayCardHeader;

    @FXML
    private ImageView tuesdayDetailsIcon;

    @FXML
    private AnchorPane wednesdayCard;

    @FXML
    private HBox wednesdayCardHeader;

    @FXML
    private ImageView wednesdayDetailsIcon;

    @FXML
    private Label planTitle;

    @FXML
    public static String day = "";
    
    
    private Trainee trainee = (Trainee) LoginFormController.user;

    
    private Plan plan = trainee.getPlan();

    
    @FXML
    public void initialize() throws NullPointerException {
        try {
            if(plan != null){
                planTitle.setText(plan.getPlanName());
            }else{
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            planTitle.setText("You do not have a plan");

        }
    }



  @FXML
  void sundayCardInHover(MouseEvent event) {
      sundayCardHeader.setEffect(new Glow(0.0));
      sundayCard.setEffect(new Glow(0.0));
      sundayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
    }

    @FXML
    void sundayCardOutHover(MouseEvent event) {
        sundayCardHeader.setEffect(new Glow(0.0));
        sundayCard.setEffect(new Glow(0.0));
        sundayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        sundayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
    }

    @FXML
    void sundayDetailsIconInHover(MouseEvent event) {
        sundayDetailsIcon.setStyle("-fx-cursor: hand");
        sundayCardHeader.setEffect(new Glow(0.1));
        sundayCard.setEffect(new Glow(0.1));
        sundayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        sundayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void sundayDetailsIconOutHover(MouseEvent event) {
        sundayDetailsIcon.setStyle("-fx-cursor: default");
        sundayCardHeader.setEffect(new Glow(0.0));
        sundayCard.setEffect(new Glow(0.0));
        sundayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        sundayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");

    }

    @FXML
    void sundayDetailsIconOnPressed(MouseEvent event) {
        sundayCardHeader.setEffect(new Glow(0.3));
        sundayCard.setEffect(new Glow(0.3));
    }

    @FXML
    void sundayDetailsIconOnReleased(MouseEvent event) {
        sundayCardHeader.setEffect(new Glow(0.0));
        sundayCard.setEffect(new Glow(0.0));
    }



    @FXML
    void mondayCardInHover(MouseEvent event) {
        mondayCardHeader.setEffect(new Glow(0.0));
        mondayCard.setEffect(new Glow(0.0));
        mondayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
  
    }

    @FXML
    void mondayCardOutHover(MouseEvent event) {
        mondayCardHeader.setEffect(new Glow(0.0));
        mondayCard.setEffect(new Glow(0.0));
        mondayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        mondayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");


    }

    @FXML
    void mondayDetailsIconInHover(MouseEvent event) {
        mondayDetailsIcon.setStyle("-fx-cursor: hand");
        mondayCardHeader.setEffect(new Glow(0.1));
        mondayCard.setEffect(new Glow(0.1));
        mondayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        mondayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void mondayDetailsIconOutHover(MouseEvent event) {
        mondayDetailsIcon.setStyle("-fx-cursor: default");
        mondayCardHeader.setEffect(new Glow(0.0));
        mondayCard.setEffect(new Glow(0.0));
        mondayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        mondayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");

    }

    @FXML
    void mondayDetailsIconOnPressed(MouseEvent event) {
        mondayCardHeader.setEffect(new Glow(0.3));
        mondayCard.setEffect(new Glow(0.3));
    }

    @FXML
    void mondayDetailsIconOnReleased(MouseEvent event) {
        mondayCardHeader.setEffect(new Glow(0.0));
        mondayCard.setEffect(new Glow(0.0));
    }


    @FXML
    void tuesdayCardInHover(MouseEvent event) {
        tuesdayCardHeader.setEffect(new Glow(0.0));
        tuesdayCard.setEffect(new Glow(0.0));
        tuesdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
  
    }

    @FXML
    void tuesdayCardOutHover(MouseEvent event) {
        tuesdayCardHeader.setEffect(new Glow(0.0));
        tuesdayCard.setEffect(new Glow(0.0));
        tuesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        tuesdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
    }

    @FXML
    void tuesdayDetailsIconInHover(MouseEvent event) {
        tuesdayDetailsIcon.setStyle("-fx-cursor: hand");
        tuesdayCardHeader.setEffect(new Glow(0.1));
        tuesdayCard.setEffect(new Glow(0.1));
        tuesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        tuesdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void tuesdayDetailsIconOutHover(MouseEvent event) {
        tuesdayDetailsIcon.setStyle("-fx-cursor: default");
        tuesdayCardHeader.setEffect(new Glow(0.0));
        tuesdayCard.setEffect(new Glow(0.0));
        tuesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        tuesdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");

    }

    @FXML
    void tuesdayDetailsIconOnPressed(MouseEvent event) {
        tuesdayCardHeader.setEffect(new Glow(0.3));
        tuesdayCard.setEffect(new Glow(0.3));
    }

    @FXML
    void tuesdayDetailsIconOnReleased(MouseEvent event) {
        tuesdayCardHeader.setEffect(new Glow(0.0));
        tuesdayCard.setEffect(new Glow(0.0));
    }

    @FXML
    void wednesdayCardInHover(MouseEvent event) {
        wednesdayCardHeader.setEffect(new Glow(0.0));
        wednesdayCard.setEffect(new Glow(0.0));
        wednesdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
  
    }

    @FXML
    void wednesdayCardOutHover(MouseEvent event) {
        wednesdayCardHeader.setEffect(new Glow(0.0));
        wednesdayCard.setEffect(new Glow(0.0));
        wednesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        wednesdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");


    }

    @FXML
    void wednesdayDetailsIconInHover(MouseEvent event) {
        wednesdayDetailsIcon.setStyle("-fx-cursor: hand");
        wednesdayCardHeader.setEffect(new Glow(0.1));
        wednesdayCard.setEffect(new Glow(0.1));
        wednesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        wednesdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void wednesdayDetailsIconOutHover(MouseEvent event) {
        wednesdayDetailsIcon.setStyle("-fx-cursor: default");
        wednesdayCardHeader.setEffect(new Glow(0.0));
        wednesdayCard.setEffect(new Glow(0.0));
        wednesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        wednesdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");

    }

    @FXML
    void wednesdayDetailsIconOnPressed(MouseEvent event) {
        wednesdayCardHeader.setEffect(new Glow(0.3));
        wednesdayCard.setEffect(new Glow(0.3));
    }

    @FXML
    void wednesdayDetailsIconOnReleased(MouseEvent event) {
        wednesdayCardHeader.setEffect(new Glow(0.0));
        wednesdayCard.setEffect(new Glow(0.0));
    }


    @FXML
    void thursdayCardInHover(MouseEvent event) {
        thursdayCardHeader.setEffect(new Glow(0.0));
        thursdayCard.setEffect(new Glow(0.0));
        thursdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
  
    }

    @FXML
    void thursdayCardOutHover(MouseEvent event) {
        thursdayCardHeader.setEffect(new Glow(0.0));
        thursdayCard.setEffect(new Glow(0.0));
        thursdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        thursdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");


    }

    @FXML
    void thursdayDetailsIconInHover(MouseEvent event) {
        thursdayDetailsIcon.setStyle("-fx-cursor: hand");
        thursdayCardHeader.setEffect(new Glow(0.1));
        thursdayCard.setEffect(new Glow(0.1));
        thursdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        thursdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void thursdayDetailsIconOutHover(MouseEvent event) {
        thursdayDetailsIcon.setStyle("-fx-cursor: default");
        thursdayCardHeader.setEffect(new Glow(0.0));
        thursdayCard.setEffect(new Glow(0.0));
        thursdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        thursdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");

    }

    @FXML
    void thursdayDetailsIconOnPressed(MouseEvent event) {
        thursdayCardHeader.setEffect(new Glow(0.3));
        thursdayCard.setEffect(new Glow(0.3));
    }

    @FXML
    void thursdayDetailsIconOnReleased(MouseEvent event) {
        thursdayCardHeader.setEffect(new Glow(0.0));
        thursdayCard.setEffect(new Glow(0.0));
    }


    @FXML
    void saturdayCardInHover(MouseEvent event) {
        saturdayCardHeader.setEffect(new Glow(0.0));
        saturdayCard.setEffect(new Glow(0.0));
        saturdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
  
    }

    @FXML
    void saturdayCardOutHover(MouseEvent event) {
        saturdayCardHeader.setEffect(new Glow(0.0));
        saturdayCard.setEffect(new Glow(0.0));
        saturdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        saturdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");


    }

    @FXML
    void saturdayDetailsIconInHover(MouseEvent event) {
        
        saturdayDetailsIcon.setStyle("-fx-cursor: hand");
        saturdayCardHeader.setEffect(new Glow(0.1));
        saturdayCard.setEffect(new Glow(0.1));
        saturdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        saturdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void saturdayDetailsIconOutHover(MouseEvent event) {
        
        saturdayDetailsIcon.setStyle("-fx-cursor: default");
        saturdayCardHeader.setEffect(new Glow(0.0));
        saturdayCard.setEffect(new Glow(0.0));
        saturdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        saturdayCardHeader.setStyle("-fx-background-color: #366d55; -fx-background-radius:  10px 10px 0px 0px");

    }

    @FXML
    void saturdayDetailsIconOnPressed(MouseEvent event) {
        saturdayCardHeader.setEffect(new Glow(0.3));
        saturdayCard.setEffect(new Glow(0.3));
    }

    @FXML
    void saturdayDetailsIconOnReleased(MouseEvent event) {
        saturdayCardHeader.setEffect(new Glow(0.0));
        saturdayCard.setEffect(new Glow(0.0));
    }

    @FXML
    void progressButtonInHover(MouseEvent event) {
        progressButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void progressButtonOutHover(MouseEvent event) {
        progressButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    @FXML
    void progressButtonOnClicked(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ProgressPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);  
    }

    @FXML
    void progressButtonOnPressed(MouseEvent event) {
        progressButton.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        progressButton.setEffect(new Glow(0.3));
    }

    @FXML
    void progressButtonOnReleased(MouseEvent event) {
        progressButton.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        progressButton.setEffect(new Glow(0.0));
    }
    



    @FXML
    void sundayDetailsIconOnClicked(MouseEvent event) throws IOException {
        day = "Sunday";
        try {        
        Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml); 
        } catch (Exception e) {
            errorMessage.setVisible(true);
            failIcon.setVisible(true);
        }
         
    }

    @FXML
    void mondayDetailsIconOnClicked(MouseEvent event) throws IOException {
        day = "Monday";
        try {        
            Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml); 
            } catch (Exception e) {
                errorMessage.setVisible(true);
                failIcon.setVisible(true);
            } 
    }

    @FXML
    void tuesdayDetailsIconOnClicked(MouseEvent event) throws IOException {
        day = "Tuesday";
        try {        
            Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml); 
            } catch (Exception e) {
                errorMessage.setVisible(true);
                failIcon.setVisible(true);
            } 
    }

    @FXML
    void wednesdayDetailsIconOnClicked(MouseEvent event) throws IOException {
        day = "Wednesday";
        try {        
            Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml); 
            } catch (Exception e) {
                errorMessage.setVisible(true);
                failIcon.setVisible(true);
            } 
    }

    
    @FXML
    void thursdayDetailsIconOnClicked(MouseEvent event) throws IOException {
        day = "Thursday";
        try {        
            Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml); 
            } catch (Exception e) {
                errorMessage.setVisible(true);
                failIcon.setVisible(true);
            } 
    }

    @FXML
    void saturdayDetailsIconOnClicked(MouseEvent event) throws IOException {
        day = "Saturday";
        try {        
            Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(fxml); 
            } catch (Exception e) {
                errorMessage.setVisible(true);
                failIcon.setVisible(true);
            }  
    }

    


  }



