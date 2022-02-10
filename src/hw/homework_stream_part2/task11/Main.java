package hw.homework_stream_part2.task11;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("29a", "12", "94", "abc", "a9c5");

//        list.stream()
//                .mapToInt(value -> Integer.parseInt(Character.toString(Integer.parseInt(value))))
//                .forEach(System.out::println);


//                List<String> list1 = List.of("100", "200","500");
//        double sum2 = list1.stream().mapToDouble(value -> Double.parseDouble(value)).sum();
//        System.out.println(sum2);


        System.out.println("Проверить код символа на то, является ли он числом");
        int codeOfSymbol = '3';
        System.out.println(codeOfSymbol+" "+Character.isDigit(codeOfSymbol));
        System.out.println("Сконвертируем данный код в число");
        System.out.println(codeOfSymbol+" "+Character.toString(codeOfSymbol));


        long count = list.stream()
                .map(str -> str.chars()
                        .filter(symbol->Character.isDigit(symbol))
                        .mapToLong(code -> Integer.parseInt(Character.toString(code)))
                        .sum())
                .filter(sum -> sum > 10)
                .count();
        System.out.println(count);
    }


}
