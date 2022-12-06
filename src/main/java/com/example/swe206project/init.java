package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public interface init<T> {
    public default T initilize(String objectClassName){
        ArrayList<User> usersList = new ArrayList<>();
        ArrayList<Trainee> traineesList = new ArrayList<>();
        ArrayList<Trainer> trainersList = new ArrayList<>();       
        ReadFiles credfile = new ReadFiles("UserAndPass.txt");

        try {
            for (String user : credfile.openFile()) { 
                ArrayList<String> info = new ArrayList<>();
                    switch (User.getType(user.replaceAll("\\s\\p{ASCII}*$", ""))) {
                        case "trainee": 
                            info = Trainee.pullInfo(user);
                            Trainee trainee = new Trainee(info.get(0), Double.valueOf(info.get(1)), Double.valueOf(info.get(2)), info.get(3), true);
                            usersList.add(trainee);
                            traineesList.add(trainee);
                            break;
                    
                        case "trainer":
                             info = Trainer.pullInfo(user); // here user should be userName
                             Trainer trainer = new Trainer(info.get(0), Double.valueOf(info.get(1)), Double.valueOf(info.get(2)), info.get(3), info.get(4), true);
                            usersList.add(trainer);
                            trainersList.add(trainer);
                            break;

                        case "GymManager":
                            break;

                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        switch (objectClassName) {
            case "Trainee": 
                return (T) traineesList;
                    
            case "Trainer":
                return (T) trainersList;

            case "GymManager":
                return (T) usersList;

            default:
                return null;
        }
    }
}
