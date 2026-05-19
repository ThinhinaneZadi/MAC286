package com.mac286.binarysearchtree;

public class BTree <K extends Comparable, T>{
    private class Node<D extends Comparable, F>{
        private D key;
        private F data;
        private Node<D, F> left, right;

        public Node(){
            key = null;
            data = null;
            left = right = null;
        }
        public Node(D k, F d){
            key = k;
            data = d;
            left = right = null;
        }
        public D getKey() {
            return key;
        }
        public void setKey(D key) {
            this.key = key;
        }
        public F getData() {
            return data;
        }
        public void setData(F data) {
            this.data = data;
        }
        public Node<D, F> getLeft() {
            return left;
        }
        public void setLeft(Node<D, F> left) {
            this.left = left;
        }
        public Node<D, F> getRight() {
            return right;
        }
        public void setRight(Node<D, F> right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return "(" + key +
                    " = " + data + ")";
        }
    }

    private Node<K, T> root;
    private int size;
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    public BTree(){
        root = null;
        size = 0;
    }
    public void insert(K k, T d){
        //create a Node with k and d
        Node<K, T> n = new Node<K, T>(k, d);
        if(root == null){
            root = n;
            size = 1;
            return;
        }

        //start with a temporary reference to root
        Node<K, T> temp = root;
        //forever
        while(true) {
            //if k is less than the key at temp then
            if(k.compareTo(temp.getKey()) < 0) {
                //if there is something on the left, go left
                if(temp.getLeft()!= null){
                    temp = temp.getLeft();
                    continue; //go back to while
                }
                //else add the node to the left, increase size, get out
                temp.setLeft(n);
                size++;
                return; //breaks the loop
            }else {
                //else (k is larger
                //if there is something on the right, go right
                if(temp.getRight() != null){
                    temp = temp.getRight();
                    continue;
                }
                // else add the node to the right, increase size, get out
                temp.setRight(n);
                size++;
                return;
            }
        }

    }
    //Tree traversal
    public void preOrderTraversal(){
        System.out.println("---------------PreOrder----------");
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node<K, T> n){
        if(n == null){
            return;
        }
        System.out.print("  " + n);
        //explore the left subtree
        preOrder(n.getLeft());
        //explore the right subtree
        preOrder(n.getRight());
    }
    public void inOrderTraversal(){
        System.out.println("---------------inOrder----------");
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node<K, T> n){
        if(n == null){
            return;
        }
        //explore the left subtree
        inOrder(n.getLeft());
        //visit the root
        System.out.print("  " + n);
        //explore the right subtree
        inOrder(n.getRight());
    }
    public void postOrderTraversal(){
        System.out.println("---------------postOrder----------");
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node<K, T> n){
        if(n == null){
            return;
        }
        //explore the left subtree
        postOrder(n.getLeft());
        //explore the right subtree
        postOrder(n.getRight());
        //visit the root
        System.out.print("  " + n);
    }
    //TODO: HW7
    //returns the reference to the node with key k
    private Node<K, T> find(K k){
        //start at the root
        Node<K, T> temp = root;
        //while not found
        while(temp != null) {
            //if key is same as temp, this is the node we are looking for
            if (temp.key.compareTo(k) == 0) {
                return temp;
            } else if (temp.key.compareTo(k) > 0) {
                //go to the left
                temp = temp.getLeft();
            } else {
                temp = temp.getRight();
            }
        }
        return null;
    }
    //returns refrence to smallest on Right
    private Node<K, T> smallestOnRight(Node<K, T> n){
        if(n.getRight() == null){
            return null;
        }
        //go right once, then keep going left
        Node<K, T> temp = n.getRight();
        while(temp.getLeft() != null){
            temp = temp.getLeft();
        }
        return temp;
    }
    //returns refrence to largest on left

