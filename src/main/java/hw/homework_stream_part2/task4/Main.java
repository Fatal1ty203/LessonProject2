package hw.homework_stream_part2.task4;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Double> doubles = List.of(generateRandom(),generateRandom(),generateRandom(),
                generateRandom(),generateRandom(),generateRandom(),
                generateRandom(),generateRandom(),generateRandom());
        System.out.println(doubles);
        System.out.println(doubles.stream().mapToDouble(Double::doubleValue).sum());
    }

    public static double generateRandom(){
        Random random = new Random();
        return (( random.nextInt(100 )) + random.nextDouble());
    }
}
