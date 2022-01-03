package gazi.university;

import gazi.university.Equipment_SubClasses.Armor;
import gazi.university.Equipment_SubClasses.Potions;
import gazi.university.Equipment_SubClasses.Weapon;

public class Character implements ActiveAndPassive, Info{

    private String name;
    private int health;
    private int mana;
    private int strength;
    private int money;
    private Equipment equipment;
    // Added
    private int damage;
    private String currentLocation;

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }


    // Added variables
    // Dexterity and intelligence was forgotten.
    private int dexterity;
    private int intelligence;
    private int lvl = 0;
    private int experience = 0;

    private static final int xpToLvl2 = 50;
    private static final int xpToLvl3 = 150;
    private static final int xpToLvl4 = 350;
    private static final int xpToLvl5 = 650;

    // Getters and setters for my additional variables.
    public int getIntelligence() {
        return this.intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getLvl() {
        return this.lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getExperience() {
        return this.experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getDexterity() {
        return this.dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public Character(String name, int health, int mana, int strength, int dexterity, int intelligence,
                     int money, Equipment equipment){
        this.name = name;
        this.health = health;
        this.mana = mana;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.money = money;
        this.equipment = equipment;
    }
    // Adding another constructor for flexibility. And I needed it.
    public Character(){

    }
    public void levelUp(){
        // Let's make this changes in another method and call them.
        // In addition I think it'll be better to have if and else if cases for leveling up.
        // I'll be commiting and pushing them soon inshaallah.

        // Checking the level up process here.
        if (experience >= xpToLvl2 && lvl == 1)
        {
            levelUpChanges();
        }
        else if (experience >= xpToLvl3 && lvl == 2)
        {
            levelUpChanges();
        }
        else if (experience >= xpToLvl4 && lvl == 3)
        {
           levelUpChanges();
        }
        else if(experience >= xpToLvl5 && lvl == 4)
        {
           levelUpChanges();
        }





    }
    private void levelUpChanges(){
        lvl++;
        experience = 0;
        health += 20;
        mana += 20;
        strength += 5;
        money += 100;
    }

    // Please, modify your code in the methods. (Suggestion) How about if you create three buyItem methods according
    // its parameters type? e.g. buyItem(Weapon weapon) so on...
    public void buyItem(Equipment item){
        //Please, modify your code here. Note that an Equipment cannot be more than one
        // because it serves as a container of Weapon, Armor, Potions which have lists of their subclasses

        // Ok. As I know we can use instanceof here.
        // Waiting for other classes' update.
        if(item instanceof Weapon) {
            equipment.setWeaponToList(item);
            // ((Weapon) item) code generated automatically.
            setMoney(getMoney() - ((Weapon) item).getPrice());
        }
        else if(item instanceof Armor){
            equipment.setArmorToList(item);
            setMoney(getMoney() - );

        }
        else if(item instanceof Potions){
            equipment.setPotionsToList(item);
            setMoney(getMoney() - item.);
        }





//        else if(item instanceof Potions)
//            equipment.setPotionsToList(item);
    }

    public void sellItem(Equipment item){
        if(item instanceof Weapon) {
            equipment.(item);
        }
        else if(item instanceof Armor){
            equipment.setArmorToList(item);
        }
        else if(item instanceof Potions){
            equipment.setPotionsToList(item);
        }
        //inventory.getEquipmentList().remove(item);
    }

    public void usePotion(){
        // Thinking about adding a potion as parameter and removing it after usage.

    }

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
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public Equipment getEquipment() {
        return equipment;
    }
    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public void defaultAttack(Enemy enemy) {

    }

    @Override
    public void activeSkill(Enemy enemy) {

    }

    // Implementing and overriding methods from interfaces.


}