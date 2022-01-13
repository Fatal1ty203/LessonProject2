package hw.homework_conflictMerge;

import java.util.Scanner;

public class Calculator {
    Scanner scn = new Scanner(System.in);
    private int a = scn.nextInt();
    private int b = scn.nextInt();

    public int sum(){
        return b + a;
    }

    public int difference(int a, int b){
       if (a>b){
           return a - b;
       }else return b - a;
    }
}
