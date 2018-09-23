package Data.Contestant;

import Data.Item.Shield;
import Data.Item.Sword;

import java.util.Random;

public class CareerContestant extends Contestant {

    private int attackBonus = 1;

    public CareerContestant(Random random, NameGenerator nameGenerator, Gender gender) {
        super(random, nameGenerator, gender);
        setType(ContestantType.CAREER);
        setAttackLevel(getAttackLevel() + attackBonus);
        if (random.nextInt(2) == 0) {
            setItem(new Sword(random));
        } else {
            setItem(new Shield(random));
        }
    }
}

