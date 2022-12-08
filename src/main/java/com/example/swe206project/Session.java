package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Session implements Initializable, Serializable{
    protected int id;
    private String day;
    private ArrayList<String> workoutList = new ArrayList<>();
    private ArrayList<Session> sessionsList = new ArrayList<>();

    public Session(){
        sessionsList = (ArrayList<Session>) initilize("Session"); // to be worked in init
    }

    public Session(String day, ArrayList<String> workoutsList){
        this.day = day;
        this.workoutList = workoutsList;
        id = IDGenerator.generate("Sessions.txt");
        save(id, day, workoutsList);
    }

    public Session(String day){ // ???
        this.day = day;
    }

    public void save(int id, String day, ArrayList<String> workoutsList){
        WriteFiles writer = new WriteFiles("Sessions.txt", true);
        String data = id + " " + day + "$ " + workoutsList;
        try {
            writer.writeToFile(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getWorkoutList(int id){
        ReadFiles read = new ReadFiles<>("Sessions.txt");
        ArrayList<String> list = new ArrayList<>();
        for(String workout : read.fetch(String.valueOf(id), "\\[\\p{ASCII}*\\]").replaceAll("\\s|\\[|\\]", "").split(","))
            list.add(workout);
        return list;
    }

    public static String getDay(int id){
        ReadFiles read = new ReadFiles<>("Sessions.txt");
        return read.fetch(String.valueOf(id), "\\p{Alpha}*\\$").replaceAll("\\$", "");
    }

    public ArrayList<String> getWorkoutList(){
        return workoutList;
    }

    public String getDay(){
        return day;
    }

}
