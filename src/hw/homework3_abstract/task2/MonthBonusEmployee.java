package hw.homework3_abstract.task2;

public class MonthBonusEmployee extends MonthEmployee{

    String name = "MonthBonusEmployee";
    int rub,cop;
    double salaryPerMonth,bonus;

    @Override
    public double calcSalary(int hoursPerWeek) {
        if (getHoursPerWeek() > 44) {
//            setSalaryPerMonth(getSalaryPerMonth() + (getBonus() * (getHoursPerWeek() - 44)));
//            return super.calcSalary();
            return super.calcSalary(hoursPerWeek)+bonus;
        }else return super.calcSalary(hoursPerWeek);
    }

    //    @Override
//    public int calcSalary() {
//        return (int) (getSalaryPerMonth()+getBonus() * 10);
//    }



    public double getBonus(){
        return bonus;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public double getSalaryPerMonth(){
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth){
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


}
