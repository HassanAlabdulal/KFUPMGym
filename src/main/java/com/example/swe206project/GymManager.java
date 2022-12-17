package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.css.Size;

public class GymManager implements Initializable, Serializable{
    private String userName = "admin";
    private String password = "admin";

    protected static ArrayList<User> usersList = new ArrayList<>();

    public GymManager(){
        //WriteFiles writer = new WriteFiles<>("UserInfo.dat", true);
        //usersList = (ArrayList<User>) initilize("GymManager");
        //System.out.println(usersList);
        //for (User user : usersList) {
        //    writer.writeToBinaryFile(user);
        //}
        //writer.writeToBinaryFile(null);
        //System.out.println(fr.openBinaryFile());
    }

    public GymManager(String userName){
        usersList = (ArrayList<User>) initilize("GymManager");
    }

    

    protected static void createProfile(String name, double height, double weight){
        WriteFiles writer = new WriteFiles<>("UserInfo.txt", true);
        usersList.add(new Trainee(name, height, weight));
        //try {
        //    writer.writeToFile(usersList.get(usersList.size()-1).toString());
        //} catch (IOException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //}
    }

    protected static void createProfile(String name, double height, double weight, String speciality){
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
