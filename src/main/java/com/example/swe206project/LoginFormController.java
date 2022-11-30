package com.example.swe206project;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginFormController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    public void clearUsernameInput(){
        username.clear();
    }
    @FXML
    public void clearPasswordInput(){
        password.clear();
    }


    
    

}




