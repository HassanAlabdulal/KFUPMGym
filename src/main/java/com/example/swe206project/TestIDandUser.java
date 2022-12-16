package com.example.swe206project;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class TestIDandUser {
    public static void main(String[] args) {
//        String User_getName = "mohammed3837"; // when we make the user we use getName() for this one
//       // for (int i = 0; i < 20; i++) {
//       //     IDGenerator userWithPlanID = new IDGenerator(User_getName, 'u');
//       // }
//       // IDGenerator planID = new IDGenerator('p'); 
//
//        UsernamePassGen user1 = new UsernamePassGen();
//
//        System.out.println(user1.findUser(User_getName));
//       System.out.println("its ID is: " + user1.getUserID(User_getName));
//          Trainee[] trainees = new Trainee[4];
//      for (int i = 0; i < 4; i++) {
//          trainees[i] = new Trainee("trainee#"+i, i+100, i+50);
//      }
//      Trainer trainer = new Trainer("trainer#1", 170, 70, "eating");
//      System.out.println("initially, the trainees for this guy are: "+trainer.getTraineesList());
//
//       for (int i = 0; i < trainees.length; i++) {
//           trainer.addTrainee(trainees[i]);
//       }
//
//      System.out.println("after adding, he has: "+ trainer.getTraineesList());
//      trainer.save();
//
//      System.out.println(trainees[3].getClass().getName());

   // WriteFiles w = new WriteFiles<>("UserInfo.dat", true);
      GymManager g = new GymManager("admin");
      System.out.println(g.usersList);

      ReadFiles read = new ReadFiles<>("UserAndPass.txt");
      for (User user : g.usersList) {
        if(user instanceof Trainer){
            Trainer x = (Trainer) user;
            System.out.println(x.pullInfo(x.userName));
            //System.out.println("posting the user: " + user.getUsername() + " with the password: " + read.fetch(x.userName, "\\p{Graph}*\\$").replaceAll("\\$", ""));
            //API.post(x.userName, read.fetch(x.userName, "\\p{Graph}*\\$").replaceAll("\\$", ""), "trainer");    
        }
        else if(user instanceof Trainee){
            Trainee x = (Trainee) user;
            System.out.println(x.pullInfo(x.userName));
            //System.out.println("posting the user: " + user.getUsername() + " with the password: " + read.fetch(x.userName, "\\p{Graph}*\\$").replaceAll("\\$", ""));
            //API.post(x.userName, read.fetch(x.userName, "\\p{Graph}\\$").replaceAll("\\$", ""), "trainee");
        }

      } 

      //Trainee t = new Trainee("ahmed abdulaal", 12, 342);
    //   System.out.println(t.pullInfo(t.userName));
   // System.out.println(Trainee.getTraineesNoTrainerList()); // testing observable lists
    //System.out.println(Workouts.getWorkoutsList());
    Trainee t = (Trainee) g.usersList.get(0);
    System.out.println(t.getObservableWorkoutsList());
    System.out.println(t.getObservableSessionsList());
    
        //for (User user : g.getUsersList()) {
        //    if(user instanceof Trainee)
        //        System.out.println(Trainee.pullInfo(user.toString()));
        //    else if(user instanceof Trainer)
        //        System.out.println(Trainer.pullInfo(user.toString()));
        //}
        
    }
}
