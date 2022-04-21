package hw.homework2.task1;


import java.util.*;

public class Menu {
    public static void start() {
        List<Animal> animals = CreateAnimals.create();
        Scanner scan = new Scanner(System.in);
        int input = 0;
        while (input != 6) {
            System.out.println("1. Вывести всех животных (все характеристики)\n" +
                    "2. Вывести всех земноводных (все характеристики)\n" +
                    "3. Вывести млекопитающих (все характеристики)\n" +
                    "4. Найти самую старую черепаху (вывести ее имя) (через getClass)\n" +
                    "5. Вывести, что говорит каждое животное \n" +
                    "6. Выход");
            input = scan.nextInt();
            if (input == 1) {
                printAll(animals);
            }
            if (input == 2) {
                printAmphibians(animals);
            }
            if (input == 3) {
                printMammoth(animals);
            }
            if (input == 4) {
                getOldTurtle(animals);
            }
            if (input == 5){
                voiceAll(animals);
            }
        }
    }

    public static void printAll(List<Animal> animals) {
        animals.forEach(System.out::println);
    }

    public static void printAmphibians(List<Animal> amphibians) {
        for (Animal f : amphibians) {
            if (f instanceof Reptile) {
                System.out.println(f.toString());
            }
        }
    }

    public static void printMammoth(List<Animal> mammoth) {
        for (Animal f : mammoth) {
            if (f instanceof Mammoth) {
                System.out.println(f.toString());
            }
        }
    }

    public static void voiceAll(List<Animal> all){
        for (Animal f : all){
            System.out.println(f.getSay());
        }
    }

    public static void getOldTurtle(List<Animal> old) {
        List<Reptile> amphibians = new ArrayList<>();
        for (Animal f : old) {
            if (f instanceof Reptile) { //через getClass
                amphibians.add((Reptile) f);
            }
        }
        Comparator Asort = new Reptile.AgeSort();
        Collections.sort(amphibians, Asort);
        Collections.reverse(amphibians);
        System.out.println(amphibians.get(0).name);


    }
}
