package com.example.swe206project;
import java.io.IOException;
import java.lang.Math;
import java.time.Year;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDGenerator {
    private int id;

    public IDGenerator(String specifier, boolean check){
        String path = pathFinder(specifier);
        id = generate(path);
    }
    
    public IDGenerator(String name, String specifier){  // p for plan, s for session, trainee for trainee, trainer for trainer, u for user's plans
        String path = pathFinder(specifier);
        id = generate(path);
        save(id, name, path);
    }

    public IDGenerator(String specifier){
        this(null, specifier);
    }

    public IDGenerator(String name, String specifier, int id){ // in case of assign instead of generate
        String path = pathFinder(specifier); 
        if(findID(id, path))
            save(id, name, path);
        else
            System.out.println("the ID entered isnt valid or doesnt exist, try again.");
    }

    public static void save(int id, String name, String path) {
        WriteFiles writer = new WriteFiles(path, true);
        try {
            if(name == null)
                writer.writeToFile(Integer.toString(id));
            else{
                writer.writeToFile(name + " " + Integer.toString(id));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(int id, String path){
        save(id, "", path);
    }

    public static int generate(String path){
        String tmpID = Integer.toString((int) (Math.random() * 10000) + 1); 
        Year thisYear = Year.now();

        if(findID(Integer.valueOf(thisYear + tmpID), path))
            return generate(path);
        else
            return Integer.valueOf(thisYear + tmpID);
    }

    private String pathFinder(String specifier) {
        switch (specifier) {
            case "p": return "Plans.txt";
                
            case "s": return "Sessions.txt";

            case "u": return "UserPlans.txt";

            case "trainer": return "UserAndPass.txt";

            case "trainee": return "UserAndPass.txt";
            
            default:
                return null;
        }
       
    }

    public static boolean findID(int id, String path){

        ReadFiles fileReader = new ReadFiles(path);
        try {
            for (String element : fileReader.openFile()) {
                //if(id == Integer.valueOf(element.replaceAll("\\p{Alpha}|\\s", "")))
                //    return true;
                Pattern pattern = Pattern.compile(id+"");
                Matcher match = pattern.matcher(element);
                if(match.find())
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    public int getGenId(){
        return this.id;
    }










}
