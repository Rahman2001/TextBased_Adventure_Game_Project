package gazi.university;

import gazi.university.Location_SubClasses.Battlefield;
import gazi.university.Location_SubClasses.Battlefield_SubClasses.Level1_CursedCave;
import gazi.university.Location_SubClasses.Battlefield_SubClasses.Level2_DeadDesert;
import gazi.university.Location_SubClasses.Battlefield_SubClasses.Level3_FerociousJungle;
import gazi.university.Location_SubClasses.TownCenter;

public abstract class Location {

    private Character character;

    // Constructor
    public Location(Character character){
        this.character = character;
    }

    public TownCenter goToTownCenter(){ //redirects the character to the destination
     this.character.setCurrentLocation(TownCenter.class.getSimpleName());
       return new TownCenter(character);
    }

    public Battlefield goToBattlefield(int battlefieldLevel){
        if(battlefieldLevel == 1){
            this.character.setCurrentLocation(Level1_CursedCave.class.getSimpleName()); // get name of a class and set location of character
            return new Level1_CursedCave(this.character); //return this instance of this class with updated location of a character
        }else if(battlefieldLevel == 2){
            this.character.setCurrentLocation(Level2_DeadDesert.class.getSimpleName()); // get name of a class and set location of character
            return new Level2_DeadDesert(this.character); //return this instance of this class with updated location of a character
        }else if(battlefieldLevel == 3){
            this.character.setCurrentLocation(Level3_FerociousJungle.class.getSimpleName()); // get name of a class and set location of character
            return new Level3_FerociousJungle(this.character); //return this instance of this class with updated location of a character
        }
        return null;
    }

    // Ending control for now
    public abstract boolean getLocation();

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }
}
