package lessons.lesson7_1_enum_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Реализовать ввод дня недели с консоли, так чтобы введенный день в String конвертировался в enum
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter day ");
        String day = scn.next();

        //вариант 1. Получить список всех констант и через цикл искать совпдающую с нашим днем констнату
        //Days[] values = Days.values();

        //варинт 2. через готовый метод valuesOf. Недостаток в том, что в него надо передать строку в точности совпадающую с названием констаны вполнть до ее регистра
        //иначе будет ошибка
//        Days days = Days.valueOf(day);
//        System.out.println("your day: "+days);

        //Правильный вариант: варинт 3, через собственный статический метод getEnumDay
        Days enumDay = Days.getEnumDay(day);
        if(enumDay!=null){
            System.out.println("your day: "+enumDay);
        }else{
            System.out.println("Invalid day value");
        }


    }
}


enum Days{
    MONDAY(0, "Понедельник"), TUESDAY(1, "Вторник"), WEDNESDAY(2, "Среда");

    private int dayIndex; //инкапуслированное поле dayIndex
    private String russianTranslate;

    public String getRussianTranslate() {
        return russianTranslate;
    }

    Days(int dayIndex, String russianTranslate) {
        this.dayIndex = dayIndex;
        this.russianTranslate = russianTranslate;
    }

    public static Days getEnumDay(String day){
        Days[] values = Days.values();
        for(Days d : values){
            if(d.toString().equalsIgnoreCase(day) || d.getRussianTranslate().equalsIgnoreCase(day)){
                return d;
            }
        }
        return null;
    }

    public int getDayIndex(){
        return dayIndex;
    }
}