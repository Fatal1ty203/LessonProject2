package lessons.lesson23_treeSet;


import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main2_with_object {
    public static void main(String[] args) {
        //Эффективность методов TreeSet:
        //add - O(log2(n))
        //floor, ceiling - O(log2(n))

        //log2(8) = 3 (3 это та степень, в которую нужно возвести 2, чтобы получить 8)
        TreeSet<Fruit> fruitTreeSet = new TreeSet<Fruit>();
        fruitTreeSet.add(new Fruit("apple", 10));
        fruitTreeSet.add(new Fruit("dapple", 12));
        fruitTreeSet.add(new Fruit("bapple", 14));
        fruitTreeSet.add(new Fruit("zapple", 14));
        fruitTreeSet.add(new Fruit("eapple", 14));
        fruitTreeSet.add(new Fruit("capple", 14));

        fruitTreeSet.forEach(System.out::println);

        //Как получить объект из TreeSet
        //Метод floor

        //Допустим юзер ввел консоли apple, надо найти, сколько он стоит
        String userInput = "apple";
        //1 2 3 4 5
        //floor(2.2) вернет 2  (берет ближайшее к полу)
        //ceiling(2.2) вернет 3 (берет ближайшее к потолку)
        Fruit fruit = fruitTreeSet.floor(new Fruit(userInput, 0));
        if(fruit == null){
            System.out.println("фрукт не найден");
        }
        else if(fruit.name.equalsIgnoreCase(userInput)){
            System.out.println("Цена равна "+fruit.price);
        }else{
            System.out.println("Нашли похожий по названию фрукт: "+fruit);
        }

        //Получить множество всех фруктов который начинаются с букв от bapple до dapple
        //верхняя граница невключительно:
        SortedSet<Fruit> fruits = fruitTreeSet.subSet(new Fruit("bapple", 0), new Fruit("dapple", 0));
        //нижняя и верхняя включительно
        NavigableSet<Fruit> fruits2 = fruitTreeSet.subSet(new Fruit("bapple", 0), true, new Fruit("dapple", 0), true);

        System.out.println("верхняя граница невключительно:");
        fruits.forEach(System.out::println);
        System.out.println("нижняя и верхняя включительно:");
        fruits2.forEach(System.out::println);





    }
}

class Fruit implements Comparable<Fruit>{
    String name;
    int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int compareTo(Fruit o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
