package hw.homework3_abstract.task2;

public class main {
    public static void main(String[] args) {
        MonthEmployee monthEmployee = new MonthEmployee();
        monthEmployee.setSalaryPerMonth(5000.5);
        monthEmployee.calcSalary(50);

        MonthBonusEmployee monthBonusEmployee = new MonthBonusEmployee();
        monthBonusEmployee.setSalaryPerMonth(5003.5);
        monthBonusEmployee.setBonus(1.8);
        monthBonusEmployee.setHoursPerWeek(65);
        monthBonusEmployee.calcSalary(50);

        System.out.println(monthEmployee);
        System.out.println(monthBonusEmployee);
    }
}
