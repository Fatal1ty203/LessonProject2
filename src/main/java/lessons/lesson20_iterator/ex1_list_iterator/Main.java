package lessons.lesson20_iterator.ex1_list_iterator;

import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Итератор позволяет перебрать элементы из списка
        List<String> strings = List.of("one", "two", "three");
        Iterator<String> iterator = strings.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
