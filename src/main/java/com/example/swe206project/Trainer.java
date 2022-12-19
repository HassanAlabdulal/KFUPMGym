package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class Trainer<T> extends User implements Initializable{
    //Plan plan;
    protected String userName;
    private String speciality;
    protected ArrayList<Trainer> trainersList = new ArrayList<>();
    protected ArrayList<Trainee> traineesList = new ArrayList<>();
    protected ObservableList<Trainee> observableTraineesList = FXCollections.observableArrayList();
    protected ObservableList<Trainee> observableTraineesNoTrainerList = FXCollections.observableArrayList();
    //protected static ArrayList<String> info = pullInfo(userName);

    //protected Trainer(){
    //    trainersList = (ArrayList<Trainer>) initilize("Trainer");
    //}

    protected Trainer(String userName){
        super(userName);
        ArrayList<String> info = new ArrayList<>();
        info = pullInfo(userName);
        this.speciality = info.get(4);

        if(!getTraineesList(userName).isEmpty())
            traineesList = getTraineesList(userName);
        //this.traineesList = (ArrayList<T>) getTraineesList(userName);
        this.userName = userName;
    }

    protected Trainer(String name, double height, double weight, String photo, String speciality, String userName, ArrayList<Trainee> traineesList){
        super(name, height, weight, photo);
        this.speciality = speciality;
        this.userName = userName;
        //this.traineesList = (ArrayList<T>) traineesList;
        //for (Trainer trainer : trainersList) {
        //    if(trainer.getUsername().equals(this.userName))
        //        this.traineesList = trainer.traineesList;
        //}
    }

    public Trainer(String name, double height, double weight, String photo, String speciality) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainer");
        userName = user.username;
        this.speciality = speciality.replaceAll(" ", "-");
        for (Trainer trainer : trainersList) {
            if(trainer.getUsername().equals(this.userName))
                this.traineesList = trainer.traineesList;
        }
        save(name.replaceAll("\\s", "-"), height, weight, photo, "active");
    }

    public Trainer(String name, double height, double weight, String speciality){
        this(name, height, weight, "defaultPic.png", speciality);
    }

    public void save(String name, double height, double weight, String photo, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = "@" + userName + " " + name + " " +  height + " " + weight + " (" + photo + ") " + speciality + " " + traineesList.toString().replaceAll(" ", "") + " !" + status;
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
        return speciality.replaceAll("-", " ");
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality.replaceAll(" ", "-");
    }

    public ArrayList<Trainee> getTraineesList() {
        return (ArrayList<Trainee>) traineesList;
    }

    //public ObservableList<Trainee> getTraineesObservableList(){
    //    return (ObservableList<Trainee>) FXCollections.observableArrayList(this.traineesList);
    //}

    public ArrayList<Trainee> getTraineesList(String userName){
        ReadFiles read = new ReadFiles<>("UserInfo.txt");
        ArrayList<Trainee> list = new ArrayList<>();
        for(String trainee : read.fetch(userName, "\\[\\p{ASCII}*\\]").replaceAll("\\s|\\[|\\]", "").split(",")){
            if(!trainee.equals(""))
                list.add(new Trainee(trainee));
        }
        return list;
    }
    

    public void addTrainee(Trainee trainee){
        traineesList.add(trainee);
        trainee.setTrainer(userName);
        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        int line = r.getLine("@"+userName);
        String list = "[" + r.fetch(userName, "\\[\\p{ASCII}*\\]").replaceAll("\\s|\\[|\\]", "") + "," + trainee + "]";
        w.modifyLine(line, list, "\\[\\p{ASCII}*\\]");
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

    public ObservableList getObservableTraineesList() {
        for (Trainee object : traineesList) {
            if(!observableTraineesList.contains(object))
                observableTraineesList.add(object);
        }
        return observableTraineesList;
    }

    @Override
    public void setPhoto(String photo) {
        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        int line = r.getLine("@"+userName);
        w.modifyLine(line, photo, this.photo);
        this.photo = photo;
        
    }
    
}