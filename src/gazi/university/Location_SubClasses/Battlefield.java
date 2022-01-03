package gazi.university.Location_SubClasses;

import gazi.university.Enemy;
import gazi.university.Location;
import gazi.university.Character;

import java.util.List;

public abstract class Battlefield extends Location { //Since each battlefield's requirements vary from their level and
    // these methods are a MUST in each battlefield, we have
    //to make each method abstract and create their own logic.

    public Battlefield(Enemy enemy, Character character){
        super(character);
    }

    protected abstract void spawnEnemy(Enemy enemy); //this method is not public but protected because we should not engage
    //in object creation in process of the creation of game's flow. Instead, we will only distribute the created objects in the game


    // Deleted get and setEnemy method since we must define
    //certain amount and kind of enemies belonging to respective level of battlefield
    public abstract List<Enemy> getListOfEnemy();

    public abstract void killedEnemy(Character character, Enemy killedEnemy);

     //Deleted this method(get and set numberOfEnemies()) since the number
    //of enemies must be defined by default.

    protected abstract int getRemainedEnemies();

    protected abstract void setRemainedEnemies(int remainedEnemies);

    protected abstract int getRemainedGold();

    protected abstract void setRemainedGold(int remainedGold);

    protected abstract int getRemainedExperience();

    protected abstract void setRemainedExperience(int totalExperience);
}
