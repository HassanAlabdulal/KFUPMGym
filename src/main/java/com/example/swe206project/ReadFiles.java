package com.example.swe206project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFiles {
    private String path;

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

}