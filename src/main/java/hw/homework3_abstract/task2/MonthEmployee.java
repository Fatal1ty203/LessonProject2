package hw.homework3_abstract.task2;

import java.math.BigDecimal;

public class MonthEmployee extends Employee {
    String name = "MonthEmployee";
    double salaryPerMonth;
    int rub,cop;

    @Override
    public double calcSalary(int hoursPerWeek) {
        return getSalaryPerMonth()/4;
//        BigDecimal src = new BigDecimal(getSalaryPerMonth());
//        BigDecimal a = src.remainder(BigDecimal.ONE);
//        BigDecimal b = new BigDecimal("0.5");
//        convect(src,a);
//        if (a.doubleValue() >= b.doubleValue()) {
//            return (int) Math.round(getSalaryPerMonth());
//        }else return (int) getSalaryPerMonth();
    }

    public void convect(BigDecimal a, BigDecimal b){
        BigDecimal c = new BigDecimal("10");
        setRub(a.intValue());
        setCop(b.multiply(c).intValue());
    }

    public int getRub() {
        return rub;
    }

    public void setRub(int rub) {
        this.rub = rub;
    }

    public int getCop() {
        return cop;
    }

    public void setCop(int cop) {
        this.cop = cop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryPerMonth(){
        return salaryPerMonth;
    }

    public void setSalaryPerMonth(double salaryPerMonth){
        this.salaryPerMonth = salaryPerMonth;
    }

    @Override
    public String toString() {
        return getName() + " зарпалата: " + getRub() + " руб. " +
                 getCop() + " коп.";
    }
}
