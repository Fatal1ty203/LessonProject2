package lessons.lesson22_linked_list.ex4_double_linked_list;

//односвязный список - ссылка есть только на следующий элемент
public class MyDoubleLinkedList<T> {
    private Node<T> head; //голова списка (первый элемент)
     Node<T> tail; //хвост списка (последний элемент)
    private int size;
    public void add(T t){
        Node<T> node = new Node(t);
        //если список пуст, то делаем новый элемент и головой и хвостом
        if(head == null){
            head = node;
            tail = node;
        }else{
            //если список не пуст, то новый элемент нужно сделать новый хвостом
            node.prevNode = tail; //у нового элемента предыдущий будет старый хвост
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

    public boolean add(int index, T val){
        if(index<0 || index >= size()) return false;
        if(size() == 0){
            add(val); //если нет элементов, то добавляем элемент в конец списка
        }else{
            Node<T> newNode = new Node<>(val);
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.nextNode;
            }
            //если вставка в голову
            if(currentNode == head){
                //говорим, что после нового элемента будет идти старая голова
                newNode.nextNode = head;
                head.prevNode = newNode; //у головы предыдущим будет новый узел
                head = newNode; //делаем новый элемент новой головой
            }else if(currentNode == tail){
                //когда делаем вставку на индекса хвоста
                Node<T> prevNode = currentNode.prevNode; //получаем предыдущий, который перед хвостом
                prevNode.nextNode = newNode; //после предыдущего будет идти новый
                newNode.prevNode = prevNode; //перед новым будет предыдущий
                newNode.nextNode = tail; //после нового будет идти старый хвост
                tail.prevNode = newNode; //перед хвостом будет новый
            }else{
                //когда делаем вставку в середину списка
                Node<T> prevNode = currentNode.prevNode; //получаем предыдущий, который перед тем, на который хотим сделать вставку
                prevNode.nextNode = newNode; //после предыдущего будет идти новый
                newNode.prevNode = prevNode; //перед новым будет предыдущий
                newNode.nextNode = currentNode; //после нового будет идти тот, который раньше стоял на этом индексе
                currentNode.prevNode = newNode;

            }
        }
        size++;
        return true;
    }

    public int size() {
        return size;
    }

     static class Node<T>{
        T value; //хранит значение текущего элемента
        Node<T> nextNode; //хранит следующий элемент за текущим
        Node<T> prevNode; //хранит предыдущий элемент

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
