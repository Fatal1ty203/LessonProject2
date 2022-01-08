package lessons.lesson18_4_comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Добавим к стандартной сортировке дополнительне две сортировки по алфавиту
//        String str1 = "one";
//        String str2 = "two";
//        System.out.println(str1.compareTo(str2)); //сравнение строк на больше меньше



        List<Fruit> fruitList = Arrays.asList(new Fruit("Yabloko",150, 10.5), new Fruit("Cherryr", 200, 9.4), new Fruit("Apelsin", 100, 15.1));
        Collections.sort(fruitList);
        System.out.println("Сортировка по возврастанию цены");
        System.out.println(fruitList);
        System.out.println("Сортировка по алфавиту");
        Collections.sort(fruitList, new SortByAlphabet());
        System.out.println(fruitList);
        System.out.println("Сортировка по весу");
        Collections.sort(fruitList, new SortByWeight());
        System.out.println(fruitList);



    }
}

class SortByWeight implements Comparator<Fruit>{

    @Override
    public int compare(Fruit o1, Fruit o2) {
        double difference = o1.weight - o2.weight;
        if(difference == 0) return 0;
        else if(difference < 0) return -1;
        return 1;
    }
}

class SortByAlphabet implements Comparator<Fruit>{

    @Override
    public int compare(Fruit o1, Fruit o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Fruit implements Comparable<Fruit> {
    public String name; //доступен везде
    protected int price; //доступен в рамках своего пакета (fruit) и во всех наследниках (даже если наследники находятся в другом пакете)
    public double weight;

    public Fruit(String name, int price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public int compareTo(Fruit o) {
        return price - o.price; //по возврастанию цены
        //return o.price - price; //по убыванию цены
    }


    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}