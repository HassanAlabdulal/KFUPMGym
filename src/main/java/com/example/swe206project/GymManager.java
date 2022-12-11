package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.css.Size;

public class GymManager implements Initializable, Serializable{
    private String userName = "admin";
    private String password = "admin";
    private ReadFiles fr = new ReadFiles<>("UserInfo.dat");

    protected ArrayList<User> usersList = new ArrayList<>();

    public GymManager(){
        //WriteFiles writer = new WriteFiles<>("UserInfo.dat", true);
        usersList = (ArrayList<User>) initilize("GymManager");
        //System.out.println(usersList);
        //for (User user : usersList) {
        //    writer.writeToBinaryFile(user);
        //}
        //writer.writeToBinaryFile(null);
        //System.out.println(fr.openBinaryFile());
    }

    public GymManager(String userName){
        this();
    }

    

    protected void createProfile(String name, double height, double weight){
        WriteFiles writer = new WriteFiles<>("UserInfo.dat", true);
        usersList.add(new Trainee(name, height, weight));
        writer.writeToBinaryFile(usersList.get(usersList.size()-1));
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
