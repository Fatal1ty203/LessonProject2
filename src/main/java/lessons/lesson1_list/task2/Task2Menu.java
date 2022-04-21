package lessons.lesson1_list.task2;

import java.util.*;

public class Task2Menu {
    public static void start() {
        List<Object> list = CreateFruit.create();
        Scanner scan = new Scanner(System.in);
        int input = 0;

        while (input != 5){
            System.out.println("1. Вывести все фрукты\n" +
                    "2. Добавить фрукт\n" +
                    "3. Найти название самого полезного фрукта (если их несколько, то первый попавшийся)\n" +
                    "4. Удалить самый неполезный фрукт (если их несколько, то первый попавшийся)\n" +
                    "5. Выход");
            input = scan.nextInt();
            if (input == 1){
                list.forEach(System.out::println);
            }
            if (input == 2){
                scan = new Scanner(System.in);
                System.out.println("Enter name");
                String name = scan.nextLine();
                System.out.println("Enter profit");
                int profit = scan.nextInt();
                System.out.println("Enter price");
                int price = scan.nextInt();

                Fruit newFruit = new Fruit(name,profit,price);
                list.add(newFruit);
            }
            if (input == 3){
                //Arrays.sort(list, Fruit.ProfitComparator);
                //System.out.println(list);
            }
        }

    }
}
