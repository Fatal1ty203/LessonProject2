package hw.homework8.Comparable.Planet;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Planet> planets = Arrays.asList(new Planet("Меркурий", 2.5),
                new Planet("Венера", 15.1), new Planet("Земля", 17.5), new Planet("Марс", 14.1));
        Collections.sort(planets);
        System.out.println(planets);
    }
}
