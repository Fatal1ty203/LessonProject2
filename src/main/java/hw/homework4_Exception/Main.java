package hw.homework4_Exception;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int[] arr = new int[5];
        int input = 0;
        while (input != 3) {
            try {
                System.out.println("1. Добавить новое число (пользователь вводит индекс и значение числа)\n" +
                        "2. Получить число (пользователь вводит индекс)\n" +
                        "3. Выход");
                input = readInt("");
                String indexString = "Введите индекс числа";
                if (input == 1) {
                    arr[readInt(indexString)] = readInt("Введите число");
                }
                if (input == 2) {
                    System.out.println(arr[readInt(indexString)]);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Вы ввели некорректный индекс");
            }
        }
    }

    public static int readInt(String text) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            try {
                System.out.println(text);
                int a = scn.nextInt();
                return a;
            } catch (Exception e) {
                System.out.println("Вы ввели некорректный индекс");
            }
        }
    }
}
