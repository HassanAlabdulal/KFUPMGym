package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Trainer extends User implements Initializable{
    //Plan plan;
    protected static String userName;
    private String speciality;
    protected ArrayList<Trainer> trainersList = new ArrayList<>();
    protected ArrayList<Trainee> traineesList = new ArrayList<>();
    protected static ArrayList<String> info = pullInfo(userName);

    protected Trainer(){
        trainersList = (ArrayList<Trainer>) initilize("Trainer");
    }

    protected Trainer(String userName){
        super(info.get(0), Double.valueOf(info.get(1)), Double.valueOf(info.get(2)), info.get(3));
        this.speciality = info.get(4);
    }

    protected Trainer(String name, double height, double weight, String photo, String speciality, String userName, ArrayList<Trainee> traineesList){
        super(name, height, weight, photo);
        this.speciality = speciality;
        this.userName = userName;
        for (Trainer trainer : trainersList) {
            if(trainer.getUsername().equals(this.userName))
                this.traineesList = trainer.traineesList;
        }
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
        String data = userName + "$ " + name + " " +  height + " " + weight + " " + photo + " " + speciality + " " + traineesList + " !" + status;
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
                if(list.size() == 5)
                    break;
                if(i != 0 && userName.equals(data.replaceAll("\\s\\p{ASCII}*$|\\p{Sc}", "")))
                    for (String string : data.replaceAll("\\!\\p{Alpha}*$|\\p{Sc}\\p{Graph}*", "").split(" ")) {
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
        return traineesList;
    }

    public void addTrainee(Trainee trainee){
        traineesList.add(trainee);
    }

    public String toString(){
        return userName;
    }



    
}
