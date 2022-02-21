package lessons.lesson40_1_optional;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Fruit> fruits = List.of(new Fruit("apple", 10), new Fruit("orange", 20));
        //Получить фрукт по названию или выбросить исключение FruitNotFroundException
        Optional<Fruit> f2 = fruits.stream().filter(f -> f.name.equals("apple")).findFirst();
        Fruit fruit = f2.orElseThrow(() -> new FruitNotFroundException());
        System.out.println(fruit);

    }
}
class FruitNotFroundException extends RuntimeException{}

class Fruit{
    String name;
    int price;

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }
}