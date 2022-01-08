package lessons.lesson25_binaryTree;

//K extends Comparable<K> означает, что тип K (например, класс Fruit) будет реализовыывать интерфейс Comparable<K> (Comparable<Fruit>)
public class MyBinaryTree<K extends Comparable<K>, V> {

    public Node<K, V> root;


    public void put(K k, V v) {
        Node newNode = new Node(k, v);
        if (root == null) root = newNode;
        else recursAdd(root, newNode);

    }

    public V get(K key) {
        return recursGet(root, key);
    }

    //обход в глубину по левой стороне
    public void printDepth(){
        printDepthRecurs(root);
    }

    private void printDepthRecurs(Node<K,V> currentNode){
        if(currentNode!=null){
            //Делаем левый потоком текущим узлом
            printDepthRecurs(currentNode.leftNode);
            //Выводим элементы только после того, когда мы достигли самого левого (самого маленького значения) потомка
            System.out.println(currentNode.k+" "+currentNode.v);
            //когда обошли всех левых потомков currentNode, начинам обходить его правых потомков
            printDepthRecurs(currentNode.rightNode);
        }
    }



    private V recursGet(Node<K, V> currentNode, K key) {
        //если текущий узел null, значит, искомого ключа нет в дереве
        if (currentNode == null) return null;
            //если нашли искомый узел по ключу, то возврвщаем значение под ключом
        else if (key.compareTo(currentNode.k) == 0) return currentNode.v;
            //если ключ больше текущего узла, то делаем правый потомок текущим узлом,
            // чтобы на след шаге рекурсии сравнивать ключ с ним
        else if (key.compareTo(currentNode.k) > 0) return recursGet(currentNode.rightNode, key);
            //если ключ меньше текущего узла, то делаем левый потомок текущим узлом,
            // чтобы на след шаге рекурсии сравнивать ключ с ним
        else return recursGet(currentNode.leftNode, key);


    }

    private void recursAdd(Node<K, V> currentNode, Node<K, V> newNode) {

        //если добавляемый ключ уже существует, то просто перезаписываем значение под ключом
        if (newNode.k.compareTo(currentNode.k) == 0) {
            currentNode.v = newNode.v;
            return;
        }

        //если ключ нового узла больше ключа текущего узнал, то новый надо добавить справа, если справа свободно
        if (newNode.k.compareTo(currentNode.k) > 0) {
            //если место справа свободно
            if (currentNode.rightNode == null) {
                currentNode.rightNode = newNode;
            } else {
                //если оно занято, то делает правый узел-наследник текущим узлом (currentNode)
                recursAdd(currentNode.rightNode, newNode);
            }
        } else {
            //если место слева свободно
            if (currentNode.leftNode == null) {
                currentNode.leftNode = newNode;
            } else {
                //если оно занято, то делает левый узел-наследник текущим узлом (currentNode)
                recursAdd(currentNode.leftNode, newNode);
            }
        }
    }


    public class Node<K, V> {
        public K k;
        public V v;
        public Node<K, V> leftNode;
        public Node<K, V> rightNode;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

}
