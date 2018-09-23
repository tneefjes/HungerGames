package Data.Contestant;

import Data.Item.Item;
import Data.Item.ItemType;

import java.util.Random;

public abstract class Contestant {
    private final String name;
    private final Gender gender;
    private ContestantType type;
    private int attackLevel;
    private int defenseLevel;
    private final int healthLevelOriginal;
    private int healthLevel;
    private Item attackItem;
    private Item defenseItem;

    // Constructor
    Contestant(Random random, NameGenerator nameGenerator, Gender gender) {
        name = nameGenerator.GenerateName(gender);
        this.gender = gender;
        attackLevel = 5 + random.nextInt(4);
        defenseLevel = 9 + random.nextInt(4);
        healthLevelOriginal = 40 + random.nextInt(21);
        healthLevel = healthLevelOriginal;
    }

    public String getName() {
        return name;
    }

    public ContestantType getType() {
        return type;
    }

    void setType(ContestantType type) {
        this.type = type;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public int getHealthLevelOriginal() {
        return healthLevelOriginal;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public Item getAttackItem() {
        return attackItem;
    }

    public Item getDefenseItem() {
        return defenseItem;
    }

    public void setItem(Item item) {
        if (item.getType() == ItemType.ATTACK) {
            attackItem = item;
            attackLevel += item.getBonus();
        } else {
            defenseItem = item;
            defenseLevel += item.getBonus();
        }
    }

    public boolean isAlive() {
        return (healthLevel > 0);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", gender: " + gender + ", type: " + type;
    }
}
