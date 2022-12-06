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
    private ObjectInputStream dataInput;
    
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
                match = p.matcher(pattern);
                if(match.find())
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

    public ArrayList<T> openBinaryFile(){
        ArrayList<T> listOfObject = new ArrayList<>();
        try { 
            dataInput = new ObjectInputStream(new FileInputStream(path));
            T object = (T) dataInput.readObject();
            do{
                listOfObject.add(object);
                object = (T) dataInput.readObject();
            }while(object != null);
            //dataInput.close();
            //dataInput.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listOfObject;
    }

}