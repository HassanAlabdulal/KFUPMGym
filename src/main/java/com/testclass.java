package com;

public class testclass {
    public static void main(String[] args) {
        String workoutName = "squat";
        String targetedMucles = "legs";     
        int setsTarget =  3;
        int repititionTarget = 12;
        String steps = 
        "1. Stand with feet a little wider than hip width, toes facing front."+
        "2. Drive your hips back—bending at the knees and ankles and pressing your knees slightly open"+
        "3. Sit into a squat position while still keeping your heels and toes on the ground, chest up and shoulders back."+
        "4. Strive to eventually reach parallel, meaning knees are bent to a 90-degree angle."+
        "5. Press into your heels and straighten legs to return to a standing upright position.";

        Workouts workout = new Workouts(workoutName,  targetedMucles,  setsTarget, repititionTarget,  steps);
        workout.saveworkout( workoutName, targetedMucles, setsTarget, repititionTarget, steps);
    }
    
}
