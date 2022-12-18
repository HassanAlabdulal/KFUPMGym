package com.example.swe206project;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFiles<T> {
    private String path;
    //private ObjectInputStream dataInput;
    
    public ReadFiles(String file_path) {
        path = file_path;
    }

    public String[] openFile() throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader textReader = new BufferedReader(fileReader);
        try (Scanner scan = new Scanner(textReader)) {
            String data = "";
            String currentLine;
            while((currentLine = textReader.readLine()) != null)
                data += currentLine + "\n";

            textReader.close();
            
            return data.split("\n");
        }
            
    }

    public int getLine(String pattern){
        try {
            int line = 1;
            Pattern p = Pattern.compile(pattern);
            Matcher match = null;
            for (String data : openFile()) {
                match = p.matcher(data);
                if(match.find() || pattern.equals(data))
                    break;
                else
                    line++;
            }
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String fetchLine(String identifier){
        ReadFiles reader = new ReadFiles(path);
        try {
            for(String line : reader.openFile()){
                if(line.contains(identifier)){
                    return line;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public int fetchLineNum(String identifier){
        ReadFiles reader = new ReadFiles(path);
        int num = 1;
        try {
            for(String line : reader.openFile()){
                if(line.contains(identifier)){
                    return num;
                }
                num++;
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return num;
    }

    public String fetch(String identifier, String patternToFetch){

        ReadFiles reader = new ReadFiles(path);
        Pattern pattern = Pattern.compile(patternToFetch);
        Matcher match = null;
        
        try {
            for(String line : reader.openFile()){
                if(line.contains(identifier)){
                    match = pattern.matcher(line);
                    if(match.find()){
                        return match.group();
                    }
                }
            
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
        
        
        
    }

    // public String fetch(String identifier, String identifier2, String patternToFetch){

    //     ReadFiles reader = new ReadFiles(path);
    //     Pattern pattern = Pattern.compile(patternToFetch);
    //     Matcher match = null;
        
    //     try {
    //         for(String line : reader.openFile()){
    //             if(line.contains(identifier) && line.contains(identifier2)){
    //                 match = pattern.matcher(line);
    //                 if(match.find()){
    //                     return match.group();
    //                 }
    //             }
            
    //         }
    //     } catch (IOException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }

    //     return null;
        
        
        
    // }

    public ArrayList<T> openBinaryFile(){
        ObjectInputStream dataInput;
        ArrayList<T> listOfObject = new ArrayList<>();
        try { 
            dataInput = new ObjectInputStream(new FileInputStream(path));
            T object = (T) dataInput.readObject();
            do{         
                listOfObject.add(object);
                object = (T) dataInput.readObject();
            }while(object != null || dataInput.available() > 0);
            //dataInput.close();
            //dataInput.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listOfObject;
    }

}