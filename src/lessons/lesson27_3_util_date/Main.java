package lessons.lesson27_3_util_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
        Date date1 = new Date(); //создаем объект текущей даты
        System.out.println(date1);
        SimpleDateFormat sdf = new SimpleDateFormat("Дата: dd.MMMM.yyyy, Время: HH:mm:ss");
        String ourDate = sdf.format(date1);
        System.out.println(ourDate);


        //Создадим объект своей даты:
        Date date = new SimpleDateFormat("dd.MM.yyyy").parse("1.1.2022");

        System.out.println(date.compareTo(date1)); //можно сравнивать через компаратор
        System.out.printf("date after date1? %s%n", date.after(date1));
        System.out.printf("date before date1? %s%n", date.before(date1));

        List<Date> list = Arrays.asList(date1, date);
        //list.sort(null);
        list.forEach(d-> System.out.println(sdf.format(d)));


    }
}
