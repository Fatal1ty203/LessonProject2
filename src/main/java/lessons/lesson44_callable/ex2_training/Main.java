package lessons.lesson44_callable.ex2_training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Есть массив на 100 элементов. Разбить массив на 4 части, чтобы искать сумму числе параллельно
        int[] arr = new Random()
                .ints(5_000, 1, 3)
                .toArray();
        //System.out.println(Arrays.toString(arr));
        long start = System.currentTimeMillis();
        //int sum = findSum(arr); //8628
        int sum = SumFinder.findSumParallel(arr, 4); //2446
        long finish = System.currentTimeMillis();
        System.out.println("sum = "+sum); //15-17
        System.out.println("time = "+(finish-start));





    }
    public static int findSum(int[] arr) throws InterruptedException {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            Thread.sleep(1);
            sum+=arr[i];
        }
        return sum;
    }
}

class SumFinder{

    /**
     * Ищет сумму в массиве паралелльно
     * @param arr массив
     * @param divider на сколько частей делить массив
     * @return сумму
     */
    public static int findSumParallel(int[] arr, int divider) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        ArrayList<Future<Integer>> futureList = new ArrayList<>();
        int size = arr.length/divider;
        //1 2 3 4 5 6 7 8 9 10

        int startIndex = 0;
        while(startIndex < arr.length) {
            //8 - 10
            ArrayList<Integer> list = new ArrayList<>();
            Callable<Integer> call  = ()->{
                int sum = 0;
                for (Integer integer : list) {
                    Thread.sleep(1);
                    sum+=integer;
                }
                return sum;
            };
            for (int i = startIndex; i < size + startIndex && i < arr.length; i++) {
                list.add(arr[i]);
            }
            Future<Integer> future = executorService.submit(call);
            futureList.add(future);
            startIndex+=size;
        }
        executorService.shutdown();
        int sum = 0;
        for (int i = 0; i < futureList.size(); i++) {
            Future<Integer> future = futureList.get(i);
            sum += future.get();
        }
        return sum;

    }
}
