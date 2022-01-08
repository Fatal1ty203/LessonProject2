package hw.homework6_String_operations.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void start() {
        List<SocialProfile> arr = new ArrayList<>();
        int input = 0;
        while (input != 4) {
            System.out.println("1. Добавить профиль в список(;)\n" +
                    "2. Удалить профиль из списка\n" +
                    "3. Вывести все профили (использовать toString, строку формировать через StringBuilder)\n" +
                    "4. Выход");
            input = new Scanner(System.in).nextInt();
            if (input == 1) {
                System.out.println("Введите данные профиля: ");
                String scn = new Scanner(System.in).nextLine().trim();
                String[] str = scn.split(";");
                for (int i = 0; i < str.length; i++) {
                    str[i] = str[i].trim();
                }
                System.out.println(str.length);
                if (str.length == 2) {
                    arr.add(new SocialProfile(str[0], str[1]));
                    arr.forEach(System.out::println);
                }
                else if (str.length == 3) {
                    arr.add(new SocialProfile(str[0], str[1], str[2]));
                    arr.forEach(System.out::println);
                }
                else if (str.length == 4) {
                    arr.add(new SocialProfile(str[0], str[1], str[2], str[3]));
                    arr.forEach(System.out::println);
                }else{
                    System.out.println("Invalid number of arguments");
                    //throw new RuntimeException("Invalid number of arguments")
                }
            }
            else if (input == 2){
                System.out.println("Введите имя профиля, который хотите удалить");
                String name = new Scanner(System.in).nextLine();
                for (int i = 0; i < arr.size(); i ++){
                    if (arr.get(i).name.equals(name)){
                        arr.remove(i);
                    }
                }
                arr.forEach(System.out::println);
            }
            else if (input == 3){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < arr.size(); i++){
                    sb.append("{ " + arr.get(i) + " }");
                }
                System.out.println(sb);
            }
        }
    }
}
