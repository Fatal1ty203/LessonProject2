package hw.homework8.Comparable.RealEstate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<RealEstate> realEstates = Arrays.asList(new RealEstate(100, 50, 3),
                new RealEstate(100, 60, 2), new RealEstate(100, 50, 4));
        Collections.sort(realEstates);
        System.out.println(realEstates);



    }
}
