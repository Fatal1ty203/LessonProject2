package hw.homework2.task3_enum;

public class Main {
    public static void main(String[] args) {
        WeekDiary weekDiary = new WeekDiary();
        weekDiary.addPlan(Days.FRIDAY,"Privet");
        weekDiary.addPlan(Days.MONDAY,"Kupi");
        weekDiary.addPlan(Days.THURSDAY,"Edu");
        weekDiary.addPlan(Days.SATURDAY,"I hz");
        weekDiary.print();
    }
}
