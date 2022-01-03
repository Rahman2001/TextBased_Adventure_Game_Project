package gazi.university;

import gazi.university.Character_SubClasses.Duelist;
import gazi.university.Character_SubClasses.Ranger;
import gazi.university.Character_SubClasses.Sorcerer;
import gazi.university.Equipment_SubClasses.Weapon;
import gazi.university.Equipment_SubClasses.Weapon_SubClasses.Axe;
import gazi.university.Equipment_SubClasses.Weapon_SubClasses.Sword;
import jdk.swing.interop.SwingInterOpUtils;
import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.*;


public class Main {

    public static void main(String[] args){
        // write your code here

        Weapon weapon = new Weapon();
        Sword sword = new Sword(23, 44);
        weapon.addWeaponToList(sword);
        Axe axe = new Axe(22, 13);
       weapon.addWeaponToList(axe);
       List<Weapon> weaponList = weapon.getListOfWeapons();
       System.out.println(weaponList.get(0).getClass().getSimpleName());
       System.out.println(weaponList.get(1).getClass().getSimpleName());
       Equipment equipment = new Equipment();
       equipment.addItemOfEquipment(weapon, null , null);
       weaponList = equipment.getListOfWeapons();
       System.out.println(weaponList.get(0).getClass().getSimpleName());

       // Let's start the game!
       // Please explain what you've added.
        // We can configure it. But first see something concrete.

        Scanner scan = new Scanner(System.in);
        System.out.println("Oyunumuza hoş geldiniz!");
        System.out.println("Size nasıl hitap edelim?");
        String initialName = scan.nextLine();
        System.out.println("Oyunumuzda üç adet karakter sınıfı bulunmaktadır:\n");
        System.out.println("1 - Duelist\n2 - Ranger\n3 - Sorcerer");
        System.out.println("Hangisini seçeceksiniz?");
        String characterChoice = scan.nextLine();
        Character player = new Character();
        if (characterChoice == "1"){
            player = new Duelist(initialName, 100, 100, 5, 3, 2, 50,null);
        }
        else if (characterChoice == "2"){
            player = new Ranger(initialName, 100, 100, 3, 4, 3, 50, null);
        }
        else if(characterChoice == "3"){
            player = new Sorcerer(initialName, 100, 100, 2,  3, 5,50, null);
        }
        // While loop or exception handling can be added above.
        // I realized that we need to add equipItem and unequipItem methods.
        System.out.println("İyi eğlenceler, " + player.getClass().getSimpleName() + initialName);
        System.out.println("");






    }






}
