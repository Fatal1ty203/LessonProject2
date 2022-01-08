package lessons.lesson7_3_abstract_Class.ex2_weapon;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        //+ Реализовать абстрактный класс Weapon с методом shot.
        // Создать два абстрактных подкласса: игровое оружие и боевое.
        // От каждого класса создать по два наследника. В мейне вызвать у всех наследников метод shot.


        List<Weapon> weapons = List.of(new Ak47(), new WaterPistol(), new Rogatka());

        System.out.println("Игровые оружия:");
        for(Weapon weapon : weapons){
            if(weapon instanceof GameWeapon){
                System.out.println(weapon);
            }
        }
        System.out.println("Реальные оружия:");
        for(Weapon weapon : weapons){
            if(weapon instanceof RealWeapon){
                System.out.println(weapon);
            }
        }




    }
}

abstract class Weapon{
    public abstract int shot();
}
abstract class RealWeapon extends Weapon{

}

class Ak47 extends RealWeapon{

    @Override
    public int shot() {
        return 100;
    }
}

abstract class GameWeapon extends Weapon{
}

class WaterPistol extends GameWeapon{

    @Override
    public int shot() {
        return 0;
    }
}

class Rogatka extends GameWeapon{
    public int shot(){
        return 1;
    }
}


