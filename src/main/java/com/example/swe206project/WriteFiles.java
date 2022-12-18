package com.example.swe206project;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Pattern;

public class WriteFiles<T> {
    private String path;
    private boolean append_to_file = false;
    private ObjectOutputStream dataOutput;

    public WriteFiles(String file_path) {
        path = file_path;
    }

    public WriteFiles(String file_path, boolean append_value) {
        path = file_path;
        append_to_file = append_value;
        //try {
        //    dataOutput = new ObjectOutputStream(new FileOutputStream(path, append_value));
        //} catch (FileNotFoundException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //} catch (IOException e) {
        //    // TODO Auto-generated catch block
        //    e.printStackTrace();
        //}
    }

    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("%s\n", textLine);
        print_line.close();
    }

    public void clearFile() throws IOException {
        FileWriter write = new FileWriter(path, false);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("");
        print_line.close();
    }

    public void modifyLine(int desiredLine, String data){ // replaces the desired line with the new data
        Path path = Paths.get(this.path);
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            lines.set(desiredLine-1, data);
            Files.write(path, lines, StandardCharsets.UTF_8);
        } 
        catch(IndexOutOfBoundsException e){
            try {
                writeToFile(data);
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }        
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void modifyLine(int desiredLine, String data, String pattern){ // replaces the matching pattern in the desired line with the new data
        Path path = Paths.get(this.path);
        try {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            String oldData = lines.get(desiredLine-1);
            String tmp = oldData.replaceAll(pattern, data);
            lines.set(desiredLine-1, oldData.replaceAll(pattern, data));
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeToBinaryFile(T object){
        try  {
            dataOutput = new ObjectOutputStream(new FileOutputStream(path, append_to_file)); 
            ReadFiles fileReader = new ReadFiles<>(path);
            if(!fileReader.openBinaryFile().contains(object))
                dataOutput.writeObject(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}