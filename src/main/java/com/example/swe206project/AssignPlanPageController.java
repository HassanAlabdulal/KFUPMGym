package com.example.swe206project;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class AssignPlanPageController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Button assignPlan;

    @FXML
    private Button customizePlan;

    @FXML
    private ImageView back;

    @FXML
    private ImageView confirmIcon;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label message;

    @FXML
    private ComboBox<Plan> predefinedPlans;

    @FXML
    private Plan observablePlan = new Plan();

    private Trainee trainee = ViewTraineesPageController.trainee;

    private Plan plan;

    @FXML
    public void initialize() {
        predefinedPlans.setItems(observablePlan.getPlansList());

        predefinedPlans.setCellFactory(new Callback<ListView<Plan>, ListCell<Plan>>() {
            @Override
            public ListCell<Plan> call(ListView<Plan> param) {
                return new ListCell<Plan>() {
                        @Override 
                        protected void updateItem(Plan plan, boolean empty) {
                            super.updateItem(plan, empty);
                            
                            if (plan == null || empty) {
                                setText(null);
                            } else { 
                                setText(plan.getPlanName()); //Set the text to be displayed as the name property of your object.            
                            }                   
                        }  
                };
            }
        });

        predefinedPlans.setConverter(new StringConverter<Plan>() {
            @Override
            public String toString(Plan plan) {
                if (plan == null){
                    return null;
                } else {
                    return plan.getPlanName();
                }
            }

            @Override
            public Plan fromString(String arg0) {
                // TODO Auto-generated method stub
                return new Plan(Integer.valueOf(arg0));
            }
        });
    }

    // Assign plan button design
    @FXML
    public void assignPlanOnClicked(MouseEvent event) throws NullPointerException {
        plan = predefinedPlans.getValue();

        try {
            if(!(plan == null)) {
                if(trainee.plan.id == 0)
                    trainee.setPlan(plan);
                else{
                    trainee.deletePlan();
                    trainee.setPlan(plan);
                }
                confirmIcon.setVisible(true);
                message.setText(plan.getPlanName() + " has been assigned to " + trainee.getName() + ".");
                message.setStyle("-fx-text-fill: #43896B");
                message.setVisible(true);
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
                e.printStackTrace();
                errorIcon.setVisible(true);
                message.setText("Please select a plan to proceed.");
                message.setStyle("-fx-text-fill: #D53A0B");
                message.setVisible(true);
        }
    }

    @FXML
    void assignPlanOnPressed(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        assignPlan.setEffect(new Glow(0.3));
    }

    @FXML
    void assignPlanOnReleased(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        assignPlan.setEffect(new Glow(0.0));
    }

    @FXML
    void assignPlanInHover(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void assignPlanOutHover(MouseEvent event) {
        assignPlan.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    // Customize plan button design
    @FXML
    void customizePlanOnClicked(MouseEvent event) throws IOException {
        AnchorPane customizePlanPage = FXMLLoader.load(getClass().getResource("CustomizePlanPage.fxml"));
        rootPane.getChildren().removeAll();
        rootPane.getChildren().setAll(customizePlanPage);
    }

    @FXML
    void customizePlanOnPressed(MouseEvent event) {
        customizePlan.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        customizePlan.setEffect(new Glow(0.3));
    }

    @FXML
    void customizePlanOnReleased(MouseEvent event) {
        customizePlan.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        customizePlan.setEffect(new Glow(0.0));
    }

    @FXML
    void customizePlanInHover(MouseEvent event) {
        customizePlan.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void customizePlanOutHover(MouseEvent event) {
        customizePlan.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    // Back icon design
    @FXML
    public void backToViewTraineesPage(MouseEvent event) throws IOException {
        AnchorPane viewTraineesPage = FXMLLoader.load(getClass().getResource("ViewTraineesPage.fxml"));
        rootPane.getChildren().removeAll();
        rootPane.getChildren().setAll(viewTraineesPage);
    }

    @FXML
    void backInHover(MouseEvent event) {
        back.setStyle("-fx-cursor: hand");
    }

    @FXML
    void backOnPressed(MouseEvent event) {
        back.setStyle("-fx-cursor: hand");
        back.setEffect(new Glow(0.3));
    }

    @FXML
    void backOnReleased(MouseEvent event) {
        back.setStyle("-fx-cursor: hand");
        back.setEffect(new Glow(0.0));
    }

}
