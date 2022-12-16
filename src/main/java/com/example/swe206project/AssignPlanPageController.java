package com.example.swe206project;

//import javax.security.auth.callback.Callback;

//import javafx.collections.FXCollections;
//import javafx.css.converter.StringConverter;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import javafx.util.StringConverter;
//import java.util.List;

public class AssignPlanPageController implements Initializable {

    @FXML
    private Button assignPlan;

    @FXML
    private ImageView back;

    @FXML
    private ImageView confirmIcon;

    @FXML
    private Button customizePlan;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label message;

    @FXML
    private ComboBox<Plan> predefinedPlans;

    @FXML
    private Plan plan = new Plan();

    @FXML
    public void initialize() {
        predefinedPlans.setItems(plan.getPlansList());
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
}
