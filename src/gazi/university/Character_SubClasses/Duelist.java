package gazi.university.Character_SubClasses;


import gazi.university.Character;
import gazi.university.Enemy;
import gazi.university.Equipment;

public class Duelist extends Character {

    public Duelist(String name, int health, int mana, int str, int dex, int intel, int money, Equipment equipment){
        super(name, health, mana, str, dex, intel, money, equipment);
    }

    // Looking for the type of this method.
    // enemy.setHealth(enemy.getHealth() - getDamage());

    @Override
    public void defaultAttack(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - getDamage());
    }

    @Override
    public void activeSkill(Enemy enemy) {
        // Duelist's active skill deals double damage and increased damage by 2. (for now)
        enemy.setHealth(enemy.getHealth() - getDamage() * 2);
        setDamage(getDamage() + 2);
        setMana(getMana() - 10);
    }

}
