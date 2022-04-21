package hw.homework6_String_operations.task1_2_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str = new Scanner(System.in).nextLine();
        String[] st = str.split(",");
        System.out.println("Имя: " + st[0]);
        System.out.println("Должность: " + st[1]);
        System.out.println("Страна: " + st[2]);
        System.out.println("Компания: " + st[3]);
        System.out.println(isInput(str));
        System.out.println(itsTask3("I want to be a developer", "I", "want", "be"));
    }

    public static boolean isInput(String str){
        char a = str.charAt(0);
        char b = str.charAt(str.length()-1);
        System.out.println(a + " " + b);
        if (a == b)  return true;
        return false;
    }

    public static boolean itsTask3(String str1, String str2, String str3, String str4){
//        String[] st = str1.split(" ");
//        if (st[0].equals(str2) && st[st.length-1].equals(str3)){
//            for (int i = 0; i < st.length; i++){
//                if (st[i].equals(str4)) {
//                    return true;
//                }
//            }
//        }
//        return false;

        return str1.startsWith(str2) && str1.endsWith(str3) && str1.contains(str4);
    }

}
