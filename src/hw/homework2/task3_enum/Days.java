package hw.homework2.task3_enum;

// Monday – /’mun.dei/ — Понедельник
//
//         ⦿ Tuesday – /’tiu:z.dei/ — Вторник
//
//         ⦿ Wednesday – /’wenz.dei/ — Среда
//
//         ⦿ Thursday – /’thurz.dei/ — Четверг
//
//         ⦿ Friday – /’frai.dei/ — Пятница
//
//         ⦿ Saturday – /’sa.ta.dei/ — Суббота
//
//         ⦿ Sunday – /’sun.dei/ — Воскресенье


////Еженедельник (содержит список дел на неделю)
//class WeekDiary{
//    private lessons.lesson6_enum.Plan[] arr = new lessons.lesson6_enum.Plan[7]; //класс WeekDiary инкапсулирует поле arr
//
//    public void addPlan(Days day, String plan){
//        //если в массиве под индексом дня недели еще нет планов (нет объекта, который их хранит
//        if(arr[day.getDayIndex()]==null){
//            //то мы создаем этот объект
//            arr[day.getDayIndex()] = new lessons.lesson6_enum.Plan(day);
//        }
//        //теперЬ, когда объект гарантированно создан, можно добавить в него план plan
//        arr[day.getDayIndex()].plansList.add(plan);
//    }
//
//
//
//    public void print(){
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != null){
//                System.out.print(arr[i].day.getRussianTranslate() +": ");
//                System.out.println(arr[i].plansList);
//            }
//        }
//    }
//
//
//
//}


enum Days {
    MONDAY(0,"Понедельник"), TUESDAY(1,"Вторник"), WEDNESDAY(2,"Среда"),
    THURSDAY(3, "Четверг"), FRIDAY(4, "Пятница"), SATURDAY(5, "Суббота"),
    SUNDAY(6,"Воскресенье");

    private int dayIndex;
    private String russianTranslate;

    public String getRussianTranslate(){
        return russianTranslate;
    }

    public int getDayIndex(){
        return dayIndex;
    }

    Days(int dayIndex, String russianTranslate){
        this.dayIndex = dayIndex;
        this.russianTranslate = russianTranslate;
    }

    @Override
    public String toString() {
        return "Days: "  + russianTranslate;
    }
}


