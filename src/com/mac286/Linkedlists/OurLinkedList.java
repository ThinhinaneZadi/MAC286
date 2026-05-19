package com.mac286.Linkedlists;

import com.mac286.Linkedlists.Node;
import com.mac286.arrays.OurVector;

import java.util.EmptyStackException;

//TODO: HW
public class OurLinkedList <T>{
    private Node<T> Head, Tail;
    private int size;

    public OurLinkedList(){
        Head = Tail = null;
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
        //return.
        if(this.isEmpty()){
            Tail = Head = newNode;
            size = 1;
            return;
        }

        //set next of Tail to new Node,
        Tail.setNext(newNode);
        Tail = newNode;
        //set Tail to new Node,
        //increase size
        size++;
    }

    //remove removes the first and returns the data
    public T remove(){
        //if empty throw EmptyStackException
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        //save the data in the first node
        T save = Head.getData();
        //set Head to the next of Head
        Head = Head.getNext();
        //decrease size
        size--;
        //if size is 0, set Head and Tail to null
        if(size == 0){
            Tail = Head = null;
        }
        //return the saved
        return save;
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
            return;
        }
        //create a node
        Node<T> newNode = new Node<>(e);
        //always alter the newNode first
        newNode.setNext(Head);
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
            //set next of temp to newNode
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
        Node<T> temp = Head;
        for(int i =0; i < ind -1; i++){
            temp = temp.getNext();
        }
        //save data of next of temp
        T save = temp.getNext().getData();
        //set next of temp to next of next of temp.
        temp.setNext(temp.getNext().getNext());
        if(ind == size-1){
            //we removed the last one, update the Tail
            Tail = temp;
        }
        size--;
        return save;
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