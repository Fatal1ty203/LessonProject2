package hw.homework11_set.TreeSet.Gun;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Gun> guns = new TreeSet<>();
        Scanner scn = new Scanner(System.in);

        guns.add(new Gun("DesertEagle",10));
        guns.add(new Gun("AK-47",35));
        guns.add(new Gun("Mini-Gun",20));
        guns.add(new Gun("Plasma-Gun",700));
        guns.add(new Gun("Bazuka",98));
        guns.add(new Gun("Rogatka",7));
        guns.add(new Gun("WaterPistol",3));
        guns.add(new Gun("LavaBlade",150));
        guns.add(new Gun("ZakonchilisIdei1",40));
        guns.add(new Gun("ZakonchilisIdei2",40));

        System.out.println(guns);
        System.out.println(guns.floor(new Gun(null,20)).getNameGun());
        System.out.println(guns.subSet(new Gun(null,scn.nextInt()), new Gun(null,scn.nextInt())));
    }
}
