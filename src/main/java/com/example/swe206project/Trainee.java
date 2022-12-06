package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public class Trainee extends User{
    //Plan plan;
    private String userName;

    public Trainee(String name, double height, double weight, String photo, boolean init_value){
        super(name, height, weight, photo);
    }

    public Trainee(String name, double height, double weight, String photo) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainee");
        userName = user.username;
        save(name, height, weight, photo, "active");
    }

    public void save(String name, double height, double weight, String photo, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = userName + "$ " + name + " " +  height + " " + weight + " " + photo + " !" + status;
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

    public static ArrayList<String> pullInfo(String userName){
        ReadFiles infoFile = new ReadFiles("UserInfo.txt");
        ArrayList<String> list = new ArrayList<>();
        try {
            int i = 0;
            for (String data : infoFile.openFile()) {
                if(i != 0 && userName.equals(data.replaceAll("\\s\\p{ASCII}*$", "")))
                for (String string : data.replaceAll("\\!\\p{Alpha}*$|\\p{Sc}\\p{Graph}*", "").split(" ")) {
                    if(string != null)
                    list.add(string);
                }
                i++;
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
