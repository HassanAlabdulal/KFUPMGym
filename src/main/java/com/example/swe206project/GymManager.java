package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public class GymManager implements Initializable{
    private String userName = "admin";
    private String password = "admin";

    private ArrayList<User> usersList = new ArrayList<>();

    public GymManager(){
        usersList = (ArrayList<User>) initilize("GymManager");
    }

 

    protected void createProfile(String name, double height, double weight){
        usersList.add(new Trainee(name, height, weight));
    }

    protected void createProfile(String name, double height, double weight, String speciality){
        usersList.add(new Trainer(name, height, weight, speciality));
    }

    public ArrayList<User> getUsersList() {
        return usersList;
    }

    protected static void setActivationStatus(String userName, boolean active){
        ReadFiles fileReader = new ReadFiles("UserInfo.txt");
        WriteFiles writer = new WriteFiles("UserInfo.txt");

        String status;
        if(active)
            status = "active";
        else
            status = "not-active";
            
        int desiredLine = fileReader.getLine(userName);           
        if(User.isActive(userName))
            writer.modifyLine(desiredLine, status, "active");
        else
            writer.modifyLine(desiredLine, status, "not-active");
        
    }

    protected static void setActivationStatus(Trainee trainee, boolean active){
        setActivationStatus(trainee.toString(), active);
    }

    protected static void setActivationStatus(Trainer trainer, boolean active){
        setActivationStatus(trainer.toString(), active);
    }


}
