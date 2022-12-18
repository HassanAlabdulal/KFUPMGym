package com.example.swe206project;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public  class Workouts {
    protected int id;
    protected String workoutName;
    protected String targetedMuscles; 
    protected String steps;
    protected int setsTarget;
    protected int repititionTarget;
    protected String videoURL;
    protected int weightUsed;
    protected int actualSets;
    protected int actualRepitions;
    protected int weightTarget;
    protected int volumeTarget;
    protected int volume;

    protected String weightProgress = "";
    protected String setsProgress = "";
    protected String repitionsProgress = "";

    protected Trainee trainee;
    protected Session session;

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
        if(this.trainee == null)
            trainee = (Trainee) LoginFormController.user;
        if(this.session == null)
            session = SessionPage.dSession;
        
        ReadFiles r = new ReadFiles<>("Progress.txt");
        String[] workouts = r.fetch(trainee.userName + " " + session, "\\[\\p{ASCII}*\\]").split(",");
        // ArrayList<Workouts> workoutsList = new ArrayList<>();
        for (String workoutInfo : workouts) {
            if(workoutInfo.contains(id+"")){
                Pattern pattern = Pattern.compile("\\*\\p{Digit}");
                Matcher match = pattern.matcher(workoutInfo);
                return match.find() ? Integer.valueOf(match.group().replaceAll("\\*", "")) : -1;
            }
        }
        //String sets = r.fetch(trainee.userName + " " + PlanPageController.day, workoutName, "\\!\\p{Digit}").replaceAll("\\!", "");
        // return Integer.valueOf(sets);
        return -1;
    }
    public int getActualSets() {
        if(this.trainee == null)
            trainee = (Trainee) LoginFormController.user;
        if(this.session == null)
            session = SessionPage.dSession;
            
        ReadFiles r = new ReadFiles<>("Progress.txt");
        String[] workouts = r.fetch(trainee.userName + " " + session, "\\[\\p{ASCII}*\\]").split(",");
        // ArrayList<Workouts> workoutsList = new ArrayList<>();
        for (String workoutInfo : workouts) {
            if(workoutInfo.contains(id+"")){
                Pattern pattern = Pattern.compile("\\!\\p{Digit}");
                Matcher match = pattern.matcher(workoutInfo);
                return match.find() ? Integer.valueOf(match.group().replaceAll("\\!", "")) : -1;
            }
        }
        //String sets = r.fetch(trainee.userName + " " + PlanPageController.day, workoutName, "\\!\\p{Digit}").replaceAll("\\!", "");
        // return Integer.valueOf(sets);
        return -1;
    }

    public int getActualRepitions() {
        if(this.trainee == null)
            trainee = (Trainee) LoginFormController.user;
        if(this.session == null)
            session = SessionPage.dSession;

        ReadFiles r = new ReadFiles<>("Progress.txt");
        String[] workouts = r.fetch(trainee.userName + " " + session, "\\[\\p{ASCII}*\\]").split(",");
        // ArrayList<Workouts> workoutsList = new ArrayList<>();
        for (String workoutInfo : workouts) {
            if(workoutInfo.contains(id+"")){
                Pattern pattern = Pattern.compile("\\?\\p{Digit}");
                Matcher match = pattern.matcher(workoutInfo);
                return match.find() ? Integer.valueOf(match.group().replaceAll("\\?", "")) : -1;
            }
        }
        //String sets = r.fetch(trainee.userName + " " + PlanPageController.day, workoutName, "\\!\\p{Digit}").replaceAll("\\!", "");
        // return Integer.valueOf(sets);
        return -1;
    }

    public String getSetsProgress(){
        trainee = ViewTraineesPageController.trainee;
        session = ProgressPageController.desiredSession;
        return getActualSets() + "/" + setsTarget;
    }

    public String getRepitionsProgress(){
        trainee = ViewTraineesPageController.trainee;
        session = ProgressPageController.desiredSession;
        return getActualRepitions() + "/" + repititionTarget;
    }

    public String getWeightProgress() {
        trainee = ViewTraineesPageController.trainee;
        session = ProgressPageController.desiredSession;
        return getWeightUsed() + "/" + weightTarget;
    }

    public String getVolumeProgress() {
        trainee = ViewTraineesPageController.trainee;
        session = ProgressPageController.desiredSession;
        volume = getWeightUsed() * getActualRepitions() * getActualSets();
        volumeTarget = weightTarget * repititionTarget * setsTarget;
        return String.format("%.2f", (double) volume/volumeTarget * 100) + "%";
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
        return id + " !" + getActualSets() + " ?" + getActualRepitions() + " *" + getWeightUsed();
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
