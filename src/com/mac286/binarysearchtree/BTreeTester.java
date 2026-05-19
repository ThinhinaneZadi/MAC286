package com.mac286.binarysearchtree;

public class BTreeTester {
    public static void main(String[] args) {
        BTree<Integer, String> T = new BTree<>();
        T.insert(25, "Hi25");
        T.insert(13, "Hi13");
        T.insert(28, "H28");
        T.insert(17, "Hi17");
        T.insert(21, "Hi21");
        T.insert(15, "Hi15");
        T.insert(12, "Hi12");
        T.insert(30, "Hi30");
        T.insert(26, "Hi26");
        T.insert(35, "Hi35");
        T.insert(31, "Hi31");
        T.preOrderTraversal();
        T.inOrderTraversal();
        T.postOrderTraversal();
        System.out.println("Delete 28: " + T.delete(28));
        T.preOrderTraversal();
    }
}