package com;

import java.io.IOException;
import java.nio.file.Path;

import com.example.swe206project.IDGenerator;
import com.example.swe206project.WriteFiles;

public abstract class Workouts {
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

    public Workouts(int id,String workoutName, String targetedMucles, String steps,int setsTarget, int repititionTarget){
        this.id=IDGenerator.generate("u");
        this.workoutName = workoutName;
        this.targetedMuscles = targetedMucles;
        this.steps = steps;
        this.setsTarget =setsTarget;
        this.repititionTarget = repititionTarget;

    }
    

    public int getId(String userName){
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
    public int getActualRepitions() {
        return actualRepitions;
    }
    public void setActualRepitions(int actualRepitions) {
        this.actualRepitions = actualRepitions;
    }
    public void setActualSets(int actualSets) {
        this.actualSets = actualSets;
    }
    private void save(String username, String password, String specifier) {
        WriteFiles writer = new WriteFiles("Workouts.txt", true);
        IDGenerator genId = new IDGenerator(specifier, false);
        int id = genId.getGenId();
        try {
                writer.writeToFile(username + " " + password +  "$ " + id + " " + specifier);
            }
        catch (IOException e) {
            e.printStackTrace();
        }

}
