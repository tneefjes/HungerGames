import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GamesController {
    private Random myRandom = new Random();
    private List<Contestant> contestants;

    private List<Contestant> createContestants(int numberOfContestants) {
       List<Contestant> returnList = new ArrayList<Contestant>();
       int numberDistrictContestants = (int)((numberOfContestants * 0.75) + 0.5);
       int numberCareerContestant = numberOfContestants - numberDistrictContestants;
       NameGenerator myNameGenerator = new NameGenerator();

       for(int i = 0; i < numberDistrictContestants; i++) {
           if (i % 2 == 0) {
               returnList.add(new DistrictContestant(myRandom, myNameGenerator, Gender.MALE));
           } else {
               returnList.add(new DistrictContestant(myRandom, myNameGenerator, Gender.FEMALE));
           }
       }
        for(int i = 0; i < numberCareerContestant; i++) {
            if (i % 2 == 0) {
                returnList.add(new CareerContestant(myRandom, myNameGenerator, Gender.MALE));
            } else {
                returnList.add(new CareerContestant(myRandom, myNameGenerator, Gender.FEMALE));
            }
        }
        return returnList;
    }

    public void start() {
        int numberOfContestants = 24;
        contestants = createContestants(numberOfContestants);

        System.out.println("\nWELCOME TO THE HUNGER GAMES!");
        System.out.println("\nThe following contestants have been selected:");
        for (Contestant contestant : contestants) {
            System.out.println(contestant);
        }
        int day = 1;
        do {
            System.out.println("\nDay" + day);
            Collections.shuffle(contestants);

            Contestant contestant1;
            Contestant contestant2;
            for (int i = 0; i < contestants.size() - 1; i++) {
                contestant1 = contestants.get(i);
                for (int j = (i + 1); j < contestants.size(); j++) {
                    contestant2 = contestants.get(j);
                    if (isEncounter(myRandom)) {
                        System.out.println("\n" + contestant1.getName() + " and " + contestant2.getName() + " meet!");
                        contestants.remove(loser(contestant1, contestant2));
                    }
                }
            }
            resetHealth(contestants);
            itemAssigner(contestants, myRandom);
            day++;
        } while (contestants.size() > 1);
        System.out.println("\n" + contestants.get(0).getName() + "(" + contestants.get(0).getType() + ")" + " is the winner of the Hunger Games!");
    }

    public boolean isEncounter(Random random) {
        return (random.nextInt(8) == 0) ? true : false;
    }

    private Contestant loser(Contestant contestant1, Contestant contestant2) {
        Contestant attacker;
        Contestant defender;
        if (Math.random()<0.5) {
            attacker = contestant1;
            defender = contestant2;
        } else {
            attacker = contestant2;
            defender = contestant1;
        }

        int attackStrength;
        do {
            attack(attacker, defender);
            if (defender.isAlive()) {
                attack(defender, attacker);
                if (!attacker.isAlive()) {
                    System.out.println(defender.getName() + " won the fight!");
                    return attacker;
                }
            } else {
                System.out.println(attacker.getName() + " won the fight!");
                return defender;
            }
        } while (true);
    }

    private void attack(Contestant attacker, Contestant defender) {
        int attackStrength = attacker.getAttackLevel() + myRandom.nextInt(12);
        if (attackStrength > (defender.getDefenseLevel())) {
            defender.setHealthLevel(defender.getHealthLevel() - attackStrength);
        }
    }

    private void resetHealth(List<Contestant> contestants) {
        for (Contestant contestant : contestants) {
            contestant.setHealthLevel(contestant.getHealthLevelOriginal());
        }
    }

    private void itemAssigner(List<Contestant> contestants, Random random) {
        Item newItem;

        for (Contestant contestant : contestants) {
            if (findsItem(myRandom)) {
                newItem = itemGenerator(random);
                if (isImprovement(contestant, newItem)) {
                    System.out.println("\n" + contestant.getName() + " found a new item of type: " + newItem.getType());
                    contestant.setItem(newItem);
                }
            }
        }
    }

    private Item itemGenerator(Random random) {
        if (random.nextInt(2) == 0 ) {
            return new Sword(random);
        } else {
            return new Shield(random);
        }
    }

    private boolean findsItem(Random random) {
        return (random.nextInt(4) == 0) ? true : false;
    }

    private boolean isImprovement(Contestant contestant, Item item) {
        if (item.getType() == ItemType.ATTACK) {
            if (contestant.getAttackItem() != null) {
                return (contestant.getAttackItem().getBonus() < item.getBonus()) ? true : false;
            } else {
                return true;
            }
        } else {
            if (contestant.getDefenseItem() != null) {
                return (contestant.getDefenseItem().getBonus() < item.getBonus()) ? true : false;
            } else {
                return true;
            }
        }
    }
}
