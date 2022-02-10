package hw.homework_stream_part2.task11;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("29a", "12", "94", "abc", "a9c5");

        list.stream()
                .mapToInt(value -> Integer.parseInt(Character.toString(Integer.parseInt(value))))
                .forEach(System.out::println);
//                List<String> list1 = List.of("100", "200","500");
//        double sum2 = list1.stream().mapToDouble(value -> Double.parseDouble(value)).sum();
//        System.out.println(sum2);

    }
}
