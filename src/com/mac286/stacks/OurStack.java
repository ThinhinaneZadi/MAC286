package com.mac286.stacks;

import com.mac286.arrays.OurVector;

import java.util.Arrays;
import java.util.EmptyStackException;

public class OurStack <T>{
    //An array of T
    private T[] S;
    //size
    private int size;
    //default constructor, create an array of 10 elements
    public OurStack(){
        S = (T[]) new Object[10];
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
    public void push(T e){
        if(size == S.length){
            //full resize
            S = Arrays.copyOf(S, S.length*2);
        }
        S[size] = e;
        size++;
    }
    //T pop()
    public T pop(){
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        T save = S[size-1];
        size--;
        return save;
    }
    //T peek()
    public T peek(){
        if(this.isEmpty()){
            return null;
        }
        return S[size-1];
    }
    //toString()
    public String toString(){
        if(this.isEmpty()) {
            return "[]";
        }
        String st = "[" + S[0];
        for(int i =1; i < size; i++){
            st += ", " + S[i];
        }
        st += "]";
        return st;
    }
}
