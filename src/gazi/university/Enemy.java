package gazi.university;

public abstract class Enemy implements ActiveAndPassive{

    private String name;
    private int health;
    private int level;

    // Added damage part.
    private int damage;
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



    public Enemy(String name, int health, int level){
        this.name = name;
        this.health = health;
        this.level = level;
    }

    public abstract int goldAward();
    public abstract int xpAward();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

//=======
    @Override
    public void defaultAttack(Enemy enemy) {

    }

    @Override
    public void activeSkill(Enemy enemy) {

    }

}
