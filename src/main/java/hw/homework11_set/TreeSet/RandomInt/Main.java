package hw.homework11_set.TreeSet.RandomInt;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        Scanner scn = new Scanner(System.in);

        int counter = 1;
        for (int i = 0; i <10; i++) {
            System.out.println("Добавил " + counter +"й раз");
            treeSet.add((int) (Math.random() * 10));
            counter++;
        }
        System.out.println(treeSet);
        System.out.println(treeSet.floor(scn.nextInt()));
        System.out.println(treeSet.ceiling(scn.nextInt()));
        System.out.println(treeSet.subSet(scn.nextInt(),scn.nextInt()));
    }
}
