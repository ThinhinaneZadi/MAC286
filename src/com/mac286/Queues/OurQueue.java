package com.mac286.Queues;

import java.util.Arrays;
import java.util.EmptyStackException;

public class OurQueue <T>{
    private T[] Q;
    //size
    private int size;
    //default constructor, create an array of 10 elements
    public OurQueue(){
        Q = (T[]) new Object[10];
        size = 0;
    }
    //size() method
    public int size(){
        return size;
    }
    //isEmpty()
    public boolean isEmpty(){
        return (size == 0);
    }
    // void push(T e)
    public void add(T e){
        if(size == Q.length){
            //full resize
            Q = Arrays.copyOf(Q, Q.length*2);
        }
        Q[size] = e;
        size++;
    }
    //T remove() removes the first and returns it
    public T remove(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        //save the first
        T save = Q[0];
        //push all elements down by one starting at index 1
        for(int i = 1; i < size; i++){
            Q[i-1] = Q[i];
        }
        size--;
        return save;
    }
    //T peek()
    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        return Q[0];
    }
    //toString()
    public String toString(){
        if(this.isEmpty()) {
            return "[]";
        }
        String st = "[" + Q[0];
        for(int i =1; i < size; i++){
            st += ", " + Q[i];
        }
        st += "]";
        return st;
    }

}