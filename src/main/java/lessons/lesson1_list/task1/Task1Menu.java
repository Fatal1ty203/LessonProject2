package lessons.lesson1_list.task1;

import java.util.List;
import java.util.Scanner;

public class Task1Menu {


    public static void Start() {
        List<Object> list = CreatePhoneList.PH();
        Scanner scan = new Scanner(System.in);
        int input = 0;

        while (input!=4){
            System.out.println("1. Проверить на наличие в списке\n" +
                    "2. Удалить из списка\n" +
                    "3. Вывести все телефоны из списка\n" +
                    "4. Выход");

            input = scan.nextInt();
            if (input == 1){
                scan = new Scanner(System.in);
                System.out.println("Enter name");
                String name = scan.next();
                System.out.println("Enter memory");
                int memory = scan.nextInt();
                System.out.println("Enter color");
                String color = scan.next();

                boolean isExist = list.contains(new Phone(name,memory,color));
                    if (isExist){
                        System.out.println("Такой телефон есть");
                    }
                    else {
                        System.out.println("Такого телефона нет");
                    }
            }
            else if (input == 2){
                scan = new Scanner(System.in);
                System.out.println("Enter name");
                String name  = scan.next();
                System.out.println("Enter memory");
                int memory = scan.nextInt();
                System.out.println("Enter color");
                String color = scan.next();



                boolean isDelete = list.contains(new Phone(name,memory,color));

                Phone search = new Phone(name,memory,color);
                if (isDelete){
                    list.forEach(System.out::println);
                    list.remove(search);
                    System.out.println("После удаления");
                    list.forEach(System.out::println);
                }else {
                    System.out.println("Такого телефона нет, попробуйте еще раз");
                    return;
               }
            }
            else if (input == 3){
                list.forEach(System.out::println);
            }
            else if (input == 4){
                break;
            }

        }
    }
}
