package lessons.lesson20_iterator.ex3_remove_from_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Попытаемся удалить элементы из списка, равные чилу 3 в процессе цикла for each
        List<Integer> list = new ArrayList<>(List.of(2,4,3,3,5,3,6));

        //ИЗ ЦИКЛА FOR EACH НЕЛЬЗЯ УДАЛЯТЬ ЭЛЕМЕНТЫ В ПРОЦЕССЕ ЦИКЛА
//        for(int val : list){
//            if(val == 3){
//                list.remove(val); //будет java.util.ConcurrentModificationException
//            }
//        }

        //2,4,3,3,5,3,6
        //2,4,3,5,3,6
        //2,4,5,3,6
        //ТЕМ НЕ МЕНЕЕ, УДАЛЕНИЕ МОЖНО РЕАЛИЗОВАТЬ В ЦИКЛЕ
//        for (int i = 0; i < list.size(); ) {
//            if(list.get(i) == 3){
//                list.remove(i);
//            }else{
//                i++; //из-за смещения элементов списка влево индекс увеличиваем только в случае, если не удаляли элемент
//            }
//        }
//        System.out.println(list);


        //Удаление через итератор
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(next == 3){
                iterator.remove();
            }
        }

        System.out.println(list);


    }
}