    private Node<K, T> largestOnLeft(Node<K, T> n){
        if(n.getLeft() == null){
            return null;
        }
        //go left once, then keep going right
        Node<K, T> temp = n.getLeft();
        while(temp.getRight() != null){
            temp = temp.getRight();
        }
        return temp;
    }
    private Node<K, T> parentOf(K k){
        if(root.getKey().compareTo(k) == 0 || this.isEmpty()){
            return null;
        }
        Node<K, T> temp = root;
        while(temp != null){
            if(temp.getLeft() != null && temp.getLeft().getKey().compareTo(k) == 0){
                return temp; //temp is the parent
            }
            if(temp.getRight() != null && temp.getRight().getKey().compareTo(k) == 0){
                return temp; //temp is the parent
            }
            if(k.compareTo(temp.getKey()) < 0){
                //go to the left is there is a left
                temp = temp.getLeft();
            }else{
                temp = temp.getRight();
            }
        }
        return null;
    }

    public T delete(K k){
        Node<K, T> nodeToDelete = find(k);
        if(nodeToDelete == null) {
            return null;
        }
        //do we have a leaf
        if(nodeToDelete.getLeft() == null && nodeToDelete.getRight() == null){
            if(nodeToDelete == root){
                root = null;
                size = 0;
                return nodeToDelete.getData();
            }
            Node<K, T> parentNodeToDelete = parentOf(k);
            if(parentNodeToDelete == null){
                System.out.println("Something is wrong");
            }
            if(parentNodeToDelete.getLeft().getKey().compareTo(k) == 0){
                //the leaf is connected to the parent through the left
                size--;
                parentNodeToDelete.setLeft(null);
                return nodeToDelete.getData();
            }else{
                size--;
                parentNodeToDelete.setRight(null);
                return nodeToDelete.getData();
            }
        }
        //The node is not a leaf
        /*
        if(nodeToDelete.getLeft() != null){
            return replaceWithLargestOnLeft(nodeToDelete);
        }else{
            return replaceWithSmallestOnRight(nodeToDelete);
        }
         */
        if(nodeToDelete.getRight() != null){
            return replaceWithSmallestOnRight(nodeToDelete);
        }else{
            return replaceWithLargestOnLeft(nodeToDelete);
        }
    }
    T replaceWithLargestOnLeft(Node<K, T> nodeToDelete) {
        //replace with largest On the left
        Node<K, T> largestLeft = largestOnLeft(nodeToDelete);
        Node<K, T> parentLargestLeft = parentOf(largestLeft.key);
        //copy largestLeft to Node to delete
        T save = nodeToDelete.getData();
        nodeToDelete.setKey(largestLeft.key);
        nodeToDelete.setData(largestLeft.getData());
        if (parentLargestLeft.getLeft() != null && parentLargestLeft.getLeft().getKey().compareTo(largestLeft.key) == 0) {
            //lagest on left is connect to the left of parent.
            parentLargestLeft.setLeft(largestLeft.getLeft());
            size--;
            return save;
        } else {
            //The parent is connected through right
            parentLargestLeft.setRight(largestLeft.getLeft());
            size--;
            return save;
        }
    }
    T replaceWithSmallestOnRight(Node<K, T> nodeToDelete){
        //replace with smallest On the right
        Node<K, T> smallestRight = smallestOnRight(nodeToDelete);
        Node<K, T> parentSmallestRight = parentOf(smallestRight.key);
        //copy smallestRight to Node to delete
        T save = nodeToDelete.getData();
        nodeToDelete.setKey(smallestRight.key);
        nodeToDelete.setData(smallestRight.getData());
        if(parentSmallestRight.getLeft() != null && parentSmallestRight.getLeft().getKey().compareTo(smallestRight.key) == 0){
            //smallest on the right is connect to the left of parent.
            parentSmallestRight.setLeft(smallestRight.getRight());
            size--;
            return save;
        }else{
            //The parent is connected through right
            parentSmallestRight.setRight(smallestRight.getRight());
            size--;
            return save;
        }
    }
}