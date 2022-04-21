package hw.homework_JUnitTest;

public class CalculatorTest {

    Calculator calc;


    public void print(){
        System.out.println("ERROR");
    }
    @MyBeforeEach
    public void init(){
        calc = new Calculator();
    }

    @MyTest
    public void sum(){
        int a = 2;
        int b = 3;
        int result = a+b;
        System.out.println("sum test result = "+(result == calc.sum(a,b)));
    }


    @MyTest
    public void raz(){
        int a = 2;
        int b = 3;
        int result = a-b;
        System.out.println("raz test result = "+(result == calc.raz(a,b)));
    }
}
