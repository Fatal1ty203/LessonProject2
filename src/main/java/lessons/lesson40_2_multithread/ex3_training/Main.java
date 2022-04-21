package lessons.lesson40_2_multithread.ex3_training;

import java.util.Arrays;
import java.util.Random;

public class Main {
    static int sum = 0;
    static int max = 0;
    public static void main(String[] args) throws InterruptedException {
        //В одном потоке найти сумму элементов массива, а в другом - его макс число
        int[] ints = new Random().ints(100_000_000, 1, 100).toArray();

        Runnable run1 = ()->{
            sum = Arrays.stream(ints).sum();
            System.out.println("sum");
        };

        Runnable run2 = ()->{
            max = Arrays.stream(ints).max().orElse(0);
            System.out.println("max");
        };

        Thread th1 = new Thread(run1);
        Thread th2 = new Thread(run2);
        long start = System.currentTimeMillis();
//        th1.start();
//        th2.start();
        sum = Arrays.stream(ints).sum();
        max = Arrays.stream(ints).max().orElse(0);

        th1.join(); //join заставим главный поток ждать, пока th1 закончит свою работу
        th2.join(); //join заставим главный поток ждать, пока th2 закончит свою работу
        long end = System.currentTimeMillis();

        System.out.println("sum = "+sum);
        System.out.println("max = "+max);
        System.out.println("time = "+(end-start));
        // 80
        //100



    }
}
