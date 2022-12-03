package com.example.swe206project;

public class TestIDandUser {
    public static void main(String[] args) {
        String User_getName = "ahmed"; // when we make the user we use getName() for this one
       // for (int i = 0; i < 20; i++) {
       //     IDGenerator userWithPlanID = new IDGenerator(User_getName, 'u');
       // }
       // IDGenerator planID = new IDGenerator('p'); 

        UsernamePassGen user1 = new UsernamePassGen(User_getName);
    }
}
