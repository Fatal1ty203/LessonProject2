package lessons.lesson26_hashMap_with_objects.lesson31_invariant_covariant_collections;

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

        System.out.println("Создадим метод с параметром, позволяющий передать список в любом типе");
        ArrayList<Orange> orangeList = new ArrayList<>(List.of(new Orange("orange1", 120)));
        ArrayList<Fruit> fruitList = new ArrayList<>(List.of(new Fruit("fruit1", 120)));
        FruitService.print1(appleList);
        FruitService.print1(orangeList);
        FruitService.print1(fruitList);
        FruitService.print1(List.<Integer>of(10, 20, 30));


        System.out.println("Проблема данного метода в том, что его параметр теряет передаваемый тип, а также возможность обратиться к полю типа");
        System.out.println("Содадим метод, который будет сохранять тип");
        FruitService.print2(appleList);
        FruitService.print2(orangeList);
        FruitService.print2(fruitList);
        //FruitService.print2(List.<Integer>of(10, 20, 30)); //error, так как Integer не наследуется от Fruit

        //Проверим свойство ковариантности и контрвариантности
        ArrayList<? extends Fruit> fruitList2 = appleList; //коллекция стала ковариантной
        appleList = (ArrayList<Apple>) fruitList2; //коллекция стала контрвариантной
        for (Apple apple1 : appleList) {
            System.out.println(apple1);
        }


    }

}


class FruitService{
    //? - wildcard
    public static void print1(List<?> fruitList){
        //Здесь отсутстует возможность обраттиься к полям элементов
        //Object o = fruitList.get(0); //всегда будет возвращаться в типе Object
        fruitList.forEach(System.out::println);
    }
    //? extends Fruit задает свойство КОВАРИАНТНОСТИ списку fruitList
    public static void print2(List<? extends Fruit> fruitList){
        //Здесь есть возможность обраттиься к полям элементов
        for (int i = 0; i < fruitList.size(); i++) {
            Fruit f = fruitList.get(i);
            System.out.println(f.name+" "+f.price);
        }
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
    int test;

    public Orange(String name, int price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", test=" + test +
                '}';
    }
}
class Apple extends Fruit{

    int nutrition;
    public Apple(String name, int price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", nutrition=" + nutrition +
                '}';
    }
}