package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Trainer<T> extends User implements Initializable{
    //Plan plan;
    protected String userName;
    private String speciality;
    protected ArrayList<Trainer> trainersList = new ArrayList<>();
    protected ArrayList<T> traineesList = new ArrayList<>();
    //protected static ArrayList<String> info = pullInfo(userName);

    //protected Trainer(){
    //    trainersList = (ArrayList<Trainer>) initilize("Trainer");
    //}

    protected Trainer(String userName){
        super(userName);
        ArrayList<String> info = new ArrayList<>();
        info = pullInfo(userName);
        this.speciality = info.get(4);
        this.traineesList = (ArrayList<T>) getTraineeList(userName);
    }

    protected Trainer(String name, double height, double weight, String photo, String speciality, String userName, ArrayList<Trainee> traineesList){
        super(name, height, weight, photo);
        this.speciality = speciality;
        this.userName = userName;
        this.traineesList = (ArrayList<T>) traineesList;
        //for (Trainer trainer : trainersList) {
        //    if(trainer.getUsername().equals(this.userName))
        //        this.traineesList = trainer.traineesList;
        //}
    }

    public Trainer(String name, double height, double weight, String photo, String speciality) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainer");
        userName = user.username;
        this.speciality = speciality;
        for (Trainer trainer : trainersList) {
            if(trainer.getUsername().equals(this.userName))
                this.traineesList = trainer.traineesList;
        }
        save(name, height, weight, photo, "active");
    }

    public Trainer(String name, double height, double weight, String speciality){
        this(name, height, weight, "defaultPic.txt", speciality);
    }

    public void save(String name, double height, double weight, String photo, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = "@" + userName + " " + name + " " +  height + " " + weight + " " + photo + " " + speciality + " " + traineesList.toString().replaceAll(" ", "") + " !" + status;
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
    public static ArrayList<String> pullInfo(String userName){ // returns name, height, weight, photo path, speciality in this exact order (0 -> 4)
        ReadFiles infoFile = new ReadFiles("UserInfo.txt");
        ArrayList<String> list = new ArrayList<>();
        try {
            int i = 0;
            for (String data : infoFile.openFile()) {
                if(list.size() == 5)
                    break;
                if(i != 0 && userName.equals(data.replaceAll("\\s\\p{ASCII}*$|\\@", "")))  
                    for (String string : data.replaceAll("\\!\\p{Graph}*$|\\@\\p{Graph}*|\\p{Sc}", "").split(" ")) {
                        if(!string.equals(""))
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
        return (ArrayList<Trainee>) traineesList;
    }

    public ArrayList<String> getTraineeList(String userName){
        ReadFiles read = new ReadFiles<>("UserInfo.txt");
        ArrayList<String> list = new ArrayList<>();
        for(String workout : read.fetch(userName, "\\[\\p{ASCII}*\\]").replaceAll("\\s|\\[|\\]", "").split(","))
            list.add(workout);
        return list;
    }

    public void addTrainee(Trainee trainee){
        traineesList.add((T) trainee);
    }

    public String toString(){
        return userName;
    }

    public void assignPlan(Trainee trainee, Plan plan){
        trainee.setPlan(plan);
    }

    public void assignPlan(String userName, String planId){
        Trainee t = new Trainee(userName);
        t.setPlan(Integer.valueOf(planId));
    }
    
}