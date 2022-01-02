package gazi.university.Enemy_SubClasses;

import gazi.university.Enemy;

public class Zombie extends Enemy {
    public Zombie(String name, int health, int level){
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
	public int passiveSkill() {
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