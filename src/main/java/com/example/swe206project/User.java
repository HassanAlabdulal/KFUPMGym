package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.net.ProtocolException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class User implements Serializable{
    private int id;
    //private String userName; this cant be determined yet because of the type abstraction
    protected String name;
    protected String password;
    protected double height;
    protected double weight;
    protected String photo;
    protected String status = "";
    
    protected User(){
//
    }

    protected User(String userName){
        String type = getType(userName);
        ArrayList<String> info;
        if(type.equals("trainee"))
        info = new ArrayList<>(Trainee.pullInfo(userName));
        else
        info = new ArrayList<>(Trainer.pullInfo(userName));
        this.name = info.get(0).replaceAll("-", " ");
        this.height = Double.valueOf(info.get(1));
        this.weight = Double.valueOf(info.get(2));
        ReadFiles r = new ReadFiles<>("UserInfo.txt");
        this.photo = r.fetch("@"+userName, "\\(\\p{ASCII}*\\)").replaceAll("\\(|\\)", "");
    
        if(isActive(userName))
            status = "active";
        else
            status = "not-active";
       
    }
    
    public User(String name, double height, double weight, String photo){
        if(name.contains("!#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"))
        this.name = name.replaceAll(" ", "-");
        this.height = height;
        this.weight = weight;
        this.photo = photo;
    }

    public User(String name, double height, double weight){
        this(name, height, weight, "defaultPic.png");
    }

    public static String getType(String userName){
        ReadFiles credfile = new ReadFiles("UserAndPass.txt");
        try {
            Pattern pattern = Pattern.compile("\\!\\p{Alpha}{7,10}");
            Matcher match = null;
            for (String user : credfile.openFile()) {
                if(userName.equals(user.replaceAll("\\s\\p{ASCII}*$", ""))){
                    match = pattern.matcher(user);
                    if(match.find())
                        break;
                }
            }
            return match.group().replaceAll("\\!", "");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public int getId(String userName){
        if((id = UsernamePassGen.getUserID(userName)) != 0)
            return id;
        System.out.println("The given username doesnt exist.");
        return 0;
    }


    public static boolean isActive(String userName){
        ReadFiles fileReader = new ReadFiles("UserInfo.txt");
        try {
            for (String element : fileReader.openFile()) {
                if(element.contains("@"+userName)){
                    Pattern pattern = Pattern.compile("not-active");
                    Matcher match = pattern.matcher(element);
                    return !match.find();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }
    
    public double getWeight() {
        return weight;
    }

    public String getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract void setPhoto(String photo);
        
    

    public void editProfile(){

    }

    public String getStatus() {
        return status;
    }

    public abstract String toString();
    public abstract String getUsername();






}
