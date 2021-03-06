package gazi.university.Location_SubClasses.Battlefield_SubClasses;

import gazi.university.Character;
import gazi.university.Enemy;
import gazi.university.Enemy_SubClasses.Poacher;
import gazi.university.Enemy_SubClasses.Vampire;
import gazi.university.Enemy_SubClasses.Zombie;
import gazi.university.Location_SubClasses.Battlefield;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Level1_CursedCave extends Battlefield {

    private Enemy enemy;
    private final int numberOfEnemies = 3;
    private int remainedNumber = numberOfEnemies;


    // Constructor
    public Level1_CursedCave(Character character){
        super(character);
        character.setCurrentLocation(this.getClass().getSimpleName()); //Let know where currently the character is.
        spawnEnemy();
    }

    @Override
    public boolean getLocation() {

        System.out.println("You're now in: " + this.getClass().getSimpleName());
        System.out.println("\nThere are " + numberOfEnemies + " enemies here.");

        boolean result = combat(numberOfEnemies);



        return result;
    }

    public boolean combat(int numberOfEnemies){
        for (int i = 0; i < numberOfEnemies; i++){
            getCharacter().levelUp();

            int defEnHealth = enemy.getHealth();

            while (getCharacter().getHealth() > 0 && enemy.getHealth() > 0){
                playerStats();
                System.out.println();
                enemyStats();
                System.out.println("<A>ttack directly\t|\tuse <S>kill\t|\t<R>un away");
                Scanner scan = new Scanner(System.in);
                String selection = scan.next();
                selection = selection.toUpperCase();
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException exception){
                }

                if (selection.equals("A"))
                {
                    System.out.println("You've attacked to the enemy!");
                    getCharacter().defaultAttack(enemy);


                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException exception){
                    }
                    if (enemy.getHealth() > 0){
                        System.out.println();
                        System.out.println("Enemy has attacked to you!");
                        getEnemy().defaultAttack(getCharacter());
                    }


                    }
                else if(selection.equals("S")){
                    System.out.println("You've used skill to the enemy!");
                    getCharacter().activeSkill(enemy);
                    try{
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException exception){
                    }
                    if (enemy.getHealth() > 0){
                        System.out.println();
                        System.out.println("Enemy has attacked to you!");
                        getEnemy().defaultAttack(getCharacter());
                    }
                }

                else {
                    System.out.println("Wrong input!");
                    //return false;

                }

            }
            if (enemy.getHealth() <= 0 && getCharacter().getHealth() > 0){
                System.out.println("You've defeated the enemy!");
                getCharacter().setMoney(getCharacter().getMoney() + enemy.getGold());
                System.out.println("Money gained: " + enemy.getGold() + " gold");
                getCharacter().setExperience(getCharacter().getExperience() + enemy.getXp());
                System.out.println("Xp gained: " + enemy.getXp());
                enemy.setHealth(defEnHealth);
                getCharacter().levelUp();

            }
            else if(getCharacter().getHealth() <= 0){
                return false;
            }


        }

        return true;
    }

    public void playerStats(){
        System.out.println("-Your values-\n");
        System.out.println(getCharacter().getName() + ", lvl " +getCharacter().getLvl());
        System.out.println("Life: " + getCharacter().getHealth());
        System.out.println("Mana: " + getCharacter().getMana());
        System.out.println("\nDamage: " + getCharacter().getDamage());
        System.out.println("\nDefence: " + getCharacter().getDefence());

    }

    public void enemyStats(){
        System.out.println("-Enemy values-\n");
        System.out.println(getEnemy().getClass().getSimpleName() + ", lvl" + getEnemy().getLevel());
        System.out.println("Life: " + getEnemy().getHealth());
        System.out.println("\nDamage: " + getEnemy().getDamage());
        System.out.println("\nDefence: " + getEnemy().getDefence());

    }

    @Override
    protected void spawnEnemy() { // this method generates list of Enemies in random order respective to the level fo battlefield
        this.enemy = new Enemy();
        Poacher poacher = new Poacher();
        List<Poacher> poachersLvl1 = poacher.getPoachersByLevel(1);
        Vampire vampire = new Vampire();
        List<Vampire> vampiresLvl1 = vampire.getVampiresByLevel(1);
        Zombie zombie = new Zombie();
        List<Zombie> zombiesByLvl1 = zombie.getZombiesByLevel(1);

        int[] array = new int[numberOfEnemies];
        for(int i = 0; i < numberOfEnemies; i++){ //
            if(i < poachersLvl1.size()){
                array[i] = i;
            }
            if(i >= poachersLvl1.size() && i < (poachersLvl1.size() + vampiresLvl1.size())){
                array[i] = i - poachersLvl1.size(); // returns the value starting from zero
            }
            if( i >= poachersLvl1.size() + vampiresLvl1.size() &&
                    i < poachersLvl1.size() + vampiresLvl1.size() + zombiesByLvl1.size()){
                array[i] = i - (poachersLvl1.size() + vampiresLvl1.size()); // returns the value starting from zero
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
                    this.enemy.addEnemyToList(poachersLvl1.get(array[randomIndexForList]));
                }
                case "Vampire" -> {
                    this.enemy.addEnemyToList(vampiresLvl1.get(array[randomIndexForList]));
                }
                case "Zombie" -> {
                    this.enemy.addEnemyToList(zombiesByLvl1.get(array[randomIndexForList]));
                }
            }
            times++;
        }
    }

    @Override
    public Enemy getEnemy() {
        return this.enemy;
    }

    @Override
    public void killedEnemy(Character character, Enemy killedEnemy) {
        this.remainedNumber = numberOfEnemies - 1;
        this.enemy.getListOfEnemies().remove(numberOfEnemies - remainedNumber);
    }
}
