package lessons.lesson37_stream;

import java.util.List;

public class Main3_mapToInt {
    public static void main(String[] args) {
        //Найти сумму чисел в списке

        List<Integer> list  = List.of(1,4,3,5,6);

        int sum = list.stream().mapToInt(x -> x).sum();
        System.out.println(sum);

        //+ Предположим, есть корзина товаров в интернет-магазине.
        // Создать список товаров и найти сумму добавленных туда элементов.
        class Tovar{
            String name;
            int price;

            public Tovar(String name, int price) {
                this.name = name;
                this.price = price;
            }
        }
        List<Tovar> backet = List.of(new Tovar("t1", 100),
                new Tovar("t2", 300),
                new Tovar("t3", 150));
        int sum1 = backet.stream().mapToInt(value -> value.price).sum();
        System.out.println(sum1);

        //+ Создать список чисел в типе String. Найти сумму его элементов в типе double

        List<String> list1 = List.of("100", "200","500");
        double sum2 = list1.stream().mapToDouble(value -> Double.parseDouble(value)).sum();
        System.out.println(sum2);
    }
}
