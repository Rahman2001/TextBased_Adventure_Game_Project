package gazi.university.Enemy_SubClasses;

import gazi.university.Character;
import gazi.university.Enemy;

public class Vampire extends Enemy {
    public Vampire(String name, int health, int level){
        super(name, health, level);
    }
  
	@Override
	public int defaultAttack() {
		return 0;
	}

	@Override
	public int activeSkill(Object obj) {
		return 0;
	}

	@Override
	public int goldAward() {
		return 0;
	}

	@Override
	public int xpAward() {
		return 0;
	}




}
//=======

    public void defaultAttack(Character character) {
        character.setHealth(character.getHealth() - getDamage());
    }
}
