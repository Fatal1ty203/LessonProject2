package hw.homework_stream_part2.task3;

import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Temperature> list = List.of(new Temperature(generateRandom()),
                new Temperature(generateRandom()), new Temperature(generateRandom()),
                new Temperature(generateRandom()), new Temperature(generateRandom()),
                new Temperature(generateRandom()), new Temperature(generateRandom()));

        list.forEach(System.out::println);
        list.stream().mapToDouble(Temperature::getAverageTemperature).average().stream().forEach(System.out::println);
    }

    public static double generateRandom(){
        Random random = new Random();
        return (( random.nextInt(45 )) + random.nextDouble());
    }
}
