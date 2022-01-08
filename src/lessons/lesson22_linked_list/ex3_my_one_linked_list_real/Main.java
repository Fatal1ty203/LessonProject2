package lessons.lesson22_linked_list.ex3_my_one_linked_list_real;

public class Main {
    public static void main(String[] args) {
        MyOneLinkedList<String> list = new MyOneLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");


        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.contains("one"));
        System.out.println(list.contains("three"));
        System.out.println(list.contains("four"));
        System.out.println(list.contains("five"));


        //f(x) -> f(n) -> O(n) - назвается это О нотацией или просто временная сложность алгоритма (эффективность алгоритма)

        //O(1) - время выполнения алгоритма не зависит от кол-ва элементов  в коллекции, то есть оно константно
        //O(n) - время выполнения алгоритма зависит от кол-во элементов в коллекции. Чем их больше, тем медленнее



        //ArrayList
        //insert в начало - O(n)
        //insert в середину - O(n)
        //insert в конец - в среднем можно сказать O(n), но по сколько перекопирование происходит нечастно,то O(1)
        //get - O(1)

        //LinkedList
        //insert в начало - O(1)
        //insert в середину - O(n)
        //insert в конец - O(1)
        //get первого элемента - O(1)
        //get последнего элемента - O(1)
        //get остальных элеметов - O(n)




    }

}
