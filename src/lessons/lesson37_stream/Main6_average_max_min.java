package lessons.lesson37_stream;

import java.util.*;

public class Main6_average_max_min {
    public static void main(String[] args) {
        //- Сгенерировать массив случайных чисел,
        // вывести его на консоль и найти максимальный,
        // минимальный элемент и среднее арифметическое.

        int[] arr = new Random().ints(5, -10, 10).toArray();
        Arrays.stream(arr).forEach(x-> System.out.print(x+" "));
        //arr = new int[0];
        System.out.println();
        OptionalInt max = Arrays.stream(arr).max();
        //базовый вариант работы с Optional
//        if(max.isEmpty()){
//            System.out.println("Массив пуст");
//        }else{
//            System.out.println(max.getAsInt());
//        }
        //перепишем базовый вариант более оптимальным путем
        max.ifPresentOrElse(x-> System.out.println(x), ()-> System.out.println("Масив пуст"));

        //Найдем среднее арифметическое
        OptionalDouble average = Arrays.stream(arr).average();
        double avr = average.orElse(0);
        System.out.println("average = "+avr);


        //- В списке проданных товаров найти самый дорогой товар и вывести его на консоль (метод max с компаратором)

        class Tovar{
            String name;
            int price;

            public Tovar(String name, int price) {
                this.name = name;
                this.price = price;
            }
        }
        List<Tovar> listTOvar = List.of(new Tovar("t1", 100),
                new Tovar("t2", 300),
                new Tovar("t3", 150));

        Optional<Tovar> maxTovar = listTOvar.stream().max((t1, t2) -> t1.price - t2.price);
        maxTovar.ifPresentOrElse(tovar-> System.out.println("Самый дорогой товар: " + tovar.name),
                ()-> System.out.println("Товар не найден"));

    }
}

class MyOptional{
    private Integer x;
    public void set(int x){
        this.x = x;
    }

    public int getAsInt(){
        return x;
    }

    public boolean isEmpty(){
        return x == null;
    }

}
