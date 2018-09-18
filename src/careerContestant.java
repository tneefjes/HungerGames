import java.util.Random;

public class careerContestant extends Contestant{

    private int attackBonus = 10;

    public careerContestant(Random myRandom, String gender) {
        int baseLevel;

        if (gender=="Male") {
            baseLevel = 100;
        } else {
            baseLevel = 90;
        }

        setGender(gender);
        setAttackLevel(baseLevel+attackBonus+myRandom.nextGaussian()*10);
        setDefenseLevel(baseLevel+myRandom.nextGaussian()*10);
        setHealthLevel(baseLevel+myRandom.nextGaussian()*10);
        setItem(true);
    }
}

