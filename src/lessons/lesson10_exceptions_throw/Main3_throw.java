package lessons.lesson10_exceptions_throw;

public class Main3_throw {
    public static void main(String[] args) {
        //Throw нужен для того, чтобы самим сгенерировать исключение
        //К примеру это позволяет не писать return, когда нечего возвращать
        //И уменьшить кол-во проверок возвращаего значения
        String[] arr = {"one", "two"};
        try {
            int dayIndex = Calendar.getWeekDayNumber("mnday");
            System.out.println(arr[dayIndex]);
            int monthDaysNumber = Calendar.getMonthDaysNumber("sdf");
            System.out.println(monthDaysNumber);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}


class Calendar {

    public static int getWeekDayNumber(String dayName){
        if(dayName.equals("monday")){
            return 0;
        }
        else if(dayName.equals("tuesday")){
            return 1;
        }
        throw new RuntimeException("invalid day name exception: "+dayName); //Вместо return пишем генерацию исключения


    }

    public static int getMonthDaysNumber(String monthName){
        if(monthName.equals("January")){
            return 31;
        }
        else if(monthName.equals("Februray")){
            return 28;
        }
        throw new RuntimeException("invalid month name exception: "+monthName); //Вместо return пишем генерацию исключения

    }

}
