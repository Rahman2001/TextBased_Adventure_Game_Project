package gazi.university.Location_SubClasses.Battlefield_SubClasses;

import gazi.university.Character;
import gazi.university.Enemy;
import gazi.university.Enemy_SubClasses.Poacher;
import gazi.university.Enemy_SubClasses.Vampire;
import gazi.university.Enemy_SubClasses.Zombie;
import gazi.university.Location_SubClasses.Battlefield;

import java.util.List;
import java.util.Random;

public class Level2_DeadDesert extends Battlefield {
    private Enemy enemy;
    private final int numberOfEnemies = 4;
    private int remainedNumber = numberOfEnemies;

    // Constructor
    public Level2_DeadDesert(Character character){
        super(character);
        character.setCurrentLocation(this.getClass().getSimpleName());
        spawnEnemy();
    }

    @Override
    public boolean getLocation() {
        return true;
    }

    @Override
    protected void spawnEnemy() {
        this.enemy = new Enemy();
        Poacher poacher = new Poacher();
        List<Poacher> poachersLvl2 = poacher.getPoachersByLevel(2);
        Vampire vampire = new Vampire();
        List<Vampire> vampiresLvl2 = vampire.getVampiresByLevel(2);
        Zombie zombie = new Zombie();
        List<Zombie> zombiesByLvl2 = zombie.getZombiesByLevel(2);

        int[] array = new int[numberOfEnemies];
        for(int i = 0; i < numberOfEnemies; i++){
            if(i < poachersLvl2.size()){
                array[i] = i;
            }
            if(i >= poachersLvl2.size() && i < (poachersLvl2.size() + vampiresLvl2.size())){
                array[i] = i - poachersLvl2.size(); // returns the value starting from zero
            }
            if( i >= poachersLvl2.size() + vampiresLvl2.size() &&
                    i < poachersLvl2.size() + vampiresLvl2.size() + zombiesByLvl2.size()){
                array[i] = i - (poachersLvl2.size() + vampiresLvl2.size()); // returns the value starting from zero
            }
        }

        String[] typeName = {"Poacher", "Vampire", "Zombie"};
        int times = 0;
        while(times != this.remainedNumber){ // this guy generates random list of enemies from random enemy types
            Random random = new Random();
            Random randomIndex = new Random();
            int randomIndexForList = randomIndex.nextInt(numberOfEnemies);
            int randomNumber = random.nextInt(typeName.length);
            switch (typeName[randomNumber]) {
                case "Poacher" -> {
                    try {
                        this.enemy.addEnemyToList(poachersLvl2.get(array[randomIndexForList]));
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        try {
                            this.enemy.addEnemyToList(vampiresLvl2.get(array[randomIndexForList]));
                        } catch (ArrayIndexOutOfBoundsException exception) {
                            this.enemy.addEnemyToList(zombiesByLvl2.get(array[randomIndexForList]));
                        }
                    }
                }
                case "Vampire" -> {
                    this.enemy.addEnemyToList(vampiresLvl2.get(array[randomIndexForList]));
                }
                case "Zombie" -> {
                    this.enemy.addEnemyToList(zombiesByLvl2.get(array[randomIndexForList]));
                }
            }
            times++;
        }
    }

    @Override
    public Enemy getEnemy() {
        return null;
    }

    @Override
    public void killedEnemy(Character character, Enemy killedEnemy) {
        this.remainedNumber = numberOfEnemies - 1;
        this.enemy.getListOfEnemies().remove(numberOfEnemies - remainedNumber);
    }
}
