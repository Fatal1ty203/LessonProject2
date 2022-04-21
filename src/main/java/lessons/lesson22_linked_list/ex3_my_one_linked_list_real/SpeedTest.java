package lessons.lesson22_linked_list.ex3_my_one_linked_list_real;

import java.util.ArrayList;
import java.util.LinkedList;

public class SpeedTest {
    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        long start = System.currentTimeMillis();
//        for (int i = 0; i < 50_000; i++) {
//            arrayList.add(i);
//        }
        for (int i = 0; i < 50_000; i++) {
            linkedList.add(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
