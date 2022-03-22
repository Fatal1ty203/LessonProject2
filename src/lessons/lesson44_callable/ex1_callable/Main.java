package lessons.lesson44_callable.ex1_callable;

import java.util.Arrays;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Есть массив, найти в одном потоке - минимальный элемент, в другом - максимальный
        //В конце поисков сложить максимум с минимумом
        int[] arr = {1,5,2,7};
        MyCallable call_max = new MyCallable(arr, true);
        MyCallable call_min = new MyCallable(arr, false);
        //создаем пул на 2 потока
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> maxFuture = executorService.submit(call_max);
        Future<Integer> minFuture = executorService.submit(call_min);
        executorService.shutdown(); //даем команду потокам из пула завершить свою работу
        Integer max = maxFuture.get(); //main поток будет ждать окончания результат методов гет
        Integer min = minFuture.get();
        System.out.println("max = "+max);
        System.out.println("min = "+min);
        System.out.println(max+min);



    }
}
class MyCallable implements Callable<Integer> {
    int[] arr;
    boolean findMax;

    public MyCallable(int[] arr, boolean findMax) {
        this.arr = arr;
        this.findMax = findMax;

    }


    @Override
    public Integer call() throws Exception {
        TimeUnit.SECONDS.sleep(3);
        if(findMax){
            return Arrays.stream(arr).max().orElse(0);
        }else{
            return Arrays.stream(arr).min().orElse(0);
        }

    }
}

