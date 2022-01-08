package lessons.lesson25_binaryTree.ex1;

import lessons.lesson25_binaryTree.MyBinaryTree;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<String, Integer> tree1 = new MyBinaryTree<>();
        tree1.put("one", 5);
        tree1.put("two", 2);
        tree1.put("three", 3);
        tree1.put("three", 5);


        System.out.println(tree1.root.k+" "+tree1.root.v);
        System.out.println(tree1.root.rightNode.k+" "+tree1.root.rightNode.v);
        System.out.println(tree1.root.rightNode.leftNode.k+" "+tree1.root.rightNode.leftNode.v);

        System.out.println("Получим значения через get:");
        System.out.println(tree1.get("one"));
        System.out.println(tree1.get("two"));
        System.out.println(tree1.get("three"));

//        Set<String> keys = tree1.keySet();
//        List<String> values = tree1.values();


    }
}


