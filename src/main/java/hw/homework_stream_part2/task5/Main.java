package hw.homework_stream_part2.task5;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new Random().ints(10, 2, 13).boxed().toList();
        System.out.println(integerList);
        integerList.stream().filter(val-> val>5).forEach(System.out::println);
    }
}
