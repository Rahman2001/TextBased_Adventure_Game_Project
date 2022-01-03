package gazi.university.Character_SubClasses;

import gazi.university.Character;
import gazi.university.Enemy;
import gazi.university.Equipment;

public class Ranger extends Character {
    public Ranger(String name, int health, int mana, int str, int dex, int intel, int money, Equipment equipment){
        super(name, health, mana, str, dex, intel, money, equipment);
    }
    @Override
    public void defaultAttack(Enemy enemy) {
        enemy.setHealth(enemy.getHealth() - getDamage());
    }

    @Override
    public void activeSkill(Enemy enemy) {
        // Ranger's active skills damages opponnent normal attack and then heals same amount dealt damage.
        enemy.setHealth(enemy.getHealth() - getDamage());
        setHealth(getHealth() + getDamage());
        setMana(getMana() - 10);

    }

}
