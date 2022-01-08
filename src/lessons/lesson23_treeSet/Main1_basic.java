package lessons.lesson23_treeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Main1_basic {
    public static void main(String[] args) {
        //TreeSet хранит все элементы в уникальном упорядоченном по возрастанию виде
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("three");
        treeSet.add("four");

        Iterator<String> iterator = treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //либо церез foreach

        //либо так:
        //treeSet.forEach(System.out::println);





    }
}
