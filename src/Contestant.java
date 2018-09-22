import java.util.Random;

public abstract class Contestant {
    private final String name;
    private final Gender gender;
    private TypeContestant type;
    private int attackLevel;
    private int defenseLevel;
    private final int healthLevelOriginal;
    private int healthLevel;
    private Item attackItem;
    private Item defenseItem;

    // Constructor
    public Contestant(Random random, NameGenerator nameGenerator,  Gender gender) {
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

    public Gender getGender() {
        return gender;
    }

    public TypeContestant getType() {
        return type;
    }

    public void setType(TypeContestant type) {
        this.type = type;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
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
        if (healthLevel > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", gender: " + gender + ", type: " + type;
    }
}
