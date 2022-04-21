package hw.homework_stream.task10;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Tovar> tovars = Stream.of( new Tovar("XR", 500, "Телефон")
                , new Tovar("Xiaomi", 700, "Телефон")
                , new Tovar("Orange", 10, "Фрукт")
                , new Tovar("Apple", 20, "Фрукт")
                , new Tovar("Tesla", 10000, "Машина"));
        List<Tovar> tovarList = tovars.collect(Collectors.toList());

        long count = tovarList.stream().filter(val -> val.getCategory().equalsIgnoreCase("Фрукт"))
                .filter(val -> val.getPrice() > 10).count();


        System.out.println(count);
    }
}
