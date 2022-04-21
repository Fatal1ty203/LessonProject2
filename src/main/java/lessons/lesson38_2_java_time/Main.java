package lessons.lesson38_2_java_time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        System.out.println(date1);

        LocalDateTime dateWithTime = LocalDateTime.now();
        System.out.println(dateWithTime);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        //ФОРМАТИРОВАНИЕ:
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String format = date1.format(formatter);
        System.out.println(format);


        //СОЗДАНИЕ ДАТЫ
        LocalDate d = LocalDate.of(2020, 1, 10);
        System.out.println(d.format(formatter));

        //СРАВНЕНИЕ ДАТ
        System.out.println(d.compareTo(date1));
        System.out.println(d.isAfter(date1));
        System.out.println(d.isBefore(date1));


        //Сортировка дат
        List<LocalDate> list = new ArrayList<>(List.of(date1, d) );
        list.sort(null);
        System.out.println(list);

    }
}
