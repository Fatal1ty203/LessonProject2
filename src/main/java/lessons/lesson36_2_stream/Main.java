package lessons.lesson36_2_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //На foreach:
        //
        //- Вывод списка и массива через foreach
        List<Integer> list = List.of(10,20,30,-50, 60, 20, -5);
        int[] arr = {10,20,30};

        //list.forEach(val-> System.out.println(val));
        list.forEach(System.out::println);
        System.out.println("Через массив:");
        Arrays.stream(arr).forEach(System.out::println);


        //На filter:
        //
        //- Вывести только те числа, что больше 10
        list.stream()
                .filter(val->val>10)
                .forEach(System.out::println);
        //- Вывести только строки с большой буквы
        List<String> list2 = List.of("One", "two", "Three");
        list2.stream()
                .filter(val->Character.isUpperCase(val.charAt(0)))
                .forEach(System.out::println);

        //+ Создать массив товаров и вывести только те товары, чья цена меньше 500.
        //
        //
        //
        //На collect:
        //
        //- Есть список чисел. Создать на его основе новый список чисел, которые больше 10.
        List<Integer> collect = list.stream()
                .filter(val -> val > 10)
                .collect(Collectors.toList());
        System.out.println(collect);


        //- Есть список чисел. Создать на его основе Set чисел, которые больше 10
        Set<Integer> collect1 = list.stream()
                .filter(val -> val > 10)
                .collect(Collectors.toSet());
        System.out.println(collect1);

        //+ Есть список товаров. Создать на его основе List товаров, чья цена больше 500.
        //
        //
        //
        //На sum:
        //
        //- Найти сумму всех чисел в массиве
        int[] arr2 = {5, 3,6};
        int sum = Arrays.stream(arr2).sum();


        //На count:
        //
        //- Найти количство четных чисел в массиве
        int[] arr3 = {5, 3,6};
        long cound = Arrays.stream(arr2).filter(val->val%2==0).count();
        //+ Найти количество товаров, чья категория "Телефоны"
    }
}
