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
    private Plan plan ;


    
    // @FXML
    // public void initialize() {
    //     planTitle.setText(plan.getPlanName());
    // }



  @FXML
  void sundayCardInHover(MouseEvent event) {
      sundayDetailsIcon.setVisible(true);
      sundayDetailsIcon.setOpacity(0.80);
      sundayCardHeader.setOpacity(0.30);
      sundayCard.setOpacity(0.30);
  
    }

    @FXML
    void sundayCardOutHover(MouseEvent event) {
        sundayDetailsIcon.setVisible(false);
        sundayCardHeader.setOpacity(1);
        sundayCard.setOpacity(1);
        sundayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");


    }

    @FXML
    void sundayDetailsIconInHover(MouseEvent event) {
        sundayDetailsIcon.setStyle("-fx-cursor: hand");
        sundayDetailsIcon.setOpacity(1);
        sundayCard.setStyle("-fx-cursor: hand");
        sundayCard.setOpacity(0.50);
        sundayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        sundayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void sundayDetailsIconOutHover(MouseEvent event) {
        sundayDetailsIcon.setStyle("-fx-cursor: default");
        sundayDetailsIcon.setOpacity(0.80);
        sundayCard.setStyle("-fx-cursor: default");
        sundayCard.setOpacity(0.30);
        sundayCardHeader.setOpacity(0.30);
        sundayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        sundayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");

    }



    @FXML
    void mondayCardInHover(MouseEvent event) {
        mondayDetailsIcon.setVisible(true);
        mondayDetailsIcon.setOpacity(0.80);
        mondayCardHeader.setOpacity(0.30);
        mondayCard.setOpacity(0.30);
  
    }

    @FXML
    void mondayCardOutHover(MouseEvent event) {
        mondayDetailsIcon.setVisible(false);
        mondayCardHeader.setOpacity(1);
        mondayCard.setOpacity(1);
        mondayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");


    }

    @FXML
    void mondayDetailsIconInHover(MouseEvent event) {
        mondayDetailsIcon.setStyle("-fx-cursor: hand");
        mondayDetailsIcon.setOpacity(1);
        mondayCard.setStyle("-fx-cursor: hand");
        mondayCard.setOpacity(0.50);
        mondayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        mondayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void mondayDetailsIconOutHover(MouseEvent event) {
        mondayDetailsIcon.setStyle("-fx-cursor: default");
        mondayDetailsIcon.setOpacity(0.80);
        mondayCard.setStyle("-fx-cursor: default");
        mondayCard.setOpacity(0.30);
        mondayCardHeader.setOpacity(0.30);
        mondayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        mondayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");

    }


    @FXML
    void tuesdayCardInHover(MouseEvent event) {
        tuesdayDetailsIcon.setVisible(true);
        tuesdayDetailsIcon.setOpacity(0.80);
        tuesdayCardHeader.setOpacity(0.30);
        tuesdayCard.setOpacity(0.30);
  
    }

    @FXML
    void tuesdayCardOutHover(MouseEvent event) {
        tuesdayDetailsIcon.setVisible(false);
        tuesdayCardHeader.setOpacity(1);
        tuesdayCard.setOpacity(1);
        tuesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
    }

    @FXML
    void tuesdayDetailsIconInHover(MouseEvent event) {
        tuesdayDetailsIcon.setStyle("-fx-cursor: hand");
        tuesdayDetailsIcon.setOpacity(1);
        tuesdayCard.setStyle("-fx-cursor: hand");
        tuesdayCard.setOpacity(0.50);
        tuesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        tuesdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void tuesdayDetailsIconOutHover(MouseEvent event) {
        tuesdayDetailsIcon.setStyle("-fx-cursor: default");
        tuesdayDetailsIcon.setOpacity(0.80);
        tuesdayCard.setStyle("-fx-cursor: default");
        tuesdayCard.setOpacity(0.30);
        tuesdayCardHeader.setOpacity(0.30);
        tuesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        tuesdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");

    }

    @FXML
    void wednesdayCardInHover(MouseEvent event) {
        wednesdayDetailsIcon.setVisible(true);
        wednesdayDetailsIcon.setOpacity(0.80);
        wednesdayCardHeader.setOpacity(0.30);
        wednesdayCard.setOpacity(0.30);
  
    }

    @FXML
    void wednesdayCardOutHover(MouseEvent event) {
        wednesdayDetailsIcon.setVisible(false);
        wednesdayCardHeader.setOpacity(1);
        wednesdayCard.setOpacity(1);
        wednesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");


    }

    @FXML
    void wednesdayDetailsIconInHover(MouseEvent event) {
        
        wednesdayDetailsIcon.setStyle("-fx-cursor: hand");
        wednesdayDetailsIcon.setOpacity(1);
        wednesdayCard.setStyle("-fx-cursor: hand");
        wednesdayCard.setOpacity(0.50);
        wednesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        wednesdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void wednesdayDetailsIconOutHover(MouseEvent event) {
        
        wednesdayDetailsIcon.setStyle("-fx-cursor: default");
        wednesdayDetailsIcon.setOpacity(0.80);
        wednesdayCard.setStyle("-fx-cursor: default");
        wednesdayCard.setOpacity(0.30);
        wednesdayCardHeader.setOpacity(0.30);
        wednesdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        wednesdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");

    }


    @FXML
    void thursdayCardInHover(MouseEvent event) {
        thursdayDetailsIcon.setVisible(true);
        thursdayDetailsIcon.setOpacity(0.80);
        thursdayCardHeader.setOpacity(0.30);
        thursdayCard.setOpacity(0.30);
  
    }

    @FXML
    void thursdayCardOutHover(MouseEvent event) {
        thursdayDetailsIcon.setVisible(false);
        thursdayCardHeader.setOpacity(1);
        thursdayCard.setOpacity(1);
        thursdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");


    }

    @FXML
    void thursdayDetailsIconInHover(MouseEvent event) {
        
        thursdayDetailsIcon.setStyle("-fx-cursor: hand");
        thursdayDetailsIcon.setOpacity(1);
        thursdayCard.setStyle("-fx-cursor: hand");
        thursdayCard.setOpacity(0.50);
        thursdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        thursdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void thursdayDetailsIconOutHover(MouseEvent event) {
        
        thursdayDetailsIcon.setStyle("-fx-cursor: default");
        thursdayDetailsIcon.setOpacity(0.80);
        thursdayCard.setStyle("-fx-cursor: default");
        thursdayCard.setOpacity(0.30);
        thursdayCardHeader.setOpacity(0.30);
        thursdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        thursdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");

    }


    @FXML
    void saturdayCardInHover(MouseEvent event) {
        saturdayDetailsIcon.setVisible(true);
        saturdayDetailsIcon.setOpacity(0.80);
        saturdayCardHeader.setOpacity(0.30);
        saturdayCard.setOpacity(0.30);
  
    }

    @FXML
    void saturdayCardOutHover(MouseEvent event) {
        saturdayDetailsIcon.setVisible(false);
        saturdayCardHeader.setOpacity(1);
        saturdayCard.setOpacity(1);
        saturdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");


    }

    @FXML
    void saturdayDetailsIconInHover(MouseEvent event) {
        
        saturdayDetailsIcon.setStyle("-fx-cursor: hand");
        saturdayDetailsIcon.setOpacity(1);
        saturdayCard.setStyle("-fx-cursor: hand");
        saturdayCard.setOpacity(0.50);
        saturdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        saturdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");
        }
    

    @FXML
    void saturdayDetailsIconOutHover(MouseEvent event) {
        
        saturdayDetailsIcon.setStyle("-fx-cursor: default");
        saturdayDetailsIcon.setOpacity(0.80);
        saturdayCard.setStyle("-fx-cursor: default");
        saturdayCard.setOpacity(0.30);
        saturdayCardHeader.setOpacity(0.30);
        saturdayCard.setStyle("-fx-background-color: #f4f9f1; -fx-background-radius: 10px");
        saturdayCardHeader.setStyle("-fx-background-color: #43896b; -fx-background-radius:  10px 10px 0px 0px");

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
    void switchToSessionPage(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("SessionsPage.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(fxml);  
    }

    


  }



