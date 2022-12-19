package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Session implements Initializable, Serializable{
    protected int id;
    protected String day;
    protected ArrayList<Workouts> workoutList = new ArrayList<>();
    private ArrayList<Session> sessionsList = new ArrayList<>();
    

    protected ObservableList<Workouts> observableWorkForSessionList = FXCollections.observableArrayList();

    public Session(){
        sessionsList = (ArrayList<Session>) initilize("Session"); // to be worked in init
    }

    public Session(String day, ArrayList<Workouts> workoutsList){
        this.day = day;
        this.workoutList = workoutsList;
        id = IDGenerator.generate("Sessions.txt");
        save(id, day, workoutsList);
    }

    public Session(int id){ 
        this.id = id;
        this.day = getDay(id);
        this.workoutList = getWorkoutList(id);
       
    }

    public void save(int id, String day, ArrayList<Workouts> workoutsList){
        WriteFiles writer = new WriteFiles("Sessions.txt", true);
        String data = id + " " + day + "$ " + workoutsList.toString().replaceAll("\\s\\p{Punct}\\d{1,3}\\s\\p{Punct}\\d{1,3}\\s\\p{Punct}\\d{1,3}", "");
        try {
            writer.writeToFile(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ArrayList<Workouts> getWorkoutList(int id){
        ReadFiles read = new ReadFiles<>("Sessions.txt");
        ArrayList<Workouts> list = new ArrayList<>();
        for(String workout : read.fetch(String.valueOf(id), "\\[\\p{ASCII}*\\]").replaceAll("\\s|\\[|\\]", "").split(",")){
            Workouts work = new Workouts(Integer.valueOf(workout));
            list.add(work);
        }
        return list;
    }

    public static String getDay(int id){
        ReadFiles read = new ReadFiles<>("Sessions.txt");
        return read.fetch(String.valueOf(id), "\\p{Alpha}*\\$").replaceAll("\\$", "");
    }

    public ArrayList<Workouts> getWorkoutList(){
        return workoutList;
    }

    public String getDay(){
        return day;
    }

    public String toString(){
        return id+"";
    }

    public ObservableList<Workouts> getObservableWorkoutsList() {
        for (Workouts workout : workoutList) {
            if(!observableWorkForSessionList.contains(workout))
                observableWorkForSessionList.add(workout);     
        }
        return observableWorkForSessionList;
    }


}
