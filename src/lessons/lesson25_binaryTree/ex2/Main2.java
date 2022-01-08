package lessons.lesson25_binaryTree.ex2;

import lessons.lesson25_binaryTree.MyBinaryTree;


import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {
        //Чтобы ключ был в вдие своего класса, он должен реализовыывать Comparable
        MyBinaryTree<Fruit, Double> tree1 = new MyBinaryTree<Fruit, Double>();

        Map<Object,Object> objectMap = new HashMap<>();

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
}
