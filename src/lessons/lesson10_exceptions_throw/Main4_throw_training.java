package lessons.lesson10_exceptions_throw;

public class Main4_throw_training {
    public static void main(String[] args) {
        try {

            System.out.println(SalaryCalculator.calcSalary(-1, -1, -1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class SalaryCalculator{
    //ЗП вычисляет по формуле:daySalary * days * experience
    //При этом Все параметры не могут быть меньше 0
    //experience не может быть больше 100
    public static int calcSalary(int daySalary, int days, int experience){
        if(daySalary<0) throw new RuntimeException("daySalary - не может быть меньше нуля");
        if(days<0) throw new RuntimeException("days - не может быть меньше нуля");
        if(experience<0) throw new RuntimeException("days - не может быть меньше нуля");
        if(daySalary>100) throw new RuntimeException("days - не может быть больше 100");

        return daySalary * days * experience;



    }
}
