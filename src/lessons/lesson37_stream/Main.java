package lessons.lesson37_stream;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Сконвертировать числа из типа string в int
        List<String> list = List.of("10", "one", "20");
        List<Integer> list2 = list.stream()
                .filter(val -> val.matches("\\d+"))
                .map(val -> Integer.parseInt(val))
                .collect(Collectors.toList());

//        System.out.println(list2);


        //Есть массив товаров, сформировать из него список наименований товаров, чья цена дешелве 200


        class Tovar{
            String name;
            int price;

            public Tovar(String name, int price) {
                this.name = name;
                this.price = price;
            }
        }
        List<Tovar> listTOvar = List.of(new Tovar("t1", 100),
                new Tovar("t2", 300),
                new Tovar("t3", 150));
        List<String> stringList = listTOvar.stream()
                .filter(val -> val.price < 200)
                .map(val -> val.name)
                .collect(Collectors.toList());
        System.out.println(stringList);
    }

}
