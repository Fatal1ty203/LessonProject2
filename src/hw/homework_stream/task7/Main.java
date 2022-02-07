package hw.homework_stream.task7;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] i = new Random()
                .ints(10,2,13)
                .toArray();

        Arrays.stream(i).forEach(System.out::println);


        System.out.print("Сумма: ");
        System.out.println(Arrays.stream(i).sum());
    }


}
