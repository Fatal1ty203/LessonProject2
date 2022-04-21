package lessons.lesson13_string_operations;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //TRIM - позволяет удалить проблеы по краям строки
        //' apple'
        //'orange'
        //' cherry pick    '
        //' banana'
//        String str = " apple";
//        System.out.println("'"+str.trim()+"'");
//        System.out.println("'"+" cherry pick    ".trim()+"'");



        //SPLIT
        //xls, csv
        //apple;100
        //orange;120
//        String str = "apple;100";
//        String[] arr = str.split(";");
//        System.out.println(Arrays.toString(arr));
//        str = "apple_Barak_100_Barak_4";
//        arr = str.split("_Barak_");
//        System.out.println(Arrays.toString(arr));


        //Комбинация split и trim
//        String str = "apple ; 100 ;4";
//        String[] arr = str.split(";");
//        System.out.println(Arrays.toString(arr));
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = arr[i].trim();
//        }
//        System.out.println(Arrays.toString(arr));


        //replace - позволяет заменить все определенные символы на дргой один разом
        //Есть строки, содержащая имена людей через запятую, нужно удалить все запятые
        String str = "Ivan,      Semen, Nastya";
        str = str.replace(",", "");
        System.out.println(str);
        String[] names = str.split(" ");
        System.out.println(Arrays.toString(names));

        //КОНВЕРТАЦИ ЧИСЛА В СТРОКУ
//        int a = 2;
//        String s = String.valueOf(a);

        //Удалить с помощью replace все числа из строки
//        String str = "hello 5 world 1 04";
//        for (int i = 0; i <= 9; i++) {
//            str = str.replace(String.valueOf(i), "");
//        }
//        System.out.println(str);



        //Substring - извлечение подстроки
//        String str = "1234 5678 1432 1323 50 руб";
//
//        String cardNumber = str.substring(0, 19);
//        String sum = str.substring(20);
//        System.out.println(cardNumber);
//        System.out.println(sum);


        //пример вывода строки посимвольно
//        for (int i = 0; i < str.length(); i++) {
//            System.out.println(str.charAt(i));
//        }





    }
}
