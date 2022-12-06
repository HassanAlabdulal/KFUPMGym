package com.example.swe206project;

import java.io.Serializable;
import java.util.ArrayList;

public class Session implements Initializable, Serializable{
    private int id;
    private String day;
    private String hour;
    private ArrayList<Workout> workoutList = new ArrayList<>();
    private ArrayList<Session> sessionsList = new ArrayList<>();

    public Session(){
        sessionsList = (ArrayList<Session>) initilize("Session"); // to be worked in init
    }

    public Session(String day, String hour, ArrayList<Workout> workoutsList){
        this.day = day;
        this.hour = hour;
        this.workoutList = workoutsList;
        id = IDGenerator.generate("");
    }

    public Session(String day, String hour){
        this.day = day;
        this.hour = hour;
    }


}
