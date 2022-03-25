package lessons.lesson45_account.ex3_toMap2;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Сделать карту, где ключ - это число, а значение - кол-во раз сколко оно встречается в списке
        List<Integer> list = List.of(1,2,1,3,4,2,3,3,3,3);
        Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(val -> val, val -> 1, (val1, val2) -> val1 + val2));
        collect.entrySet().forEach(entry-> System.out.println(entry.getKey()+" "+entry.getValue()));



    }
}
