package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Trainee extends User implements Initializable{
    protected Plan plan;
    protected String userName;
    protected String trainer;
    // protected static ArrayList<Trainee> traineesList = new ArrayList<>();
    protected ObservableList<Trainee> observableTraineesList = FXCollections.observableArrayList();
    protected ObservableList<Workouts> observableWorkoutsList = FXCollections.observableArrayList(); 
    protected ObservableList<Session> observableSessionsList = FXCollections.observableArrayList();
    
    //protected static ArrayList<String> info = pullInfo(userName);
    protected Trainee(){
        super();
    //    traineesList = (ArrayList<Trainee>) initilize("Trainee");
    }

    protected Trainee(String userName){
        super(userName);
        plan = new Plan(Integer.valueOf(getPlan(userName)));
        this.trainer = getTrainer(userName);
        this.userName = userName;
    }

    protected Trainee(String name, double height, double weight, String photo, int planId, String trainer, String userName){
        super(name, height, weight, photo);
        plan = new Plan(Integer.valueOf(planId));
        this.userName = userName;
        this.trainer = trainer;
    }

    public Trainee(String name, double height, double weight, String photo, int planId, String trainer) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainee");
        userName = user.username;
        this.trainer = trainer;
        plan = new Plan(Integer.valueOf(planId));
        save(name.replaceAll("\\s", "-"), height, weight, photo, plan.id, trainer,"active");
    }

    public Trainee(String name, double height, double weight, String photo){
        this(name, height, weight, photo, 0, "");
    }

    public void save(String name, double height, double weight, String photo, int plan, String trainer, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = "@" + userName + " " + name + " " +  height + " " + weight + " (" + photo + ") *" + plan + " ?" + trainer + " !" + status;
        try {
            writer.writeToFile(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // public void saveToBinary(String name, double height, double weight, String photo, String status){
    //     WriteFiles writer = new WriteFiles("UserInfo.txt", true);
    //     String data = userName + "! " + name + " " +  height + " " + weight + " " + photo + " !" + status;
    // }

    public Trainee(String name, double height, double weight){
        this(name, height, weight, "defaultPic.png");
    }


    @Override
    public String getUsername() {
        return userName;
    }

    public Plan getPlan(){
        return plan;
    }

    public static String getPlan(String userName){
        ReadFiles read = new ReadFiles<>("UserInfo.txt");
        return read.fetch(userName, "\\*\\d{1,8}").replaceAll("\\*", "");
    }

    public void setPlan(Plan plan){
        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        int line = r.getLine("@"+userName);
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        w.modifyLine(line, "*"+plan.id, "\\*\\d{1,8}");

        ReadFiles readProgress = new ReadFiles<>("Progress.txt");
        WriteFiles writeProgress = new WriteFiles<>("Progress.txt", true);
        for (Session session : plan.sessionsList) {
            //String workoutData = "";
            //String tmp = session.workoutList+"";

            String data = userName + " " + session.day + " " + session.id;
                if(this.plan.id != 0){
                    int line2 = readProgress.getLine(userName + " " + session.day + " " + session.id);
                    writeProgress.modifyLine(line2, data + " " + session.getObservableWorkoutsList());
                }
                else{
                 try {
                    this.plan = plan;
                    data += " [ ";
                    for (Workouts workout : session.getObservableWorkoutsList()) {
                        data += workout.getId() + " !" + 0 + " ?" + 0 + " *" + 0 + ", ";
                    }
                    data += "]";
                    writeProgress.writeToFile(data);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }   
                }
            
             
            
        }
        this.plan = plan;
    }

    public void deletePlan(){
        ReadFiles readProgress = new ReadFiles<>("Progress.txt");
        WriteFiles writeProgress = new WriteFiles<>("Progress.txt", true);
        for (Session session : plan.sessionsList) {
            if(!(readProgress.fetchLine(userName) == null)){
                int line = readProgress.getLine(userName + " " + session);
                writeProgress.modifyLine(line, "");
            }
        }

        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        int line = r.getLine("@"+userName);
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        w.modifyLine(line, "*"+0, "\\*\\d{1,8}");

    }

    public void setPlan(int planId){
        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        int line = r.getLine("@"+userName);
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        w.modifyLine(line, "*"+planId, "\\*\\d{1,8}");
        plan = new Plan(planId);
    }

    public void setPlan(String userName, int planId){
        // Trainee t = new Trainee(userName);
        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        int line = r.getLine("@"+userName);
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        w.modifyLine(line, "*"+planId, "\\*\\d{1,8}");
        // t.setPlan(planId);
    }

    public String getTrainer(){
        return trainer;
    }

    public void setTrainer(String trainer){
        this.trainer = trainer;
        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        int line = r.getLine("@"+userName);
        w.modifyLine(line, "?"+trainer, "\\?\\p{Graph}*|\\?\\s");
    }

    public static String getTrainer(String userName){
        ReadFiles fileReader = new ReadFiles("UserInfo.txt");
        try {
            for (String element : fileReader.openFile()) {
                if(element.contains(userName)){
                    Pattern pattern = Pattern.compile("\\?\\p{Graph}*");
                    Matcher match = pattern.matcher(element);
                    if(match.find())
                        return match.group().replaceAll("\\?", "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return "";
    }

    public static ArrayList<String> pullInfo(String userName){ // returns name, height, weight, photo path in this exact order (0 -> 3)
        ReadFiles infoFile = new ReadFiles("UserInfo.txt");
        ArrayList<String> list = new ArrayList<>();
        try {
            int i = 0;
            for (String data : infoFile.openFile()) {
                if(list.size() == 6)
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

    public String toString(){
        return userName;
    }
    

    public  ObservableList<Trainee> getTraineesNoTrainerList() {
        ReadFiles reader = new ReadFiles<>("UserInfo.txt");
        try {
            for (String userInfo : reader.openFile()) {
                Pattern pattern = Pattern.compile("\\?\\p{Graph}*");
                Matcher match = pattern.matcher(userInfo);
                if(match.find() && match.group().equals("?")){
                    Trainee trainee = new Trainee(userInfo.replaceAll("\\s\\p{ASCII}*$|\\@", ""));
                    if(!observableTraineesList.contains(trainee))
                        observableTraineesList.add(trainee);
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return observableTraineesList;
    }

    public ObservableList<Workouts> getObservableWorkoutsList() {
        for (Session session : plan.sessionsList) {
            for (Workouts workout : session.workoutList) {
                if(!observableWorkoutsList.contains(workout))
                    observableWorkoutsList.add(workout);  
            }
        }
        return observableWorkoutsList;
    }


    public ObservableList<Session> getObservableSessionsList() {
        for (Session session : plan.sessionsList) {
            if(!observableSessionsList.contains(session))
            observableSessionsList.add(session);  
            
        }
        return observableSessionsList;
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
