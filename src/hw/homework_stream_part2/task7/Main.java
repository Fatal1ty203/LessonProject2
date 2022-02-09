package hw.homework_stream_part2.task7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("Vasya", "Petya", "Kompluhter", "Sobaka", "Dungeon master","Mafyna");
        String max = Collections.max(list, Comparator.comparing(String::length));
        System.out.println(max);
    }
}
