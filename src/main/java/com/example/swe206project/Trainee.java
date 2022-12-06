package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Trainee extends User implements Initializable{
    //Plan plan;
    private String userName;
    private ArrayList<Trainee> traineesList = new ArrayList<>();

    protected Trainee(){
        traineesList = (ArrayList<Trainee>) initilize("Trainee");
    }

    protected Trainee(String name, double height, double weight, String photo, String userName){
        super(name, height, weight, photo);
        this.userName = userName;
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
                if(list.size() == 4)
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

    public String toString(){
        return userName;
    }


    
}
