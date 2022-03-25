package lessons.lesson45_account.ex1_task;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Payment> paymentList = new ArrayList<>();
        String s = "log";
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            String login = s+rnd.nextInt(5);
            int sum = rnd.nextInt(20)+10;
            paymentList.add(new Payment(login, sum));
        }
        paymentList.forEach(System.out::println);
        PaymentAgregator paymentAgregator = new PaymentAgregator(paymentList);
        Map<String, Integer> result = paymentAgregator.spliterator();
        System.out.println("result:");
        System.out.println(result);

    }

}



class PaymentAgregator{
    List<Payment> paymentList;
    ExecutorService executorService = Executors.newFixedThreadPool(8);
    public PaymentAgregator(List<Payment> paymentList) {

        this.paymentList = paymentList;
    }

    public Map<String, Integer> spliterator() throws ExecutionException, InterruptedException {
        int startIndex = 0;
        int endIndex = startIndex+8;
        List<Future<Map<String, Integer>>> resultList = new ArrayList<>();
        while(startIndex<paymentList.size()) {
            //Делим все платежи на 8 кусочков
            ArrayList<Payment> paymentPiece = new ArrayList<>();
            for (int i = startIndex; i < endIndex && i< paymentList.size(); i++) {
                paymentPiece.add(paymentList.get(i));
            }

            Callable<Map<String, Integer>> callable = ()->{
                Thread.sleep(1000);
                Map<String, Integer> mapPay = paymentPiece.stream()
                        .collect(Collectors.toMap(payment -> payment.login, payment -> payment.sum, (sum1, sum2) -> sum1 + sum2));
                return mapPay;
            };
            Future<Map<String, Integer>> result = executorService.submit(callable);
            resultList.add(result);
            startIndex = endIndex;
            endIndex += 8;
        }
        executorService.shutdown();
        Map<String, Integer> totalMap = new HashMap<>();
        for (Future<Map<String, Integer>> future : resultList){

            Map<String, Integer> map = future.get();
            Set<String> keys = map.keySet();
            for (String key : keys) {
                //если в totalMap уже есть ключ key
                if(totalMap.containsKey(key)){
                    //берем значение из totalMap и складываем со значением из map
                    totalMap.put(key, totalMap.get(key)+map.get(key));
                }else{
                    //Если ключа еще нет, то просто создаем его
                    totalMap.put(key, map.get(key));
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
