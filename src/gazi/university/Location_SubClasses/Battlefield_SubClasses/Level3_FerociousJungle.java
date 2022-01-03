package gazi.university.Location_SubClasses.Battlefield_SubClasses;

import gazi.university.Character;
import gazi.university.Enemy;
import gazi.university.Enemy_SubClasses.Poacher;
import gazi.university.Enemy_SubClasses.Vampire;
import gazi.university.Enemy_SubClasses.Zombie;
import gazi.university.Location_SubClasses.Battlefield;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level3_FerociousJungle extends Battlefield {
    private List<Enemy> listOfEnemies = new ArrayList<>();
    private static final int numberOfEnemies = 35;
    private int remainedNumber = numberOfEnemies;
    private static final int totalGoldAward = numberOfEnemies * 10;
    private int remainedGold = totalGoldAward;
    private static final int totalXpAward = numberOfEnemies * 5;
    private int remainedXpAward = totalXpAward;

    public Level3_FerociousJungle(Enemy enemy, Character character){
        super(enemy, character);
        character.setCurrentLocation(this.getClass().getSimpleName());
        spawnEnemy(enemy);
    }

    @Override
    protected void spawnEnemy(Enemy enemy) {
        int times = 0;
        String[] typeName = {"Poacher", "Vampire", "Zombie"};//Thinking about how to randomly pick up the level of enemy

        while(times != this.remainedNumber){
            Random random = new Random();
            int randomNumber = random.nextInt(typeName.length);
            switch (typeName[randomNumber]) { // this is called "Enhanced switch statement", guys. :)
                case "Poacher" -> {
                    Poacher poacher = new Poacher("Poacher1", 30, 3);
                    this.listOfEnemies.add(poacher);
                }
                case "Vampire" -> {
                    Vampire vampire = new Vampire("Vampire1", 30, 3);
                    this.listOfEnemies.add(vampire);
                }
                case "Zombie" -> {
                    Zombie zombie = new Zombie("Zombie1", 30, 3);
                    this.listOfEnemies.add(zombie);
                }
            }
            times++;
        }
    }

    @Override
    public List<Enemy> getListOfEnemy() {
        return this.listOfEnemies;
    }

    @Override
    public void killedEnemy(Character character, Enemy killedEnemy) {
        this.remainedNumber = numberOfEnemies - 1;
        this.listOfEnemies.remove(numberOfEnemies - remainedNumber);
    }

    @Override
    public int getRemainedEnemies() {
        return this.remainedNumber;
    }

    @Override
    protected void setRemainedEnemies(int remainedEnemies) { //Thinking about using this method in database management since
                                                             //in the flow of game this method should be secured from player.
        this.remainedNumber = remainedEnemies;
    }

    @Override
    public int getRemainedGold() {
        return 0;
    }

    @Override
    public void setRemainedGold(int totalGoldAward) {

    }

    @Override
    public int getRemainedExperience() {
        return 0;
    }

    @Override
    public void setRemainedExperience(int totalExperience) {

    }
}
