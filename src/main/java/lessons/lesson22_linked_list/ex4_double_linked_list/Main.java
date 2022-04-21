package lessons.lesson22_linked_list.ex4_double_linked_list;

public class Main {
    public static void main(String[] args) {
        MyDoubleLinkedList<String> list = new MyDoubleLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        //делаем вставку
        list.add(1, "1.5");
        list.add(0, "zero");
        list.add(list.size()-1, "five");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }



        //Проверяем ход с хвоста к голове
        System.out.println("В обратном порядке:");
        MyDoubleLinkedList.Node<String> currentNode = list.tail;
        while(currentNode!=null){
            System.out.println(currentNode.value);
            currentNode = currentNode.prevNode;
        }



    }

}
