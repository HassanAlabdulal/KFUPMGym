package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User implements Serializable{
    private int id;
    //private String userName; this cant be determined yet because of the type abstraction
    private String name;
    private String password;
    private double height;
    private double weight;
    private String photo;

    protected User(){

    }
    
    public User(String name, double height, double weight, String photo){
        this.name = name;
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
                if((userName).equals(element.replaceAll("\\s\\p{ASCII}*$", ""))){
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

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void editProfile(){

    }

    public abstract String toString();
    public abstract String getUsername();






}
