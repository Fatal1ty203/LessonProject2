package hw.homework3_abstract.task2;

abstract class Employee {
    int hoursPerWeek;

    public abstract double calcSalary(int hoursPerWeek) ;



    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(int hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
