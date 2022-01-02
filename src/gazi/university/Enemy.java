package gazi.university;

public abstract class Enemy implements ActiveAndPassive{

    private String name;
    private int health;
    private int level;

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

 

}
