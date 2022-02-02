package hw.homework_wildcards.taskOne;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> ints = List.of(10, 20, 30);
        System.out.println(sum(ints));


    }
    public static double sum(List<? extends Number> numerics){
        double num1 = 0;
        for (Number d : numerics){
            num1 += d.doubleValue();
        }
        return num1;
    }

}
