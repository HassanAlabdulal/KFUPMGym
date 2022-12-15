package com.example.swe206project;

import java.io.IOException;
import java.io.FileReader;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernamePassGen {
    protected String username;
    private String password;

    public UsernamePassGen(){

    }

    public UsernamePassGen(String name, String specifier){
        username = generateUsername(name.replaceAll("\\s", ""));
        password = generatePassword();
        save(username, password, specifier);
    }

    private void save(String username, String password, String specifier) {
        WriteFiles writer = new WriteFiles("UserAndPass.txt", true);
        IDGenerator genId = new IDGenerator(specifier, false);
        int id = genId.getGenId();
        try {
                writer.writeToFile(username + " " + password +  "$ " + id + " !" + specifier);
                API.post(username, password, specifier);
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateUsername(String name){
        String tmpID = Integer.toString((int) (Math.random() * 10000) + 1); 
        name += tmpID;
        if(findUser(name))
            return generateUsername(name);
        else
            return name;
    }

    private String generatePassword(){
        Random r = new Random();
        String tmpPass = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 5; i++) 
            tmpPass += alphabet.charAt(r.nextInt(alphabet.length()));
         
        tmpPass += Integer.toString((int) (Math.random() * 10000) + 1);

        return tmpPass;
    }

    


    public static boolean findUser(String username){

        ReadFiles fileReader = new ReadFiles("UserAndPass.txt");
        try {
            for (String element : fileReader.openFile()) {
                if((username).equals(element.replaceAll("\\s\\p{ASCII}*$", "")))
                    return true;
                //Pattern pattern = Pattern.compile(username);
                //Matcher match = pattern.matcher(element);
                //if(match.find())
                //    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getUserID(String username){

        ReadFiles fileReader = new ReadFiles("UserAndPass.txt");
        try {
            for (String element : fileReader.openFile()) {
                if((username).equals(element.replaceAll("\\s\\p{ASCII}*$", ""))){
                    Pattern pattern = Pattern.compile("\\d{6,8}");
                    Matcher match = pattern.matcher(element);
                    match.find();
                    return Integer.valueOf(match.group());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        return 0;
    }












}
