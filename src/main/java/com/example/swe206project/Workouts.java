package com.example.swe206project;

import java.io.IOException;
import java.nio.file.Path;

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

    public Workouts(String workoutName, String targetedMucles,int setsTarget, int repititionTarget, String steps){
        this.id=IDGenerator.generate("Workouts.txt");
        this.workoutName = workoutName;
        this.targetedMuscles = targetedMucles;
        this.steps = steps;
        this.setsTarget =setsTarget;
        this.repititionTarget = repititionTarget;

    }
    

    public int getId(String Workouts){
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
    public void saveworkout(String workoutName, String targetedMuscles,int setsTarget, int repititionTarget, String steps) {
        WriteFiles writer = new WriteFiles("Workouts.txt", true);
        String meow = this.id + " " + workoutName.replaceAll(" ", "-") +  " " + targetedMuscles  +" "+ setsTarget +" "+ repititionTarget+" "+ steps;
        try {
                writer.writeToFile(meow);
            }
        catch (IOException e) {
            e.printStackTrace();
        }

}
}
