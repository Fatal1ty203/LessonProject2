package hw.homework_conflictMerge;

import java.util.Scanner;

public class Calculator {
    Scanner scn = new Scanner(System.in);
    private int a = scn.nextInt();
    private int b = scn.nextInt();

    public int minus(){
        if (a>b) return a - b;
        return b - a;
    }
}
