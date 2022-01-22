package lessons.lesson31_invariant_covariant_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple("apple1", 20);
        Fruit f = apple;
        apple = (Apple) f;
        //Действуют ли те же принципы с массивами?
        //Массив яблок можно приравнять к массиву фруктов (такое свойство массивов называнется ковариантность)
        Apple[] arrApple = {apple};
        Fruit[] arrFruit = arrApple;

        arrApple = (Apple[]) arrFruit; //массив яблок в родительском типе Fruit[] можно обратно приравтяь к Apple[] (контрвариантность)

        //То есть массивы ковариантны и контрвариантны
        System.out.println(Arrays.toString(arrApple));

        //Распространяются ли те же свойства на коллекции?
        ArrayList<Apple> appleList = new ArrayList<>(List.of(apple));
        //ArrayList<Fruit> fruitList = appleList; //коллекции не ковариантны
        //appleList = (ArrayList<Apple>) fruitList; //коллекции не контрвариантны
        //Поэтому говорят, что коллекции инвариантны.
    }

}


class Fruit{
    String name;
    int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
class Orange extends Fruit{


    public Orange(String name, int price) {
        super(name, price);
    }
}
class Apple extends Fruit{


    public Apple(String name, int price) {
        super(name, price);
    }
}