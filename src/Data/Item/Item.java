package Data.Item;

import java.util.Random;

public abstract class Item {
    private ItemType type;
    private final int bonus;

    Item(Random random) {
        bonus = 1 + random.nextInt(2);
    }

    public ItemType getType() {
        return type;
    }

    void setType(ItemType type) {
        this.type = type;
    }

    public int getBonus() {
        return bonus;
    }
}
