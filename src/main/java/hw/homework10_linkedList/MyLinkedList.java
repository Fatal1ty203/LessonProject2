package hw.homework10_linkedList;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void add(T t){
        Node<T> node = new Node<>(t);
        if (head == null){
            head = node;
            tail = node;
        }else {
            node.prevNode = tail;
            tail.nextNode = node;
            tail = node;
        }
        size++;
    }

    public boolean add(int index, T value){
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        if (size() == 0){
            add(value);
        }else {
            Node<T> newNode = new Node<>(value);
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++){
                currentNode = currentNode.nextNode;
            }
            if (currentNode == head){
                newNode.prevNode = head;
                head.nextNode = newNode;
                head = newNode;
            }else if (currentNode == tail){
                Node<T> prevNode = currentNode.prevNode;
                prevNode.nextNode = newNode;
                newNode.prevNode = prevNode;
                newNode.nextNode = tail;
                tail.prevNode = newNode;
            }else {
                Node<T> prevNode = currentNode.prevNode;
                prevNode.nextNode = newNode;
                newNode.prevNode = prevNode;
                newNode.nextNode = currentNode;
                currentNode.prevNode = newNode;
            }
        }
        size++;
        return true;

    }

    Node<T> node(int index) {
        // assert isElementIndex(index);

        if (index < (size >> 1)) {
            Node<T> x = head;
            for (int i = 0; i < index; i++)
                x = x.nextNode;
            return x;
        } else {
            Node<T> x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prevNode;
            return x;
        }
    }

    public T get(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (more(index)){
            Node<T> currentNode = head;
            for (int i = 0; i < index; i++){
                currentNode = currentNode.nextNode;
            }
            return currentNode.value;
        }else {
            Node<T> currentNode = tail;
            for (int i = size() -1; i > index; i --){
               currentNode = currentNode.prevNode;
            }
            return currentNode.value;
        }
    }

    public boolean contains(T value){
        if (size() == 0) return false;
        Node<T> currentNode = head;
        for (int i = 0; i < size(); i++){
            if (value.equals(currentNode.value)) return true;
            currentNode = currentNode.nextNode;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean more(int index){
        if (size() % 2 == 0){
            return index < (size()/2);
        }else {
            return index < (size()/2 +1);
        }
    }


    private static class Node<T>{
        T value;
        Node<T> nextNode;
        Node<T> prevNode;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

}
