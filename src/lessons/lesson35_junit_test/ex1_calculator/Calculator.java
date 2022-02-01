package lessons.lesson35_junit_test.ex1_calculator;

public  class Calculator {
    public int sum(int a, int b){
        return a+b;
    }
    public double divide(double a, double b){
        if(b==0) throw new ArithmeticException("divide by zero");
        return a/b;
    }
}
