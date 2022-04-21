package lessons.lesson24_linkedHashSet;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        //1. LinkedHashSet хранит данные в хэш таблице, то есть как и HashSet
        //2. Но дополнитлеьно к HashSet LinkedHashSet имеет дополнительное поле - голову связного списка, который позволяет
        //сохранить порядок добавления элементов

        LinkedHashSet<String> strings = new LinkedHashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("four");
        strings.add("five");


        strings.forEach(System.out::println);
    }
}
