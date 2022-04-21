package hw.homework.task5;

public class Main {
    public static void main(String[] args) {
        Huskar huskar = new Huskar(100, 5,3);
        huskar.print();
        System.out.println(huskar.attack());
        huskar.increaseLevel();
        huskar.print();
        HuskarUltimate huskarUltimate = huskar.transform();
        huskarUltimate.print();
        System.out.println(huskarUltimate.strengthAttack());
        System.out.println(huskarUltimate.magicAttack());
        huskarUltimate.print();

    }
}