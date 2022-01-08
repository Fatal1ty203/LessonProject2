package hw.homework8.RPG.Character.Class.FightService;

import hw.homework8.RPG.Character.Class.Character;

import java.util.List;
import java.util.Scanner;

public class Fight {
    Scanner scn = new Scanner(System.in);

    public Character target(List<Character> e){
        System.out.println(" Выберите цель для таргета: ");
        for (Character charr : e){
            System.out.println(charr.getName());
        }
        String name = scn.next();
        for (Character nChar : e){
            if (nChar.getName().equalsIgnoreCase(name)){
                return nChar;
            }
        }
        return e.get(1);
    }

    public void fight(Character character1, Character character2){
        System.out.println("Выберите умение, которое хотите применить на цель: " + character2.getName());
        System.out.println("1. " + character1.getBasicName() +"\n"+
                "2. " + character1.getSpecialName());
        int input = scn.nextInt();
        if (input == 1){
            character1.basicAtack(character2);
        }else if (input ==2){
            character1.specialAtack(character2);
        }
    }
}
