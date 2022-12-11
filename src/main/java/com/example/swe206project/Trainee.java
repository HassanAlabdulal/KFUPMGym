package com.example.swe206project;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Trainee extends User implements Initializable{
    protected Plan plan;
    protected String userName;
    protected String trainer;
    private ArrayList<Trainee> traineesList = new ArrayList<>();
    //protected static ArrayList<String> info = pullInfo(userName);
    //protected Trainee(){
    //    traineesList = (ArrayList<Trainee>) initilize("Trainee");
    //}

    protected Trainee(String userName){
        super(userName);
        plan = new Plan(Integer.valueOf(getPlan(userName)));
        this.trainer = getTrainer(userName);
        this.userName = userName;
    }

    protected Trainee(String name, double height, double weight, String photo, int planId, String trainer, String userName){
        super(name, height, weight, photo);
        plan = new Plan(planId);
        this.userName = userName;
        this.trainer = trainer;
    }

    public Trainee(String name, double height, double weight, String photo, int planId, String trainer) {
        super(name, height, weight, photo);
        UsernamePassGen user = new UsernamePassGen(name, "trainee");
        userName = user.username;
        this.trainer = trainer;
        plan = new Plan(planId);
        save(name, height, weight, photo, plan, trainer,"active");
    }

    public Trainee(String name, double height, double weight, String photo){
        this(name, height, weight, photo, 00000000, "");
    }

    public void save(String name, double height, double weight, String photo, Plan plan, String trainer, String status) {
        WriteFiles writer = new WriteFiles("UserInfo.txt", true);
        String data = "@" + userName + " " + name + " " +  height + " " + weight + " " + photo + " " + plan + " $" + trainer + " !" + status;
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

    public Plan getPlan(){
        return plan;
    }

    public static String getPlan(String userName){
        ReadFiles read = new ReadFiles<>("UserInfo.txt");
        return read.fetch(userName, "\\d{7,8}");
    }

    public void setPlan(Plan plan){
        ReadFiles r = new ReadFiles<>("Plans.txt");
        int line = r.getLine(this.plan.id+"");
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        w.modifyLine(line, plan.id+"", "\\d{7,8}");
        this.plan = plan;
    }

    public void setPlan(int planId){
        ReadFiles r = new ReadFiles<>("Plans.txt");
        int line = r.getLine(plan.id+"");
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        w.modifyLine(line, plan.id+"", "\\d{7,8}");
        plan = new Plan(planId);
    }

    public void setPlan(String userName, int planId){
        Trainee t = new Trainee(userName);
        ReadFiles r = new ReadFiles<>("Plans.txt");
        int line = r.getLine(t.plan.id+"");
        WriteFiles w = new WriteFiles<>("UserInfo.txt");
        w.modifyLine(line, plan.id+"", "\\d{7,8}");
        t.setPlan(planId);
    }

    public String getTrainer(){
        return trainer;
    }

    public static String getTrainer(String userName){
        ReadFiles fileReader = new ReadFiles("UserInfo.txt");
        try {
            for (String element : fileReader.openFile()) {
                if(element.contains(userName)){
                    Pattern pattern = Pattern.compile("\\$\\p{Graph}*");
                    Matcher match = pattern.matcher(element);
                    if(match.find())
                        return match.group().replaceAll("\\$", "");
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


    
}
