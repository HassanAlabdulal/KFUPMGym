package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Trainee extends User implements Initializable{
    //Plan plan;
    protected String userName;
    protected String trainer;
    private ArrayList<Trainee> traineesList = new ArrayList<>();
    //protected static ArrayList<String> info = pullInfo(userName);
    //protected Trainee(){
    //    traineesList = (ArrayList<Trainee>) initilize("Trainee");
    //}

    protected Trainee(String userName){
        super(userName);
    }

    protected Trainee(String name, double height, double weight, String photo, String trainer, String userName){
        super(name, height, weight, photo);
        this.userName = userName;
        this.trainer = trainer;
    }

    public Trainee(String name, double height, double weight, String photo, String trainer) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainee");
        userName = user.username;
        this.trainer = trainer;
        save(name, height, weight, photo, trainer,"active");
    }

    public Trainee(String name, double height, double weight, String photo){
        this(name, height, weight, photo, "");
    }

    public void save(String name, double height, double weight, String photo, String trainer, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = "@" + userName + " " + name + " " +  height + " " + weight + " " + photo + " $" + trainer + " !" + status;
        try {
            writer.writeToFile(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveToBinary(String name, double height, double weight, String photo, String status){
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = userName + "! " + name + " " +  height + " " + weight + " " + photo + " !" + status;
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

    public String getTrainer(){
        return trainer;
    }

    public static String getTrainer(String userName){
        ReadFiles fileReader = new ReadFiles("UserInfo.txt");
        try {
            for (String element : fileReader.openFile()) {
                if((userName).equals(element.replaceAll("\\s\\p{ASCII}*$", ""))){
                    Pattern pattern = Pattern.compile("\\$\\p{Graph}*");
                    Matcher match = pattern.matcher(element);
                    if(match.find())
                        return match.group();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static ArrayList<String> pullInfo(String userName){ // returns name, height, weight, photo path in this exact order (0 -> 3)
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

    public String toString(){
        return userName;
    }


    
}
