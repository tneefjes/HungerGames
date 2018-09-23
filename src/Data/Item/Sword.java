package Data.Item;

import java.util.Random;

public class Sword extends Item {
    public Sword(Random random) {
        super(random);
        setType(ItemType.ATTACK);
    }
}
