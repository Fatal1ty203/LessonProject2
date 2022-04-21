package hw.homework12_binaryTree;

public class Main {
    public static void main(String[] args) {
        homeBinaryTree<Integer,Integer> homeBinaryTree = new homeBinaryTree<>();
        homeBinaryTree.put(10,20);
        homeBinaryTree.put(90,20);
        homeBinaryTree.put(50,20);
        homeBinaryTree.put(9,20);
        homeBinaryTree.put(35,20);
        System.out.println(homeBinaryTree);

        System.out.println(homeBinaryTree.keySet());
        System.out.println(homeBinaryTree.keySet(90));
        System.out.println(homeBinaryTree.values());
        System.out.println(homeBinaryTree.entrySet().toString());
    }
}
