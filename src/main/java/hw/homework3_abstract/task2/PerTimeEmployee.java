package hw.homework3_abstract.task2;

public class PerTimeEmployee extends Employee {
    double salaryPerHour;

    public double getSalaryPerHour(){
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour){
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public double calcSalary(int hoursPerWeek) {
        return hoursPerWeek * getSalaryPerHour();
    }


}
