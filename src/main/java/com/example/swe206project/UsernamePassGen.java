package com.example.swe206project;

import java.io.IOException;

import java.time.Year;
import java.util.Random;

public class UsernamePassGen {
    private String username;
    private String password;

    public UsernamePassGen(String name){
        username = generateUsername(name);
        password = generatePassword();
        save(username, password);
    }

    private void save(String username, String password) {
        WriteFiles writer = new WriteFiles("UserAndPass.txt", true);
        try {
                writer.writeToFile(username + " " + password);
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

    


    public boolean findUser(String username){

        ReadFiles fileReader = new ReadFiles("UserAndPass.txt");
        try {
            for (String element : fileReader.openFile()) {
                if((username).equals(element.replaceAll("\\s\\p{ASCII}", "")))
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
