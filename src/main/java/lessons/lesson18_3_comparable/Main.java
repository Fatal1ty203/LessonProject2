package lessons.lesson18_3_comparable;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Создать список фруктов и отсортировать их по возрастанию цены
        List<Fruit> fruitList = Arrays.asList(new Fruit("Yabloko",150), new Fruit("Cherryr", 200), new Fruit("Apelsin", 100));
        Collections.sort(fruitList);
        System.out.println(fruitList);
    }
}
class Fruit implements Comparable<Fruit> {
    public String name; //доступен везде
    protected int price; //доступен в рамках своего пакета (fruit) и во всех наследниках (даже если наследники находятся в другом пакете)

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
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
                '}';
    }
}