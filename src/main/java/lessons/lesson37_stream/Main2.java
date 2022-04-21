package lessons.lesson37_stream;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
//в двумерном массиве найти кол-во строк, сумму чисел в которых больше 10
        int[][] data = {
                {2, 6, 5},
                {1, 2, 3},
                {5, 4, 5}
        };

        //Stream<int[]> stream = Arrays.stream(data); //стрим по двумерному массиву, это стрим по его одномерным массивам
        long count = Arrays.stream(data)
                .map(arr -> Arrays.stream(arr)
                        .sum())
                .filter(sum -> sum > 10)
                .count();
        System.out.println(count);
    }
}
