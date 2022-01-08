package lessons.lesson22_linked_list.ex2_my_one_linked_list_demo_detailed;

//односвязный список - ссылка есть только на следующий элемент
public class MyOneLinkedList<T> {
    Node<T> head; //голова списка (первый элемент)
    private Node<T> tail; //хвост списка (последний элемент)

    public void add(T t){
        Node<T> node = new Node(t);
        //если список пуст, то делаем новый элемент и головой и хвостом
        if(head == null){
            head = node;
            tail = node;
        }else{
            //если список не пуст, то новый элемент нужно сделать новый хвостом
            tail.nextNode = node; //связываем старый хвост с новым элементом
            tail = node; //делаем новый элемент новым хвостом
        }
    }


     static class Node<T>{
        T value; //хранит значение текущего элемента
        Node<T> nextNode; //хранит следующий элемент за текущим

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
