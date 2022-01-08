package lessons.lesson1_list.task2;

import java.util.ArrayList;
import java.util.List;

public class CreateFruit {
    public static List<Object> create(){
        List<Object> fruits = new ArrayList<>();
        fruits.add(new Fruit("Бананы", 50, 35));
        fruits.add(new Fruit("Яблоки", 60, 40));
        fruits.add(new Fruit("Дыня", 30, 20));
        fruits.add(new Fruit("Груша", 45, 70));
        fruits.add(new Fruit("Бананы", 50, 80));
        return fruits;
    }
}
