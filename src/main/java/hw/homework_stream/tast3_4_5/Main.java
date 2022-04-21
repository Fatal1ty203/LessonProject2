package hw.homework_stream.tast3_4_5;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Tovar iphone = new Tovar("XR", 500, "Телефон");
        Tovar xiaomi = new Tovar("Xiaomi", 700, "Телефон");
        Tovar orange = new Tovar("Orange", 10, "Фрукт");
        Tovar apple = new Tovar("Apple", 20, "Фрукт");
        Tovar car = new Tovar("Tesla", 10000, "Машина");

        List<Tovar> list = List.of(iphone, xiaomi,orange,apple,car);

        List<Tovar> list1 = list.stream()
                .filter(val->val.getPrice() < 700)
                .collect(Collectors.toList());
        System.out.println(list1);

        list.stream()
                .filter(val->val.getCategory().equalsIgnoreCase("Телефон"))
                .forEach(System.out::println);

        int count = (int) list.stream()
                .filter(val -> val.getCategory().equalsIgnoreCase("Телефон"))
                .count();

        System.out.println("Товаров категории телефон: " + count);

    }
}
