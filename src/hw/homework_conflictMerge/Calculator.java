package hw.homework_conflictMerge;

public class Calculator {
    private int a = 5;
    private int b = 7;

    public int sum(int a, int b){
        return a+b;
    }

    public int difference(int a, int b){
       if (a>b){
           return a - b;
       }else return b - a;
    }
}
