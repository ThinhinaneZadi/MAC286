package com.mac286.doublelinkedlist;
import java.util.EmptyStackException;
public class OurDoubleLinkedList<T> {
    private class Node<TT> {
        private TT data;
        private Node<TT> next;
        private Node<TT> previous;
        public Node(){
            data = null;
            next = null;
            previous = null;
        }
        public Node(TT d){
            data = d;
            next = null;
            previous = null;
        }
        public Node(TT d, Node<TT> n, Node<TT> p){
            data = d;
            next = n;
            previous = p;
        }

        public TT getData() {
            return data;
        }
        public void setData(TT data) {
            this.data = data;
        }
        public Node<TT> getNext() {
            return next;
        }
        public Node<TT> getPrevious() {
            return previous;
        }
        public void setPrevious(Node<TT> previous) {
            this.previous = previous;
        }

        public void setNext(Node<TT> next) {
            this.next = next;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> Head, Tail;
    private int size;
    public OurDoubleLinkedList(){
        Tail = Head = null;
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size==0);
    }
    //add method adds to the back
    public void add(T e){
        //add T to the back
        //create a Node with e
        Node<T> newNode = new Node<>(e);
        //if the list is empty, then set both Head and Tail to newNode, size to 1
        if (this.isEmpty()) {
            Head = Tail = newNode;
            size = 1;
            //return.
            return;
        }
        Tail.setNext(newNode);
        newNode.setPrevious(Tail);
        Tail = newNode;
        size++;
    }

    //remove removes the first and returns the data
    public T remove(){
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        T removedData = Head.getData();
        if (size == 1) {
            Head = Tail = null;
            size = 0;
            return removedData;
        }
        Head = Head.getNext();
        Head.setPrevious(null);
        size--;
        return removedData;
    }
    public T poll(){
        return this.remove();
    }
    public T pop(){
        return this.remove();
    }

    public T peek(){
        //return the data at the Head. Null if empty
        if(this.isEmpty()){
            return null;
        }
        return Head.getData();
    }
    public void addFirst(T e){
        if(this.isEmpty()){
            add(e);
        }
        //create a node
        Node<T> newNode = new Node<>(e);
        //always alter the newNode first
        newNode.setNext(Head);
        newNode.setPrevious(null);
        Head.setPrevious(newNode);
        Head = newNode;
        size++;
    }
    public void addLast(T e){
        this.add(e);
    }
    public void add(int ind, T e){
        //check ind is valid index otherwise throw IndexOutOfBoundsException
        if(ind < 0 || ind > size){
            throw new IndexOutOfBoundsException();
        }
        if(ind == 0) {
            addFirst(e);
        }else if (ind == size){
            addLast(e);
        }else {
            //have a reference to start at Head, temp
            Node<T> temp = Head;
            //move ind-1 times in the list
            for (int i = 0; i < ind - 1; i++) {
                temp = temp.getNext();
            }
            //create a new Node
            Node<T> newNode = new Node<>(e);
            //set next of newNode to next of temp
            newNode.setNext(temp.getNext());
            newNode.setPrevious(temp);
            //set next of temp to newNode
            temp.getNext().setPrevious(newNode);
            temp.setNext(newNode);
            //increase size
            size++;
        }
    }
    public T remove(int ind){
        if(ind < 0 || ind > size-1){
            throw new IndexOutOfBoundsException();
        }
        if(ind == 0){
            return this.remove();
        }
        //advance ind-1 times
        if (ind == size - 1) {
            T removedData = Tail.getData();
            if (size == 1) {
                Head = Tail = null;
            } else {
                Tail = Tail.getPrevious();
                Tail.setNext(null);
            }

            size--;
            return removedData;
        }
        //save data of next of temp
        Node<T> temp = Head;

        for (int i = 0; i < ind - 1; i++) {
            temp = temp.getNext();
        }
        T removedData = temp.getNext().getData();
        //set next of temp to next of next of temp.
        Node<T> nodeToRemove = temp.getNext();
        temp.setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrevious(temp);

        size--;
        return removedData;
    }
    public T removeFirst(){
        return this.remove();
    }
    public T removeLast(){
        return this.remove(this.size-1);
    }
    public T get(int ind){
        if(ind < 0 || ind > size-1){
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp = Head;
        //advance ind times
        for(int i = 0; i < ind; i++){
            temp = temp.getNext();
        }
        return temp.getData();
    }
    public String toString(){
        //Already given in NodeTester.
        if(this.isEmpty()){
            return "[]";
        }
        Node<T> temp = Head; //temp = N3
        String st = "[" + temp.getData();
        temp = temp.getNext();
        while(temp!=null){
            st +=  ", " + temp.getData();
            temp = temp.getNext();
        }


     return st +"]";
    }
}
