package com.example.swe206project;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    private String path;
    private boolean append_to_file = false;

    public WriteFile(String file_path) {
        path = file_path;
    }

    public WriteFile(String file_path, boolean append_value) {
        path = file_path;
        append_to_file = append_value;
    }

    public void writeToFile(String textLine) throws IOException {
        FileWriter write = new FileWriter(path, append_to_file);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("%s" + "%n", textLine);
        print_line.close();
    }

    public void clearFile() throws IOException {
        FileWriter write = new FileWriter(path, false);
        PrintWriter print_line = new PrintWriter(write);

        print_line.printf("");
        print_line.close();
    }

}