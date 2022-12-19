package com.example.swe206project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.Glow;
import javafx.util.Callback;
import javafx.util.StringConverter;

public class CustomizePlanPageController implements Initializable {

    @FXML
    private Button addSession;

    @FXML
    private Button addWorkout;

    @FXML
    private Button assignPlan;

    @FXML
    private ImageView back;

    @FXML
    private ImageView confirmIcon;

    @FXML
    private ImageView errorIcon;

    @FXML
    private Label message;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ComboBox<String> sessionDays;

    @FXML
    private ComboBox<Workouts> workouts;

    @FXML
    private TextField planName;

    @FXML
    private Workouts workout = new Workouts();

    private Trainee trainee = ViewTraineesPageController.trainee;

    private Plan plan;

    private boolean[] reservedDays = new boolean[6];

    private ArrayList<Session> sessionsList = new ArrayList<>();

    private ArrayList<Workouts> saturdayWorkouts = new ArrayList<>();

    private ArrayList<Workouts> sundayWorkouts = new ArrayList<>();

    private ArrayList<Workouts> mondayWorkouts = new ArrayList<>();

    private ArrayList<Workouts> tuesdayWorkouts = new ArrayList<>();

    private ArrayList<Workouts> wednesdayWorkouts = new ArrayList<>();

    private ArrayList<Workouts> thursdayWorkouts = new ArrayList<>();

    private Session saturdaySession;

    private Session sundaySession;

    private Session mondaySession;

    private Session tuesdaySession;

    private Session wednesdaySession;

    private Session thursdaySession;

    @FXML
    public void initialize() {
        sessionDays.setItems(FXCollections.observableArrayList("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"));

        workouts.setItems(workout.getWorkoutsList());
        
        workouts.setCellFactory(new Callback<ListView<Workouts>, ListCell<Workouts>>() {
            @Override
            public ListCell<Workouts> call(ListView<Workouts> param) {
                return new ListCell<Workouts>() {
                        @Override 
                        protected void updateItem(Workouts workout, boolean empty) {
                            super.updateItem(workout, empty);
                            
                            if (workout == null || empty) {
                                setText(null);
                            } else { 
                                setText(workout.getWorkoutName()); //Set the text to be displayed as the name property of your object.            
                            }                   
                        }  
                };
            }
        });

        workouts.setConverter(new StringConverter<Workouts>() {
            @Override
            public String toString(Workouts workout) {
                if (workout == null){
                    return null;
                } else {
                    return workout.getWorkoutName();
                }
            }

            @Override
            public Workouts fromString(String arg0) {
                // TODO Auto-generated method stub
                return new Workouts(Integer.valueOf(arg0));
            }
        });
    }

