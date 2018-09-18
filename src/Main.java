import java.util.Random;

public class Main {
    // The main method
    public static void main (String[] args) {
        System.out.println("Welcome to the Hunger Games!");

        // Create a Random class
        Random myRandom = new Random();

        // Create a player
        DistrictContestant DistrictCOntestant1 = new DistrictContestant(myRandom, "Male");

        // Print properties of the player
        System.out.println("The gender is " + DistrictCOntestant1.getGender());
        System.out.println("The attack level is " + DistrictCOntestant1.getAttackLevel());
    }
}
