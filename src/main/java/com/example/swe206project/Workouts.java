package com.example.swe206project;

import java.io.IOException;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public  class Workouts {
    private int id;
    private String workoutName;
    private String targetedMuscles; 
    private String steps;
    private int setsTarget;
    private int repititionTarget;
    private String videoURL;
    private int weightUsed;
    private int actualSets;
    private int actualRepitions;
    private int weightTarget;
    private int volumeTarget;
    private int volume;

    protected String weightProgress = "";
    protected String setsProgress = "";
    protected String repitionsProgress = "";

    protected ObservableList<Workouts> observableWorkoutList = FXCollections.observableArrayList();

    public Workouts(){

    }

    public Workouts(String workoutName, String targetedMucles,int setsTarget, int repititionTarget, int weightTarget, String steps){
        this.id=IDGenerator.generate("Workouts.txt");
        this.workoutName = workoutName;
        this.targetedMuscles = targetedMucles;
        this.steps = steps;
        this.setsTarget =setsTarget;
        this.repititionTarget = repititionTarget;
        this.weightTarget = weightTarget;
        saveworkout(workoutName, targetedMucles, setsTarget, repititionTarget, weightTarget, steps);
    }

    public Workouts(int workoutId){
        ReadFiles reader = new ReadFiles<>("Workouts.txt");
        id = workoutId;
        workoutName = reader.fetch(workoutId+"", "\\$\\p{Graph}*").replaceAll("\\$", "");
        targetedMuscles = reader.fetch(workoutId+"", "\\!\\p{Alpha}*").replaceAll("!", "");
        setsTarget = Integer.valueOf(reader.fetch(workoutId+"", "\\#\\p{Digit}*").replaceAll("#", ""));
        repititionTarget = Integer.valueOf(reader.fetch(workoutId+"", "\\*\\p{Digit}*").replaceAll("\\*", ""));
        steps = reader.fetch(workoutId+"", "\\[\\p{ASCII}*\\]");
        weightTarget = Integer.valueOf(reader.fetch(workoutId+"", "\\?\\p{Digit}*").replaceAll("\\?", ""));
    }
    

    public int getId(){
            return id;
    }
    public String getWorkoutName() {
        return workoutName;
    }
    public String getTargetedMuscles() {
        return targetedMuscles;
    }
    public String getSteps() {
        String[] tmp = steps.replaceAll("\\[|\\]", "").split("\\p{Digit}\\?");
        String tmp2 = "";
        for (int i = 0; i < tmp.length; i++) {
            if(!tmp[i].equals(""))
                tmp2 += i + ": " + tmp[i] + "\n\n";
        }
        // return tmp.replaceAll("\\[|\\]", "");
        return tmp2;
    }
    public int getSetsTarget() {
        return setsTarget;
    }
    public int getRepititionTarget() {
        return repititionTarget;
    }
    public String getVideoURL() {
        return videoURL;
    }
    public int getWeightUsed() {
        Trainee trainee = (Trainee) LoginFormController.user;
        ReadFiles r = new ReadFiles<>("Progress.txt");
        String weight = r.fetch(trainee.userName + " " + PlanPageController.day, "\\*\\p{Digit}").replaceAll("\\*", "");
        return Integer.valueOf(weight);
    }
    public int getActualSets() {
        Trainee trainee = (Trainee) LoginFormController.user;
        ReadFiles r = new ReadFiles<>("Progress.txt");
        String sets = r.fetch(trainee.userName + " " + PlanPageController.day, "\\!\\p{Digit}").replaceAll("\\!", "");
        return Integer.valueOf(sets);
    }

    public String getSetsProgress(){
        return getActualSets() + "/" + setsTarget;
    }

    public String getRepitionsProgress(){
        return getActualRepitions() + "/" + repititionTarget;
    }

    public String getWeightProgress() {
        return getWeightUsed() + "";
    }

    public String getVolumeProgress() {
        volume = getWeightUsed() * getActualRepitions() * getActualSets();
        return volume + "";
    }

    public int getActualRepitions() {
        Trainee trainee = (Trainee) LoginFormController.user;
        ReadFiles r = new ReadFiles<>("Progress.txt");
        String rep = r.fetch(trainee.userName + " " + PlanPageController.day, "\\?\\p{Digit}").replaceAll("\\?", "");
        return Integer.valueOf(rep);
    }
    public void setActualRepitions(int actualRepitions) {
        this.actualRepitions = actualRepitions;
    }
    public void setActualSets(int actualSets) {
        this.actualSets = actualSets;
    }
    public void setweightUsed(int weightUsed) {
        this.weightUsed = weightUsed;
    }
    public void saveworkout(String workoutName, String targetedMuscles,int setsTarget, int repititionTarget, int weightTarget, String steps) {
        WriteFiles writer = new WriteFiles("Workouts.txt", true);
        String meow = this.id + " $" + workoutName.replaceAll(" ", "-") +  " !" + targetedMuscles  +" #"+ setsTarget +" *"+ repititionTarget + "?" + weightTarget + " [" + steps + "]";
        try {
                writer.writeToFile(meow);
            }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String toString(){
        return workoutName + " " + id;
    }


    public ObservableList<Workouts> getWorkoutsList() {
        ReadFiles reader = new ReadFiles<>("Workouts.txt");
        try {
            for (String workoutInfo : reader.openFile()) {
                if(!workoutInfo.contains("|")){
                    Workouts workout = new Workouts(Integer.valueOf(workoutInfo.replaceAll("\\s\\p{ASCII}*$", "")));
                    if(!observableWorkoutList.contains(workout))
                        observableWorkoutList.add(workout);     
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return observableWorkoutList;
    };
    





}
