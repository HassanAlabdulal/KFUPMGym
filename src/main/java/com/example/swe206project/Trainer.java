package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public class Trainer extends User{
    //Plan plan;
    private String userName;
    private String speciality;
    private ArrayList<Trainee> traineesList = new ArrayList<>();

    public Trainer(String name, double height, double weight, String photo, String speciality, boolean init_value){
        super(name, height, weight, photo);
        this.speciality = speciality;
    }

    public Trainer(String name, double height, double weight, String photo, String speciality) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainer");
        userName = user.username;
        this.speciality = speciality;
        save(name, height, weight, photo, "active");
    }

    public Trainer(String name, double height, double weight, String speciality){
        this(name, height, weight, "defaultPic.txt", speciality);
    }

    public void save(String name, double height, double weight, String photo, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = userName + "$ " + name + " " +  height + " " + weight + " " + photo + " " + speciality + " !" + status + " " + traineesList;
        try {
            writer.writeToFile(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void save(){
        save(super.getName(), super.getHeight(), super.getHeight(), super.getPhoto(), "active");
    }


    @Override
    public String getUsername() {
        return userName;
    }

    //@Override
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public ArrayList<Trainee> getTraineesList() {
        return traineesList;
    }

    public void addTrainee(Trainee trainee){
        traineesList.add(trainee);
    }



    
}
