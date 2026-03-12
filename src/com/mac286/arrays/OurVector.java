package com.mac286.arrays;
import java.util.EmptyStackException;
public class OurVector <T>{
    private T[] V;
    private int size, increment;

    //default constructor that creates an array of 5 integer, increment set to 5
    //and size to 0
    public OurVector(){
        this.V = (T[]) new Object[5];
        this.increment = 10;
        size = 0;
    }
    //constructor that accepts an integer for initial capacity: creates an rray
    //of that capacity, sets increment to 10 and size to 0
    public OurVector(int cap){
        this.V = (T[]) new Object[cap];
        this.increment = 10;
        size = 0;
    }
    //constructor that accepts both capacity and increment
    //creates an array of capacity and sets increment to input and size to 0
    public OurVector(int cap, int incr){
        this.V = (T[]) new Object[cap];
        this.increment = incr;
        size = 0;
    }
    //method size() return size
    public int size(){
        return size;
    }
    public int capacity(){
        return V.length;
    }
    //method isEmpty() returns true is size is 0 and false if not
    boolean isEmpty(){
        return (size == 0);
    }
    private void resize(){
        //TODO: implement later
        //create a new array the size of the old one plus increment
        T[] newAr = (T[]) new Object[V.length + increment];
        //copy all elements from V to newAr
        for(int i =0; i< size; i++){
            newAr[i] = V[i];
        }
        //rename newAr with V
        V = newAr;
    }
    public T removeLast(){
        //if empty throw emptyStackException
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        //remember last
        T save = V[size-1];
        //decrease size
        size--;
        //return the saved
        return save;
    }
    public T removeFirst(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        //save the first
        T save = V[0];
        //push all elements down by one starting at index 1
        for(int i = 1; i < size; i++){
            V[i-1] = V[i];
        }
        size--;
        return save;
    }
    public T remove(int index){
        //check if index is valid, if not throw IndexOutOfBoundsException
        if(index < 0 || index >size-1){
            throw new IndexOutOfBoundsException("Invalid index");
        }
        //save element at index
        T save = V[index];
        //push down all elements by one starting at index
        for(int i = index+ 1; i < size; i++){
            V[i-1] = V[i];
        }
        //decrement size
        size--;
        //return saved
        return save;
    }
    public void addLast(T e){
        this.add(e);
    }
    public void addFirst(T e){
        if(size == V.length){
            System.out.println("Array full, need to resize");
            resize();
        }
        //push up all element by one starting at the last
        for(int i = size - 1; i >= 0; i--){
            V[i+1] = V[i];
        }
        V[0] = e;
        size++;
    }
    public void add(int ind, T e){
        if(ind < 0 || ind >size){
            //System.out.println("Invalid index");
            throw new IndexOutOfBoundsException("Invalid index");
        }
        if(size == V.length){
            System.out.println("Array full, need to resize");
            resize();
        }
        //push up all element by one starting at the last
        for(int i = size - 1; i >= ind; i--){
            V[i+1] = V[i];
        }
        V[ind] = e;
        size++;
    }
    //method add(int e) adds e to the back of the array (at index size) increment size
    public void add(T e){
        if(size == V.length){
            System.out.println("Array full, need to resize");
            resize();
        }
        //add e at index size
        V[size] = e;
        size++;
    }
    //method toString to display the array in the form seem this morning
    public String toString(){
        if(this.isEmpty()) {
            return "[]";
        }
        String st = "[" + V[0];
        for(int i =1; i < size; i++){
            st += ", " + V[i];
        }
        st += "]";
        return st;
    }
    // reverse method
    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            T temp = V[i];
            V[i] = V[size - 1 - i];
            V[size - 1 - i] = temp;
        }
    }
}