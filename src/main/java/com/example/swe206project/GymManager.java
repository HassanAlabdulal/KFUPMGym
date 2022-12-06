package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public class GymManager implements init{
    private String userName = "admin";
    private String password = "admin";

    private ArrayList<String> usersList = new ArrayList<>();

    public GymManager(){
        usersList = (ArrayList<String>) initilize("GymManager");
        System.out.println("the users are: " + usersList);
    }

 

    protected void createProfile(String name, double height, double weight){
        usersList.add(new Trainee(name, height, weight).getUsername());
    }

    protected void createProfile(String name, double height, double weight, String speciality){
        usersList.add(new Trainer(name, height, weight, speciality).getUsername());
    }

}
