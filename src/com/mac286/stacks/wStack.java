package com.mac286.stacks;

import com.mac286.arrays.OurVector;

import java.util.EmptyStackException;

/*
Implement the stack as a wrapper around an OurVector Object
 */
public class wStack<T> {
    //have a reference to OurVector object as private
    OurVector<T> ws;
    //default constructor. Create an OurVector object
    public wStack(){
        ws = new OurVector<>();
    }
    //size() forward the call to OurVector
    public int size(){
        return ws.size();
    }
    //isEmpty() forward the call to OurVector
    public boolean isEmpty(){
        return ws.isEmpty();
    }
    //push forward the call
    public void push(T e){
        ws.addLast(e); //adds to last
    }
    //pop forward the call
    public T pop(){
        if(ws.isEmpty()){
            throw new EmptyStackException();
        }
        return ws.removeLast();
    }
    //peek() forward the call
    public T peek(){
        if(ws.isEmpty()){
            throw new EmptyStackException();
        }
        return ws.get(ws.size()-1);
    }
    //toString forward the call
    public String toString(){
        return ws.toString();
    }
}
