package com.example.swe206project;
import java.io.IOException;
import java.lang.Math;
import java.time.Year;
public class IDGenerator<T> {
    private int id;
    
    public IDGenerator(String name, char specifier){  // p for plan, s for session, t for trainee, r for trainer, u for user's plans
        String path = pathFinder(specifier);
        id = generate(path);
        save(id, name, path);
    }

    public IDGenerator(char specifier){
        this(null, specifier);
    }

    public IDGenerator(String name, char specifier, int id){ // in case of assign instead of generate
        String path = pathFinder(specifier); 
        if(findID(id, path))
            save(id, name, path);
        else
            System.out.println("the ID entered isnt valid or doesnt exist, try again.");
    }

    private void save(int id, String name, String path) {
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

    private int generate(String path){
        String tmpID = Integer.toString((int) (Math.random() * 10000) + 1); 
        Year thisYear = Year.now();

        if(findID(Integer.valueOf(thisYear + tmpID), path))
            return generate(path);
        else
            return Integer.valueOf(thisYear + tmpID);
    }

    private String pathFinder(char specifier) {
        switch (specifier) {
            case 'p': return "Plans.txt";
                
            case 's': return "Sessions.txt";

            case 'u': return "UserPlans.txt";

            case 't': return "trainees.txt";

            case 'r': return "trainers.txt";
            
            default:
                return null;
        }
       
    }

    public boolean findID(int id, String path){

        ReadFiles fileReader = new ReadFiles(path);
        try {
            for (String element : fileReader.openFile()) {
                if(id == Integer.valueOf(element.replaceAll("\\p{Alpha}|\\s", "")))
                    return true;
                else
                    return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }










}
