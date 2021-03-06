package gazi.university.Equipment_SubClasses;
import gazi.university.Equipment;
import java.util.ArrayList;
import java.util.List;

public class Weapon extends Equipment {
    // We do not need any variable such as price, Damage, WeaponName because this class is consists of collection of its subclasses
    private  List<Weapon> listOfWeapons = new ArrayList<>();
    private int flatDamage;
    private int price;
    private String name;

    // Constructor
    public Weapon(String name){
        this.name = name;
    } //Why do we need to pass a name of a weapon from subclasses?
    public Weapon(){}

    @Override
    public List<Weapon> getListOfWeapons(){
        return listOfWeapons;
    }

    public void addWeaponToList(Weapon weapon){
        this.flatDamage = weapon.getFlatDamage();
        this.price = weapon.getPrice();
        this.name = weapon.getName();
        this.listOfWeapons.add(weapon);
    }
    public void removeWeaponFromList(Weapon weapon){ //Added the removal of item
        int index = (int) this.getListOfWeapons().stream().filter(x -> x.getFlatDamage() == weapon.getFlatDamage() && x.getPrice() == weapon.getPrice()
        && x.getClass().getSimpleName().equals(weapon.getClass().getSimpleName())).count();
        this.listOfWeapons.remove(index);
    }
    public String getName(){return this.name;}
    public int getFlatDamage(){
        return this.flatDamage;
    }
    public int getPrice(){
        return this.price;
    }

    public void setFlatDamage(int flatDamage) {
        this.flatDamage = flatDamage;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListOfWeapons(List<Weapon> listOfWeapons) {
        this.listOfWeapons = listOfWeapons;
    }
}


