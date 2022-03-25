package lessons.lesson45_account.ex2_toMap;



import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Есть список уникальных логинов и их платежей
        //Сконвертировать список в map
//        List<Payment> paymentList = new ArrayList<>();
//        String s = "log";
//        Random rnd = new Random();
//        for (int i = 0; i < 10; i++) {
//            String login = s+i;
//            int sum = rnd.nextInt(20)+10;
//            paymentList.add(new Payment(login, sum));
//        }
//
//        Map<String, Integer> map = paymentList.stream().collect(Collectors.toMap(payment -> payment.login, payment -> payment.sum));
//        System.out.println(map);

        //Сделать карту, логины в списке могут пвоторяться
        //В этом случае надо складывать суммы под одним логином
        List<Payment> paymentList = new ArrayList<>();
        String s = "log";
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            String login = s+rnd.nextInt(5);
            int sum = rnd.nextInt(20)+10;
            paymentList.add(new Payment(login, sum));
        }
        Map<String, Integer> map = paymentList.stream().collect(Collectors.toMap(payment -> payment.login,
                payment -> payment.sum,
                (v1,v2)->v1+v2));
        //v1 - текущее значение под ключом
        //v2 - Новое значение под ключом

        System.out.println(map);

    }
}
