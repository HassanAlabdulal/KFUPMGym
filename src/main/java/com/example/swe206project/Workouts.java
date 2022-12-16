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

    protected ObservableList<Workouts> observableWorkoutList = FXCollections.observableArrayList();

    public Workouts(){

    }

    public Workouts(String workoutName, String targetedMucles,int setsTarget, int repititionTarget, String steps){
        this.id=IDGenerator.generate("Workouts.txt");
        this.workoutName = workoutName;
        this.targetedMuscles = targetedMucles;
        this.steps = steps;
        this.setsTarget =setsTarget;
        this.repititionTarget = repititionTarget;

    }

    public Workouts(int workoutId){
        ReadFiles reader = new ReadFiles<>("Workouts.txt");
        id = workoutId;
        workoutName = reader.fetch(workoutId+"", "\\$\\p{Graph}*").replaceAll("\\$", "");
        targetedMuscles = reader.fetch(workoutId+"", "\\!\\p{Alpha}*").replaceAll("!", "");
        setsTarget = Integer.valueOf(reader.fetch(workoutId+"", "\\#\\p{Digit}*").replaceAll("#", ""));
        repititionTarget = Integer.valueOf(reader.fetch(workoutId+"", "\\*\\p{Digit}*").replaceAll("\\*", ""));
        steps = reader.fetch(workoutId+"", "\\1\\p{ASCII}*$");
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
        return steps;
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
        return weightUsed;
    }
    public int getActualSets() {
        return actualSets;
    }

    public String getSetsProgress(){
        return actualSets + "/" + setsTarget;
    }

    public String getRepitionsProgress(){
        return actualRepitions + "/" + repititionTarget;
    }

    public int getActualRepitions() {
        return actualRepitions;
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
    public void saveworkout(String workoutName, String targetedMuscles,int setsTarget, int repititionTarget, String steps) {
        WriteFiles writer = new WriteFiles("Workouts.txt", true);
        String meow = this.id + " $" + workoutName.replaceAll(" ", "-") +  " !" + targetedMuscles  +" #"+ setsTarget +" *"+ repititionTarget+" "+ steps;
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
