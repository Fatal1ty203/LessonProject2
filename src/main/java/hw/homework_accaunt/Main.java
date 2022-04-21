package hw.homework_accaunt;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Payment> paymentList = new ArrayList<>();
        String s = "log";
        Random rnd = new Random();
//        for (int i = 0; i< 10; i++){
//            String login = s+rnd.nextInt(5);
//            int sum = rnd.nextInt(20)+10;
//            paymentList.add(new Payment(login, sum));
//        }
        //0 - начальное значение, типа i = 0
        //i->i+1 - то, что будем делать с переменной i в конце типа каждого шага цикла (то есть увеличивать на +1)
        //limit(10) - будет сделано 10 шагов цикла
        //foreach - что делаем на каждом шаге цикла
        Stream.iterate(0, i->i+1)
                .limit(10)
                .forEach(i->{
                    String login = s+rnd.nextInt(5);
                    int sum = rnd.nextInt(20)+10;
                    paymentList.add(new Payment(login, sum));
                });


//        paymentList.forEach(System.out::println);
        PaymentAgregator paymentAgregator = new PaymentAgregator(paymentList);
        Map<String, Integer> result = paymentAgregator.spliterator();
        System.out.println("Result: ");
        System.out.println(result);
    }
}

class PaymentAgregator{

    List<Payment> paymentList;
    ExecutorService executor = Executors.newFixedThreadPool(8); // делит на 8 потоков

    public PaymentAgregator(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Map<String, Integer> spliterator() throws ExecutionException, InterruptedException {
        int starIndex = 0;
        int endIndex = starIndex+8;
        List<Future<Map<String, Integer>>> list = new ArrayList<>();

        while (starIndex < paymentList.size()) {
            ArrayList<Payment> paymentPrice = new ArrayList<>();
            for (int i = starIndex; i < endIndex && i < paymentList.size(); i++){
                paymentPrice.add(paymentList.get(i));
            }
            Callable<Map<String, Integer>> callable = ()->{
                Thread.sleep(100);
                Map<String, Integer> mapPay = paymentPrice.stream()
                        .collect(Collectors.toMap(payment -> payment.login , payment -> payment.sum,(sum1 ,sum2) -> sum1+sum2));
                return mapPay;
            };
            Future<Map<String, Integer>> result = executor.submit(callable);
            list.add(result);
            starIndex = endIndex;
            endIndex += 8;
        }
        executor.shutdown();
        Map<String, Integer> totalMap = new HashMap<>();
        for (Future<Map<String, Integer>> future : list){
            Map<String,Integer> map = future.get();
            Set<String> keys = map.keySet();
            for (String key : keys){
                if (totalMap.containsKey(key)){
                    totalMap.put(key, totalMap.get(key) + map.get(key));
                }else {
                    totalMap.put(key,map.get(key));
                }
            }
        }
        return totalMap;
    }

}

class Payment{

    String login;
    int sum;

    public Payment(String login, int sum) {
        this.login = login;
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "login='" + login + '\'' +
                ", sum=" + sum +
                '}';
    }
}
