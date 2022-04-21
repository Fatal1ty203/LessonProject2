package lessons.lesson14_scanner_options;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Пользователь вводит свое имя, возраст, пол через пробел. Считать каждое значение в отедльную переменную
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter data через space");
        String name = scn.next();
        int age = scn.nextInt();
        String sex = scn.next();
        System.out.println("name: "+name);
        System.out.println("age: "+age);
        System.out.println("пол: "+sex);

    }
}
