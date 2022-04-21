package lessons.lesson6_enum;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создать enum Week с константами в виде дней недели.
        // Добавить константам псеводними на русском языке. В мейне вывести все константы из enum через метод values.
        System.out.println(Days.MONDAY.getDayIndex()); //получение индекса дня из enum константы Monday
        WeekDiary weekDiary = new WeekDiary();
//        weekDiary.arr[0] = new Plan(Days.MONDAY);
//        weekDiary.arr[0].plansList.add("go to wark");
//        weekDiary.arr[0].plansList.add("go to gym");

        //good optin:
        weekDiary.addPlan(Days.MONDAY, "go to gym");
        weekDiary.addPlan(Days.MONDAY, "go walk");

        weekDiary.addPlan(Days.WEDNESDAY, "go to cinema");
        weekDiary.print();


    }
}


//Еженедельник (содержит список дел на неделю)
class WeekDiary{
    private Plan[] arr = new Plan[7]; //класс WeekDiary инкапсулирует поле arr

    public void addPlan(Days day, String plan){
        //если в массиве под индексом дня недели еще нет планов (нет объекта, который их хранит
        if(arr[day.getDayIndex()]==null){
            //то мы создаем этот объект
            arr[day.getDayIndex()] = new Plan(day);
        }
        //теперЬ, когда объект гарантированно создан, можно добавить в него план plan
        arr[day.getDayIndex()].plansList.add(plan);
    }



    public void print(){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null){
                System.out.print(arr[i].day.getRussianTranslate() +": ");
                System.out.println(arr[i].plansList);
            }
        }
    }



}

//План на конкретный день
class Plan{
    Days day;
    List<String> plansList = new ArrayList<>();

    public Plan(Days day) {
        this.day = day;
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

    public int getDayIndex(){
        return dayIndex;
    }
}