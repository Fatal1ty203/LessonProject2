package lessons.lesson22_linked_list.ex3_my_one_linked_list_real;

//односвязный список - ссылка есть только на следующий элемент
public class MyOneLinkedList<T> {
    private Node<T> head; //голова списка (первый элемент)
    private Node<T> tail; //хвост списка (последний элемент)
    private int size;
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
        size++;
    }


    public T get(int index){
        if(index<0 || index >= size)
            throw new IndexOutOfBoundsException();
        //запукаем цикл в поиска элемента под индексом
        Node<T> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.value;
    }

    public boolean contains(T val){
        if(size() == 0) return false;
        Node<T> currentNode = head;
        for (int i = 0; i < size(); i++) {
            if(val.equals(currentNode.value)) return true;
            currentNode = currentNode.nextNode;
        }
        return false;
    }



    public int size() {
        return size;
    }

    private static class Node<T>{
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
