package com.mac286.Queues;

import com.mac286.arrays.OurVector;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CircularQueue <T> {
    private T[] Q;
    //size
    private int size;
    private int first, last;

    //default constructor, create an array of 10 elements
    public CircularQueue() {
        Q = (T[]) new Object[4];
        size = 0;
        first = -1;
        last = -1;
    }

    //size() method
    public int size() {
        return size;
    }

    //isEmpty()
    public boolean isEmpty() {
        return (size == 0);
    }

    public void resize() {
        //create a new array the size of the old one plus increment
        T[] newAr = (T[]) new Object[Q.length * 2];
        //copy all elements from Q to newAr
        for (int i = 0; i < size; i++) {
            newAr[i] = Q[(first + i) % Q.length];
        }
        first = 0;
        last = size - 1;
        Q = newAr;
    }

    // void push(T e)
    public void add(T e) {
        //check if full, then resize, do it later
        if (size == Q.length) {
            resize();
        }
        //if empty, add e to index 0 set last and first to 0 size to 1, return
        if (this.isEmpty()) {
            first = 0;
            Q[first] = e;
            last = 0;
            size++;
            return;
        }
        //advance last by one in a circular way using modulo the length of the array
        last = (last + 1) % Q.length;
        //add e to index last;
        Q[last] = e;
        //increase size;
        size++;
    }

    public T remove() {
        //if empty throw an exception
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        //save element at index first
        T saved = Q[first];
        //advance first by one in circular way, using modulo array length.
        first = (first + 1) % Q.length;
        //decrease size
        size--;
        //return saved.
        return saved;
    }

    public T peek() {
        //if empty throw an exception or return null
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        //return element at index first.
        return Q[first];
    }

    public String toString() {
        //if empty return []
        if (this.isEmpty()) {
            return "[]";
        }
        //add the first element to the string,
        String st = "["+Q[first];
        //loop size -1 times, starting at (first+1)%length
        for (int i = 1; i < size; i ++) {
            //add current element and advance in a circular way (index = (index+1)%length
            st += ", " + Q[(first+i)%Q.length];
        }
        //add closing bracket and return the string
        st += "]";
        return st;
    }

    public static void main(String[] args) {
        CircularQueue<Double> Q = new CircularQueue<Double>();
        //create a Scanner
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            System.out.print("Enter " + i + " th element: ");
            Q.add(sc.nextDouble());
        }
        System.out.println("Q:" + Q);

    }
}


