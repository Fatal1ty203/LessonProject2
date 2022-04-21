package hw.homework9.pie;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Ведите название пирога: ");
        String name = scn.nextLine();
        Pie pie = new Pie(name);
        int input = 0;
        while (input!=3){
            System.out.println("1. Добавить ингредиент\n" +
                    "2. Вывести все ингредиенты из пирога\n" +
                    "3. Выход");
            input = scn.nextInt();
            if (input == 1){
                String name1;
                double weight;
                System.out.println("Введите название ингредиента: ");
                scn.nextLine();
                name1 = scn.nextLine();
                System.out.println("Введите вес, в граммах: ");
                weight = scn.nextDouble();
                pie.addPieFilling(name1,weight);
            }else if (input == 2){
                System.out.println(pie);
            }
        }
    }
}
