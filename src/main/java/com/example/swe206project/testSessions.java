package com.example.swe206project;

import java.util.ArrayList;

public class testSessions {
    public static void main(String[] args) {
        //ArrayList<String> workoutList = new ArrayList<>();
        //workoutList.add("20225580");
        //workoutList.add("20229078");
        //workoutList.add("20226306");
        //Session s = new Session("Sunday", workoutList);
        //workoutList.remove(0);
        //Session s2 = new Session("Monday", workoutList);
        //System.out.println(s.id +" " +s.getDay() + " " + s.getWorkoutList());    
        //System.out.println(s.id +" "+s2.getDay() + " " + s2.getWorkoutList());
        //System.out.println("----------------------");
        System.out.println(Session.getDay(20229747)+ " "+ Session.getWorkoutList(20229747));

    }
}
