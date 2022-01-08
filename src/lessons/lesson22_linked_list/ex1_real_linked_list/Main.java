package lessons.lesson22_linked_list.ex1_real_linked_list;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        //LinkedList - двусязный список (хранит ссылки вперед и назад)
        LinkedList<String> list = new LinkedList<>();
        list.add("one"); //add into last
        list.addFirst("two"); //add into head
        list.addLast("three"); //add into last

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println(list.get(2));
    }
}
