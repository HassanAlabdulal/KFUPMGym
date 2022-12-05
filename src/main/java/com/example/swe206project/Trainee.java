package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public class Trainee extends User{
    //Plan plan;
    private String userName;

    //public Trainee(String usr){
    //    
    //}

    public Trainee(String name, double height, double weight, String photo) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainee");
        userName = user.username;
        save(name, height, weight, photo, "active");
    }

    public void save(String name, double height, double weight, String photo, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = userName + " " + name + " " +  height + " " + weight + " " + photo + " " + status;
        try {
            writer.writeToFile(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Trainee(String name, double height, double weight){
        this(name, height, weight, "defaultPic.txt");
    }


    @Override
    public String getUsername() {
        return userName;
    }

    public void setPlan(){

    }

    public ArrayList<String> pullInfo(String userName){
        ReadFiles infoFile = new ReadFiles("UserInfo.txt");
        ArrayList<String> list = new ArrayList<>();
        try {
            for (String data : infoFile.openFile()) {
                list.add(data);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public String toString(){
        return userName;
    }

    
}
