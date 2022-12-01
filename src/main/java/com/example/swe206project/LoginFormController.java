package com.example.swe206project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class LoginFormController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Button lognBtn;

    @FXML
    public void clearUsernameInput(){
        username.clear();
    }
    @FXML
    public void clearPasswordInput(){
        password.clear();
    }

    @FXML
    public void checkAuthorization(MouseEvent event) {
        String cred = username.getText() + password.getText();
        ReadFiles fr = new ReadFiles("D:\\KFUPM\\Sophomore\\Term 221\\SWE 206\\project\\Phase 3\\Code\\SWE206-Project-main\\src\\main\\java\\com\\example\\swe206project\\UserAndPass.txt");
        Alert a = new Alert(AlertType.NONE);
        try {
            for (String el : fr.openFile()) {
                if(cred.equals(el)){
                    a.setAlertType(AlertType.CONFIRMATION);
                    a.show();
                }
                else{
                    a.setAlertType(AlertType.CONFIRMATION);
                    a.show();
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    


    
    

}




