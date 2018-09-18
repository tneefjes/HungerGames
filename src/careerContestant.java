import java.util.Random;

public class careerContestant extends Contestant{

    private int attackBonus = 10;

    public careerContestant(Random myRandom, String gender) {
        super(myRandom, gender);
        setAttackLevel(getAttackLevel()+attackBonus);
        setItem(true);
    }
}

