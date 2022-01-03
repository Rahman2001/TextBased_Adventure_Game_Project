package gazi.university.Character_SubClasses;

import gazi.university.Character;
import gazi.university.Enemy;
import gazi.university.Equipment;

public class Sorcerer extends Character {
    public Sorcerer(String name, int health, int mana, int str, int dex, int intel, int money, Equipment equipment){
        super(name, health, mana, str, dex, intel, money, equipment);
    }
    @Override
    public void defaultAttack(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - getDamage());
    }

    @Override
    public void activeSkill(Enemy enemy) {
        // Sorcerer's active skill deals normal damage and then steals 2 dmg from enemy.
        enemy.setHealth(enemy.getHealth() - getDamage());
        enemy.setDamage(enemy.getDamage() - 2);
        setDamage(getDamage() + 2);
        setMana(getMana() - 10);

    }

}
