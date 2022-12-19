package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javafx.css.Size;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
        ReadFiles r = new ReadFiles<>("UserAndPass.txt");
        Trainee trainee = new Trainee(name, height, weight);
        usersList.add(trainee);

        Alert alert = new Alert(AlertType.INFORMATION);
        String[] creds = r.fetch(trainee.userName, "\\p{ASCII}*\\$").split(" ");

        alert.setTitle("Sucess!");
        alert.setHeaderText("Hello " + name + "! see below your credentials");
        alert.setContentText("Username: " + creds[0] + ", Password: " + creds[1].replaceAll("\\$", ""));
        alert.show();
        //try {
        //    writer.writeToFile(usersList.get(usersList.size()-1).toString());
        //} catch (IOException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //}
    }

    protected static void createProfile(String name, double height, double weight, String speciality){
        ReadFiles r = new ReadFiles<>("UserAndPass.txt");
        Trainer trainer = new Trainer(name, height, weight, speciality);
        usersList.add(trainer);

        Alert alert = new Alert(AlertType.INFORMATION);
        String[] creds = r.fetch(trainer.userName, "\\p{ASCII}*\\$").split(" ");

        alert.setTitle("Sucess!");
        alert.setHeaderText("Hello " + name + "! see below your credentials");
        alert.setContentText("Username: " + creds[0] + ", Password: " + creds[1].replaceAll("\\$", ""));
        alert.show();
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
            
        int desiredLine = fileReader.getLine("@"+userName);
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
