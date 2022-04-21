package lessons.lesson22_linked_list.ex2_my_one_linked_list_demo_detailed;

public class Main {
    public static void main(String[] args) {
        MyOneLinkedList<String> list = new MyOneLinkedList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

//        System.out.println(list.head.value);
//        System.out.println(list.head.nextNode.value);
//        System.out.println(list.head.nextNode.nextNode.value);
//        System.out.println(list.head.nextNode.nextNode.nextNode.value);

        //как зациклить вывод элементов?
//        MyDoubleLinkedList.Node<String> currentNode = list.head;
//        System.out.println(currentNode.value);
//        currentNode = currentNode.nextNode; //теперь в currentNode находится второй элемент
//        System.out.println(currentNode.value);
//        currentNode = currentNode.nextNode; //теперь в currentNode находится третий элемент
//        System.out.println(currentNode.value);
//        currentNode = currentNode.nextNode; //теперь в currentNode находится четвертый элемент
//        System.out.println(currentNode.value);
//        currentNode = currentNode.nextNode; //теперь в currentNode равен null, так как четвертый элемент был последним
//        System.out.println(currentNode);
//
        //перезапишем все это через цикл
        MyOneLinkedList.Node<String> currentNode = list.head;
        while (currentNode!=null){
            System.out.println(currentNode.value);
            currentNode = currentNode.nextNode;
        }



    }

}
