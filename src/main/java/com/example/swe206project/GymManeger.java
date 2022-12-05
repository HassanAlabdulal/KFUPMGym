package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public class GymManeger {
    private String userName = "admin";
    private String password = "admin";

    private ArrayList<String> usersList = new ArrayList<>();

    public GymManeger(){
        usersList = initilizeList();
    }

    private ArrayList<String> initilizeList() {
        ReadFiles credfile = new ReadFiles("UserAndPass.txt");
        try {
            for (String user : credfile.openFile()) {
                usersList.add(user.replaceAll("\\s\\p{ASCII}*$", ""));
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    protected void createProfile(String name, double height, double weight){
        usersList.add(new Trainee(name, height, weight).getUsername());
    }

    protected void createProfile(String name, double height, double weight, String speciality){
        usersList.add(new Trainer(name, height, weight, speciality).getUsername());
    }





}
