import java.util.Random;

public class GamesController {

    // Setup method: creates the contestants.
    public Contestant[] setup() {
        // Create a random number generator
        Random myRandom = new Random();

       Contestant[] myContestants = new Contestant[24];
       for (int i = 0; i<24; i++) {
           // Create career contestants
           if (i<3) {
               myContestants[i] = new careerContestant(myRandom, "Male");
           } else if (i<6) {
               myContestants[i] = new careerContestant(myRandom, "Female");
           } else if (i<15) {
               myContestants[i] = new DistrictContestant(myRandom, "Male");
           } else {
               myContestants[i] = new DistrictContestant(myRandom, "Female");
           }
       }
       return myContestants;
    }

    // Start method: starts the Hunger Games!
    public void start(Contestant[] contestants) {
        System.out.println("Welcome to the Hunger Games!");

        System.out.println("The amount of survivors: " + amountOfSurvivors(contestants));
    }

    public int amountOfSurvivors (Contestant[] contestants) {
        int count = 0;
        for (Contestant contestant : contestants) {
            if (isAlive(contestant)==true) {
                count++;
            }
        }
        return count;
    }

    public boolean isAlive(Contestant contestant) {
        if (contestant.getHealthLevel() <= 0) {
            return false;
        } else {
            return true;
        }
    }

}
