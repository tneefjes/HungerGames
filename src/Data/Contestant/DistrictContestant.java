package Data.Contestant;

import java.util.Random;

public class DistrictContestant extends Contestant {
    private int defenseBonus = 1;

    public DistrictContestant(Random myRandom, NameGenerator nameGenerator, Gender gender) {
        super(myRandom, nameGenerator, gender);
        setType(ContestantType.DISTRICT);
        setDefenseLevel(getDefenseLevel() + defenseBonus);
    }
}
