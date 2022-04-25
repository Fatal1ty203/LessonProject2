package hw.VigenereCipher;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.LongUnaryOperator;

public class Partition {
     List<String> list;
     List<Integer> chipWord;
     static VigenereService vigenereService = new VigenereService();

    public Partition(List<String> list, List<Integer> chipWord) {
        this.list = list;
        this.chipWord = chipWord;
    }

    public static void partition(List<String> list, List<Integer> chipWord){
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        int startIndex = 0;
        while (startIndex < list.size()){
            LinkedList<String> linkedList = new LinkedList<>();
            Callable<List<String>> callable = () -> {
                LinkedList<String> linkedList1 = (LinkedList<String>) vigenereService.ciphering1(list,chipWord);
                return linkedList1;
            };
        }
    }

//    int startIndex = 0;
//        while(startIndex < arr.length) {
//            //8 - 10
//            ArrayList<Integer> list = new ArrayList<>();
//            Callable<Integer> call  = ()->{
//                int sum = 0;
//                for (Integer integer : list) {
//                    Thread.sleep(1);
//                    sum+=integer;
//                }
//                return sum;
//            };
//            for (int i = startIndex; i < size + startIndex && i < arr.length; i++) {
//                list.add(arr[i]);
//            }
//            Future<Integer> future = executorService.submit(call);
//            futureList.add(future);
//            startIndex+=size;
//        }
//        executorService.shutdown();
//        int sum = 0;
//        for (int i = 0; i < futureList.size(); i++) {
//            Future<Integer> future = futureList.get(i);
//            sum += future.get();
//        }
//        return sum;
}
