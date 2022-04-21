package hw.homework_stream_part2.task6;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new Random().ints(10,2,13).boxed().toList();
        System.out.println(integerList);
        long count = integerList.stream().filter(val -> val < 5).count();
        System.out.println(count);
    }
}
