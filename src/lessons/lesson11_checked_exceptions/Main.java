package lessons.lesson11_checked_exceptions;

public class Main {
    public static void main(String[] args) {
        //CHECKED исключения - это обязательные для обработки исключения
        //Есть один способ обработки - try catch блок
        //Но если мы хотим отсрочить обработку (сделать ее за пределами метода), для этого есть ключ слово throws
        String[] arr = {"one", "two"};
        try {
            int dayIndex = Calendar.getWeekDayNumber("monday");
            System.out.println(arr[dayIndex]);
            int monthDaysNumber = Calendar.getMonthDaysNumber("sdf");
            System.out.println(monthDaysNumber);
            Calendar.printCalendar("sdf", new String[]{"mnday", "tuesday"});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Calendar {

//Метод принимает название месяца и выводт на консоль его номер и первые семь номеров  у дней недели
    public static void printCalendar(String monthName, String[] dayNames) throws Exception{
        int monthDaysNumber = getMonthDaysNumber(monthName);
        for (int i = 0; i < dayNames.length; i++) {
            System.out.println(getWeekDayNumber(dayNames[i]));
        }
    }

    public static int getWeekDayNumber(String dayName) throws Exception{
        if(dayName.equals("monday")){
            return 0;
        }
        else if(dayName.equals("tuesday")){
            return 1;
        }
        throw new Exception("invalid day name exception: " + dayName); //Вместо return пишем генерацию исключения

    }

    public static int getMonthDaysNumber(String monthName) throws Exception{
        if(monthName.equals("January")){
            return 31;
        }
        else if(monthName.equals("Februray")){
            return 28;
        }
        throw new Exception("invalid month name exception: "+monthName); //Вместо return пишем генерацию исключения

    }

}