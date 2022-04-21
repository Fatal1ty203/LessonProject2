package hw.homework12_binaryTree;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class homeBinaryTree<K extends Comparable<K>, V> {
    //Создаем корень бинарного дерева
    public Node<K,V> root;
    private Set<K> keySet;
    private LinkedHashSet<K> ks;
    private List<V> val;
    private List<Node<K,V>> eS;

    public V get(K key){
        //передаем наш корень root как точку отправления рекурсии метода и ключ как искомое значение
       return resourceGet(root,key);
    }

    public void put(K k, V v){
        Node newNode = new Node<>(k,v); // создаем новы Node со значением "k" и "v"
        if (root==null) root = newNode; // проверяем, если наш корень null, то наш новый Node становится корнем
        else resourceAdd(root,newNode); // или же, запускаем рекурсию метода
    }

    public LinkedHashSet<K> keySet(){
        ks = new LinkedHashSet<>();
        return resourceKeySet(root);
    }

    public LinkedHashSet<K> keySet(K key){
        ks = new LinkedHashSet<>();
        return resourceKeySet(resourceGetK(root,key));
    }

    public List<V> values(){
        val = new LinkedList<>();
        return resourceValues(root);
    }

    public List<Node<K,V>> entrySet(){
        eS = new LinkedList<>();
        return resourceEntry(root);
    }

    private List<Node<K,V>> resourceEntry(Node<K,V> currentNode){
        if (currentNode!=null){
            resourceEntry(currentNode.leftNode);
            eS.add(currentNode);
            resourceEntry(currentNode.rightNode);
        }
        return eS;
    }

    private List<V> resourceValues(Node<K, V> currentNode){
        if (currentNode!=null){
            resourceValues(currentNode.leftNode);
            val.add(currentNode.v);
            resourceValues(currentNode.rightNode);
        }
        return val;
    }

    private LinkedHashSet<K> resourceKeySet(Node<K,V> currentNode){
        if (currentNode!=null){
            resourceKeySet(currentNode.leftNode);
            ks.add(currentNode.k);
            resourceKeySet(currentNode.rightNode);
        }
        return ks;
    }

    private Node<K,V> resourceGetK(Node<K,V> currentNode, K key){
        if (currentNode == null) return null;
        else if ((key.compareTo(currentNode.k)) == 0) return currentNode;
        else if ((key.compareTo(currentNode.k)) > 0) return resourceGetK(currentNode.rightNode, key);
        else return resourceGetK(currentNode.leftNode, key);
    }

    private V resourceGet(Node<K,V> currentNode, K key){
        if (currentNode == null) return null; //ключ не найден
        else if ((key.compareTo(currentNode.k)) == 0) return currentNode.v; // ключ и есть наш currentNode
        else if ((key.compareTo(currentNode.k)) > 0) return resourceGet(currentNode.rightNode,key); // если ключ больше текущего узла, значит правый узел теперь currentNode
        else return resourceGet(currentNode.leftNode,key); // ключ(key) меньше нашего узла CurrentNode, вызываем метод у левого Node
    }

    private void resourceAdd(Node<K,V> currentNode, Node<K,V> newNode){
        if (newNode.k.compareTo(currentNode.k)==0) { // Ключ нашего newNode совпадает с ключом currentNode
            currentNode.v = newNode.v; // Просто перезаписываем значение currentNode на newNode
        }
        if (newNode.k.compareTo(currentNode.k) > 0) {
            if (currentNode.rightNode == null) {
                currentNode.rightNode = newNode;
            } else resourceAdd(currentNode.rightNode, newNode);
        }else {
            if (currentNode.leftNode == null){
                currentNode.leftNode = newNode;
            }else resourceAdd(currentNode.leftNode, newNode);
        }
    }

    public class Node<K,V>{
        public K k;
        public V v;
        public Node<K,V> leftNode;
        public Node<K,V> rightNode;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public String toString() {
            return "{" + k +
                    ", " + v +
                    '}';
        }
    }

}


