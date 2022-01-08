package lessons.lesson25_binaryTree.ex4_printTreee;

import lessons.lesson25_binaryTree.MyBinaryTree;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer, Integer> tree = new MyBinaryTree<>();
        tree.put(8,8);
        tree.put(3,8);
        tree.put(10,8);
        tree.put(1,8);
        tree.put(6,8);
        tree.put(4,8);
        tree.put(7,8);
        tree.put(14,8);
        tree.put(13,8);
        tree.printDepth();
    }
}
