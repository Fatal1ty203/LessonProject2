package lessons.lesson9_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int a = readInt("Enter a");
        int b = readInt("Enter b");
        int[] arr = new int[5];
        try {
            System.out.println(arr[10]);
            System.out.println(a / b);
        }catch (ArithmeticException e){
            System.out.println("На ноль делить нельзя");
        }



    }

    public static int readInt(String text){
        Scanner scn = new Scanner(System.in);
        while(true){
            try{
                System.out.println(text);
                int a = scn.nextInt();
                return a;
            }catch (InputMismatchException e){
                System.out.println("Вы должны ввести число");
                scn = new Scanner(System.in);
            }
        }
    }
}
