package com.example.swe206project;

import java.io.IOException;
import java.util.ArrayList;

public interface Initializable<T> {
    public default T initilize(String objectClassName){
        ArrayList<User> usersList = new ArrayList<>();
        ArrayList<Trainee> traineesList = new ArrayList<>();
        ArrayList<Trainer> trainersList = new ArrayList<>();       
        ReadFiles credfile = new ReadFiles("UserAndPass.txt");

        try {
            for (String user : credfile.openFile()) { 
                ArrayList<String> info = new ArrayList<>();
                String userName = user.replaceAll("\\s\\p{ASCII}*$", "");
                    switch (User.getType(userName)) {

                        case "trainee": 
                            info = Trainee.pullInfo(userName);
                            if(info.size() != 0 && !traineesList.toString().contains(userName)){
                                
                                if(info.size() == 5){
                                    Trainee trainee = new Trainee(info.get(0), Double.valueOf(info.get(1)), Double.valueOf(info.get(2)), info.get(3), Integer.valueOf(info.get(4).replaceAll("\\*", "")), "", userName);
                                    usersList.add(trainee);
                                    traineesList.add(trainee);
                                }
                                else{
                                    Trainee trainee = new Trainee(info.get(0), Double.valueOf(info.get(1)), Double.valueOf(info.get(2)), info.get(3), Integer.valueOf(info.get(4).replaceAll("\\*", "")), info.get(5), userName);
                                    usersList.add(trainee);
                                    traineesList.add(trainee);
                                }
                            }
                            break;
                    
                        case "trainer":
                            info = Trainer.pullInfo(userName); // here user should be userName
                            if(info.size() != 0){
                            String list = info.get(5);
                            ArrayList<Trainee> assignedTrainees = new ArrayList<>();
                            if(!list.equals("[]")){
                                for (String trainee : list.replaceAll("\\[|\\]", "").split(",")) {
                                    if(traineesList.toString().contains(trainee)){
                                        for (Trainee traineeObject : traineesList) {
                                            if(traineeObject.getUsername().equals(trainee))
                                                assignedTrainees.add(traineeObject);
                                        }
                                    }
                                    else{
                                        ArrayList<String> traineeInfo = Trainee.pullInfo(trainee);
                                        if(info.size() != 0){
                                            if(!traineesList.toString().contains(userName)){
                                                if(traineeInfo.size() == 5){
                                                    Trainee traineeObject = new Trainee(traineeInfo.get(0), Double.valueOf(traineeInfo.get(1)), Double.valueOf(traineeInfo.get(2)), traineeInfo.get(3), Integer.valueOf(info.get(4).replaceAll("\\*", "")), "", trainee);
                                                    usersList.add(traineeObject);
                                                    traineesList.add(traineeObject);
                                                    assignedTrainees.add(traineeObject);
                                                }
                                                else{
                                                    // Trainee traineeObject = new Trainee(traineeInfo.get(0), Double.valueOf(traineeInfo.get(1)), Double.valueOf(traineeInfo.get(2)), traineeInfo.get(3), Integer.valueOf(info.get(4).replaceAll("\\*", "")), info.get(5), trainee);
                                                    Trainee traineeObject = new Trainee(trainee);
                                                    usersList.add(traineeObject);
                                                    traineesList.add(traineeObject);
                                                    assignedTrainees.add(traineeObject);
                                                }
                                                
                                                
                                            }
                                        }
                                    }
                                }
                            }
                            Trainer trainer = new Trainer(info.get(0), Double.valueOf(info.get(1)), Double.valueOf(info.get(2)), info.get(3), info.get(4), userName, assignedTrainees);
                            usersList.add(trainer);
                            trainersList.add(trainer);
                            }
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
