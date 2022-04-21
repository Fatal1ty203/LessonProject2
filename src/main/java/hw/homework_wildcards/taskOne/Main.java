package hw.homework_wildcards.taskOne;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = List.of(10, 20, 30);
        System.out.println(sum(ints));
        List<Double> doubles = List.of(2.5d, 4d, 3.5d);
        System.out.println(sum(doubles));



    }
    public static double sum(List<? extends Number> numerics){
        double num1 = 0;
        for (Number d : numerics){
            num1 += d.doubleValue();
        }
        return num1;
    }

}
