package com.example.swe206project;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class User {
    private int id;
    //private String userName; this cant be determined yet because of the type abstraction
    private String name;
    private String password;
    private double height;
    private double weight;
    private String photo;
    
    public User(String name, double height, double weight, String photo){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.photo = photo;
        
    }

    public User(String name, double height, double weight){
        this(name, height, weight, "defaultPic.png");
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

    public static void setActivationStatus(String userName, boolean active){
        ReadFiles fileReader = new ReadFiles("UserInfo.txt");
        String status;
        if(active)
            status = "active";
        else
            status = "not-active";
            
        try {
            Path path = Paths.get("UserInfo.txt");
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int desiredLine = 1;          

            for (String element : fileReader.openFile()) {
                if((userName).equals(element.replaceAll("\\s\\p{ASCII}*$", ""))){
                    break;}
                desiredLine++;
            }

            String data = lines.get(desiredLine-1);
                if(isActive(userName))
                    data = data.replace("active", status);
                else
                    data = data.replace("not-active", status);
            lines.set(desiredLine-1, data);
            Files.write(path, lines, StandardCharsets.UTF_8);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
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


    public abstract String getUsername();
    public abstract ArrayList<String> pullInfo(String userName);




}
