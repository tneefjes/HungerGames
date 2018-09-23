package Data.Item;

import java.util.Random;

public class Shield extends Item {
    public Shield(Random random) {
        super(random);
        setType(ItemType.DEFENSE);
    }
}