    // Add session button design
    @FXML
    void addSessionOnClicked(MouseEvent event) throws NullPointerException {
        try {
            switch (sessionDays.getValue()) {
                case "Saturday":
                    if (!reservedDays[0]) {
                        reservedDays[0] = true;
                        confirmIcon.setVisible(true);
                        errorIcon.setVisible(false);
                        message.setText("A session on " + sessionDays.getValue() + " has been added successfully, you can now add workouts.");
                        message.setStyle("-fx-text-fill: #43896B");
                        message.setVisible(true);
                    } else {
                        confirmIcon.setVisible(false);
                        errorIcon.setVisible(true);
                        message.setText("This day is already in the plan, you can now add workouts to it.");
                        message.setStyle("-fx-text-fill: #D53A0B");
                        message.setVisible(true);
                    } break;
                case "Sunday":
                    if (!reservedDays[1]) {
                        reservedDays[1] = true;
                        confirmIcon.setVisible(true);
                        errorIcon.setVisible(false);
                        message.setText("A session on " + sessionDays.getValue() + " has been added successfully, you can now add workouts.");
                        message.setStyle("-fx-text-fill: #43896B");
                        message.setVisible(true);
                    } else {
                        confirmIcon.setVisible(false);
                        errorIcon.setVisible(true);
                        message.setText("This day is already in the plan, you can now add workouts to it.");
                        message.setStyle("-fx-text-fill: #D53A0B");
                        message.setVisible(true);
                    } break;
                case "Monday":
                    if (!reservedDays[2]) {
                        reservedDays[2] = true;
                        confirmIcon.setVisible(true);
                        errorIcon.setVisible(false);
                        message.setText("A session on " + sessionDays.getValue() + " has been added successfully, you can now add workouts.");
                        message.setStyle("-fx-text-fill: #43896B");
                        message.setVisible(true);
                    } else {
                        confirmIcon.setVisible(false);
                        errorIcon.setVisible(true);
                        message.setText("This day is already in the plan, you can now add workouts to it.");
                        message.setStyle("-fx-text-fill: #D53A0B");
                        message.setVisible(true);
                    } break;
                case "Tuesday":
                    if (!reservedDays[3]) {
                        reservedDays[3] = true;
                        confirmIcon.setVisible(true);
                        errorIcon.setVisible(false);
                        message.setText("A session on " + sessionDays.getValue() + " has been added successfully, you can now add workouts.");
                        message.setStyle("-fx-text-fill: #43896B");
                        message.setVisible(true);
                    } else {
                        confirmIcon.setVisible(false);
                        errorIcon.setVisible(true);
                        message.setText("This day is already in the plan, you can now add workouts to it.");
                        message.setStyle("-fx-text-fill: #D53A0B");
                        message.setVisible(true);
                    } break;
                case "Wednesday":
                    if (!reservedDays[4]) {
                        reservedDays[4] = true;
                        confirmIcon.setVisible(true);
                        errorIcon.setVisible(false);
                        message.setText("A session on " + sessionDays.getValue() + " has been added successfully, you can now add workouts.");
                        message.setStyle("-fx-text-fill: #43896B");
                        message.setVisible(true);
                    } else {
                        confirmIcon.setVisible(false);
                        errorIcon.setVisible(true);
                        message.setText("This day is already in the plan, you can now add workouts to it.");
                        message.setStyle("-fx-text-fill: #D53A0B");
                        message.setVisible(true);
                    } break;
                case "Thursday":
                    if (!reservedDays[5]) {
                        reservedDays[5] = true;
                        confirmIcon.setVisible(true);
                        errorIcon.setVisible(false);
                        message.setText("A session on " + sessionDays.getValue() + " has been added successfully, you can now add workouts.");
                        message.setStyle("-fx-text-fill: #43896B");
                        message.setVisible(true);
                    } else {
                        confirmIcon.setVisible(false);
                        errorIcon.setVisible(true);
                        message.setText("This day is already in the plan, you can now add workouts to it.");
                        message.setStyle("-fx-text-fill: #D53A0B");
                        message.setVisible(true);
                    } break;
            }
        } catch (NullPointerException e) {
            confirmIcon.setVisible(false);
            errorIcon.setVisible(true);
            message.setText("Please select a session's day to add to the plan.");
            message.setStyle("-fx-text-fill: #D53A0B");
            message.setVisible(true);
        }
    }

    @FXML
    void addSessionOnPressed(MouseEvent event) {
        addSession.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        addSession.setEffect(new Glow(0.3));
    }

    @FXML
    void addSessionOnReleased(MouseEvent event) {
        addSession.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        addSession.setEffect(new Glow(0.0));
    }

