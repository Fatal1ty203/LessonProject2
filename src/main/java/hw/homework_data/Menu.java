package hw.homework_data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static List<Presidents> presidents = new Service().readToFile();
    public static void start() {
        int input = 0;
        boolean changes = false;
        Scanner scn = new Scanner(System.in);
        while (input!=5){
            System.out.println("1. Вывести имена президентов и сроки их правления в порядке возрастания столбца \"начало срока\"\n" +
                    "2. Вывести имена президентов и сроки их правления в обратном порядке\n" +
                    "3. Найти президента, который правил в определенную дату (с консоли вводится дата, программа ищет президента, в чей срок правления попадает эта дата)\n" +
                    "4. Добавить нового президента (добавляются значения для всех столбцов)\n" +
                    "5. Выход (при выборе файл обновляется, если были изменения)\n" +
                    "6. Удалить президента из базы, по имени");
            input = scn.nextInt();
            if (input==1){
                Collections.sort(presidents);
                System.out.println(presidents);
            }else if (input==2){
                Collections.sort(presidents, new SortByReversDate());
                System.out.println(presidents);
            }else if (input==3){
                System.out.print("Пожалуйста введи дату правления президента, в формате 25.08.1997: ");
                String st = scn.next();
//                String date = "07.04.1841";
                try {
                    Date date = new SimpleDateFormat("dd.MM.yyyy").parse(st);
                    System.out.println(new Service().getPresident(date));
                } catch (ParseException e) {
                    e.printStackTrace();
                    try {
                        throw new DateInvalidFormatExeption("Вы ввели некорректную дату");
                    } catch (DateInvalidFormatExeption dateInvalidFormatExeption) {
                        dateInvalidFormatExeption.printStackTrace();
                    }
                }
            }else if (input==4){
                try {
                    try {
                        presidents.add(new Service().addPresident());
                    } catch (ParseException e) {
                        e.printStackTrace();
                        throw new DateInvalidFormatExeption("Вы ввели некорректную дату");
                    }
                } catch (DateInvalidFormatExeption dateInvalidFormatExeption) {
                    dateInvalidFormatExeption.printStackTrace();
                }
                changes = true;
            }else if (input==5){
                if (changes==true) new Service().save(presidents);
            }else if (input==6){
                scn.nextLine();
                String name = scn.nextLine();
                Presidents pr = new Service().getPresident(presidents,name);
                if (pr==null){
                    try {
                        throw new NoNameException("Президент с таким имененем не найден");
                    } catch (NoNameException e) {
                        System.err.println(e.getMessage());;
                    }
                }
                presidents.remove(pr);
                changes = true;
                System.out.println(presidents);
            }
        }
    }


}
