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

        // Let to contestants meet to test!
        battle(contestants[0], contestants[1]);

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

    public boolean isEncounter() {
        if (Math.random()<0.25) {
            return true;
        }
        else {
            return false;
        }
    }

    public void battle(Contestant contestant1, Contestant contestant2) {
        Contestant attacker;
        Contestant defender;

        if (Math.random()<0.5) {
            attacker = contestant1;
            defender = contestant2;
        } else {
            attacker = contestant1;
            defender = contestant2;

        }

        double attackerHealth = attacker.getHealthLevel();
        double attackerAttack = attacker.getAttackLevel();

        double defenderHealth = defender.getHealthLevel();
        double defenderAttack = defender.getAttackLevel();

        boolean winner=false;
        do {
            defenderHealth -= attackerAttack/10;
            if (defenderHealth>0) {
                attackerHealth -= defenderAttack;
            }

            if (defenderHealth<0 || attackerHealth<0) {
                winner = true;
            }
        } while (winner==false);
        attacker.setHealthLevel(attackerHealth);
        defender.setHealthLevel(defenderHealth);
    }
}
