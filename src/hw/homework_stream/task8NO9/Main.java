package hw.homework_stream.task8NO9;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new Random()
                .ints(10,2,11)
                .boxed()
                .collect(Collectors.toList());
//        list.forEach(System.out::println);

        List<Integer> list1 = list.stream().filter(val -> val<8).collect(Collectors.toList());
        list1.forEach(System.out::println);
    }
}