    @FXML
    void addSessionInHover(MouseEvent event) {
        addSession.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void addSessionOutHover(MouseEvent event) {
        addSession.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    // Add workout button design
    @FXML
    void addWorkoutOnClicked(MouseEvent event) throws NullPointerException {
        try {
            if (workouts.getValue() != null) {
                switch (sessionDays.getValue()) {
                    case "Saturday":
                        if (reservedDays[0]) {
                            if (!(saturdayWorkouts.contains(workouts.getValue()))) {
                                saturdayWorkouts.add(workouts.getValue());
                                workouts.setPromptText("Workouts");
                                confirmIcon.setVisible(true);
                                errorIcon.setVisible(false);
                                message.setText(workouts.getValue().getWorkoutName() + " has been added to " + sessionDays.getValue() + "'s session.");
                                message.setStyle("-fx-text-fill: #43896B");
                                message.setVisible(true);
                            } else {
                                confirmIcon.setVisible(false);
                                errorIcon.setVisible(true);
                                message.setText("This workout is already in the session, choose other workouts to add.");
                                message.setStyle("-fx-text-fill: #D53A0B");
                                message.setVisible(true);
                            }
                        } else {
                            confirmIcon.setVisible(false);
                            errorIcon.setVisible(true);
                            message.setText("Selected day is not in the plan, add it and try again.");
                            message.setStyle("-fx-text-fill: #D53A0B");
                            message.setVisible(true);
                        } break;
                    case "Sunday":
                        if (reservedDays[1]) {
                            if (!(sundayWorkouts.contains(workouts.getValue()))) {
                                sundayWorkouts.add(workouts.getValue());
                                workouts.setPromptText("Workouts");
                                confirmIcon.setVisible(true);
                                errorIcon.setVisible(false);
                                message.setText(workouts.getValue().getWorkoutName() + " has been added to " + sessionDays.getValue() + "'s session.");
                                message.setStyle("-fx-text-fill: #43896B");
                                message.setVisible(true);
                            } else {
                                confirmIcon.setVisible(false);
                                errorIcon.setVisible(true);
                                message.setText("This workout is already in the session, choose other workouts to add.");
                                message.setStyle("-fx-text-fill: #D53A0B");
                                message.setVisible(true);
                            }
                        } else {
                            confirmIcon.setVisible(false);
                            errorIcon.setVisible(true);
                            message.setText("Selected day is not in the plan, add it and try again.");
                            message.setStyle("-fx-text-fill: #D53A0B");
                            message.setVisible(true);
                        } break;
                    case "Monday":
                        if (reservedDays[2]) {
                            if (!(mondayWorkouts.contains(workouts.getValue()))) {
                                mondayWorkouts.add(workouts.getValue());
                                workouts.setPromptText("Workouts");
                                confirmIcon.setVisible(true);
                                errorIcon.setVisible(false);
                                message.setText(workouts.getValue().getWorkoutName() + " has been added to " + sessionDays.getValue() + "'s session.");
                                message.setStyle("-fx-text-fill: #43896B");
                                message.setVisible(true);
                            } else {
                                confirmIcon.setVisible(false);
                                errorIcon.setVisible(true);
                                message.setText("This workout is already in the session, choose other workouts to add.");
                                message.setStyle("-fx-text-fill: #D53A0B");
                                message.setVisible(true);
                            }
                        } else {
                            confirmIcon.setVisible(false);
                            errorIcon.setVisible(true);
                            message.setText("Selected day is not in the plan, add it and try again.");
                            message.setStyle("-fx-text-fill: #D53A0B");
                            message.setVisible(true);
                        } break;
                    case "Tuesday":
                        if (reservedDays[3]) {
                            if (!(tuesdayWorkouts.contains(workouts.getValue()))) {
                                tuesdayWorkouts.add(workouts.getValue());
                                workouts.setPromptText("Workouts");
                                confirmIcon.setVisible(true);
                                errorIcon.setVisible(false);
                                message.setText(workouts.getValue().getWorkoutName() + " has been added to " + sessionDays.getValue() + "'s session.");
                                message.setStyle("-fx-text-fill: #43896B");
                                message.setVisible(true);
                            } else {
                                confirmIcon.setVisible(false);
                                errorIcon.setVisible(true);
                                message.setText("This workout is already in the session, choose other workouts to add.");
                                message.setStyle("-fx-text-fill: #D53A0B");
                                message.setVisible(true);
                            }
                        } else {
                            confirmIcon.setVisible(false);
                            errorIcon.setVisible(true);
                            message.setText("Selected day is not in the plan, add it and try again.");
                            message.setStyle("-fx-text-fill: #D53A0B");
                            message.setVisible(true);
                        } break;
                    case "Wednesday":
                        if (reservedDays[4]) {
                            if (!(wednesdayWorkouts.contains(workouts.getValue()))) {
                                wednesdayWorkouts.add(workouts.getValue());
                                workouts.setPromptText("Workouts");
                                confirmIcon.setVisible(true);
                                errorIcon.setVisible(false);
                                message.setText(workouts.getValue().getWorkoutName() + " has been added to " + sessionDays.getValue() + "'s session.");
                                message.setStyle("-fx-text-fill: #43896B");
                                message.setVisible(true);
                            } else {
                                confirmIcon.setVisible(false);
                                errorIcon.setVisible(true);
                                message.setText("This workout is already in the session, choose other workouts to add.");
                                message.setStyle("-fx-text-fill: #D53A0B");
                                message.setVisible(true);
                            }
                        } else {
                            confirmIcon.setVisible(false);
                            errorIcon.setVisible(true);
                            message.setText("Selected day is not in the plan, add it and try again.");
                            message.setStyle("-fx-text-fill: #D53A0B");
                            message.setVisible(true);
                        } break;
                    case "Thursday":
                        if (reservedDays[5]) {
                            if (!(thursdayWorkouts.contains(workouts.getValue()))) {
                                thursdayWorkouts.add(workouts.getValue());
                                workouts.setPromptText("Workouts");
                                confirmIcon.setVisible(true);
                                errorIcon.setVisible(false);
                                message.setText(workouts.getValue().getWorkoutName() + " has been added to " + sessionDays.getValue() + "'s session.");
                                message.setStyle("-fx-text-fill: #43896B");
                                message.setVisible(true);
                            } else {
                                confirmIcon.setVisible(false);
                                errorIcon.setVisible(true);
                                message.setText("This workout is already in the session, choose other workouts to add.");
                                message.setStyle("-fx-text-fill: #D53A0B");
                                message.setVisible(true);
                            }
                        } else {
                            confirmIcon.setVisible(false);
                            errorIcon.setVisible(true);
                            message.setText("Selected day is not in the plan, add it and try again.");
                            message.setStyle("-fx-text-fill: #D53A0B");
                            message.setVisible(true);
                        } break;
                }
            } else {
                confirmIcon.setVisible(false);
                errorIcon.setVisible(true);
                message.setText("Please select a workout to add to the session.");
                message.setStyle("-fx-text-fill: #D53A0B");
                message.setVisible(true);
            }
        } catch (NullPointerException e) {
            confirmIcon.setVisible(false);
            errorIcon.setVisible(true);
            message.setText("You did not select a session's day.");
            message.setStyle("-fx-text-fill: #D53A0B");
            message.setVisible(true);
        }
    }

    @FXML
    void addWorkoutOnPressed(MouseEvent event) {
        addWorkout.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
        addWorkout.setEffect(new Glow(0.3));
    }

    @FXML
    void addWorkoutOnReleased(MouseEvent event) {
        addWorkout.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15; -fx-cursor: hand");
        addWorkout.setEffect(new Glow(0.0));
    }

    @FXML
    void addWorkoutInHover(MouseEvent event) {
        addWorkout.setStyle("-fx-background-color: #366D55; -fx-background-radius: 15; -fx-cursor: hand");
    }

    @FXML
    void addWorkoutOutHover(MouseEvent event) {
        addWorkout.setStyle("-fx-background-color: #43896B; -fx-background-radius: 15");
    }

    // Asign customized plan button design
    @FXML
    void assignPlanOnClicked(MouseEvent event) {
        Pattern pattern = Pattern.compile("\\p{Punct}|\\p{Sc}");
        Matcher match = pattern.matcher(planName.getText());
        boolean allLettersName = !match.find();
        boolean flag = false;

        if (reservedDays[0] && saturdayWorkouts.size() > 0) {
            saturdaySession = new Session("Saturday", saturdayWorkouts);
            sessionsList.add(saturdaySession);
            flag = true;
        }  if (reservedDays[1] && sundayWorkouts.size() > 0) {
            sundaySession = new Session("Sunday", sundayWorkouts);
            sessionsList.add(sundaySession);
            flag = true;
        }  if (reservedDays[2] && mondayWorkouts.size() > 0) {
            mondaySession = new Session("Monday", mondayWorkouts);
            sessionsList.add(mondaySession);
            flag = true;
        }  if (reservedDays[3] && tuesdayWorkouts.size() > 0) {
            tuesdaySession = new Session("Tuesday", tuesdayWorkouts);
            sessionsList.add(tuesdaySession);
            flag = true;
        }  if (reservedDays[4] && wednesdayWorkouts.size() > 0) {
            wednesdaySession = new Session("Wednesday", wednesdayWorkouts);
            sessionsList.add(wednesdaySession);
            flag = true;
        }  if (reservedDays[5] && thursdayWorkouts.size() > 0) {
            thursdaySession = new Session("Thursday", thursdayWorkouts);
            sessionsList.add(thursdaySession);
            flag = true;
        }  if(!flag){
            confirmIcon.setVisible(false);
            errorIcon.setVisible(true);
            message.setText("You did not add a session's day or did not add workouts to any session.");
            message.setStyle("-fx-text-fill: #D53A0B");
            message.setVisible(true);
        }

        if (sessionsList.size() > 0 && allLettersName) {
            plan = new Plan(planName.getText(), sessionsList);
            trainee.setPlan(plan);

            sessionDays.setPromptText("Session Days");
            workouts.setPromptText("Workouts");

            confirmIcon.setVisible(true);
            errorIcon.setVisible(false);
            message.setText(planName.getText() + " has been assigned to " + trainee.getName() + " successfully.");
            message.setStyle("-fx-text-fill: #43896B");
            message.setVisible(true);
        } else {
            confirmIcon.setVisible(false);
            errorIcon.setVisible(true);
            message.setText("Plan name is incorrect or you did not add sessions nor workouts.");
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

    // Back icon design
    @FXML
    public void backToAssignPlanPage(MouseEvent event) throws IOException {
        AnchorPane viewTraineesPage = FXMLLoader.load(getClass().getResource("AssignPlanPage.fxml"));
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

    // Plan name design
    @FXML
    void planNameInHover(MouseEvent event) {
        planName.setStyle("-fx-cursor: text; -fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #3A4141; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

    @FXML
    void planNameOutHover(MouseEvent event) {
        planName.setStyle("-fx-border-color: #43896B; -fx-border-width: 0px 0px 1px 0px; -fx-background-color: #313131; -fx-background-radius: 5px 5px 0px 0px; -fx-text-fill: #F4F9F1");
    }

}
