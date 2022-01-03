package gazi.university.Enemy_SubClasses;

import gazi.university.Character;
import gazi.university.Enemy;

public class Poacher extends Enemy {
    public Poacher(String name, int health, int level){
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

    // Planning to make more changes here.

    public void defaultAttack(Character character) {
        character.setHealth(character.getHealth() - getDamage());
    }

}

