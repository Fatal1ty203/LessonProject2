package hw.homework10_linkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList1 = new MyLinkedList<>();
        myLinkedList1.add("One");
        myLinkedList1.add("Two");
        myLinkedList1.add("Three");
        myLinkedList1.add("Four");

        for (int i = 0; i < myLinkedList1.size(); i++){
            System.out.println(myLinkedList1.get(i));
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
//        linkedList.remove();


        int a = 5;
        int b = 2 ;

        int y = a / b;
        int x = a % b;

        int c = 0;

        System.out.println("При делении: " + y);
        System.out.println("Остаток: " + x);

        y = x >= 5 ? y : y+1;

        System.out.println(y);
    }
}
