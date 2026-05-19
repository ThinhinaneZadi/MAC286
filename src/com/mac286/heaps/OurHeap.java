package com.mac286.heaps;

import java.util.Arrays;

public class OurHeap<T extends Comparable<T>> {
    private T[] H;
    private int size;
    public OurHeap(){
        H = (T[])new Comparable[10];
        size = 0;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return (size == 0);
    }
    private void resize(){
        H = Arrays.copyOf(H, H.length*2);
    }
    public void add(T e){
        //if full resize
        if(size == H.length){
            resize();
        }
        //add e at index size, increase size
        H[size] = e;
        size++;
        //heapify at index size-1
        heapify(size-1);
    }
    private void heapify(int ind){
        //if ind is 0 then return
        if(ind <= 0){
            return;
        }
        //find index of parent indParent
        int indParent = (ind - 1)/2;
        //compare element at ind to element at indParent, if smaller
        //then swap elements at ind and indParent, then
        // heapify at indParent
        if(H[ind].compareTo(H[indParent]) < 0){
            //swap H[ind] with H[indParent]
            T save = H[ind];
            H[ind] = H[indParent];
            H[indParent] = save;
            heapify(indParent);
        }
        // if not smaller then return.
    }
    public String toString(){
        //if empty return []
        if(this.isEmpty()){
            return "[]";
        }
        //start adding the first element with bracket and no comma
        String st = "[" + H[0];
        //for the size-1 other elements add comma then element
        for(int i = 1; i < size; i++){
            st += ", " + H[i];
        }
        //end of loop add ] to the string and return it
        return st +"]";
    }
    //TODO: HW8
    private void reheapify(int ind){
        if(2*ind+1 >= size) {
            //no left child, means this is a leaf
            return;
        }
        //find the index of the smallest of the children
        int indexSmallest = 2*ind + 1;
        //of element at ind. Call it indSmalest
        if(2*ind + 2 < size){
            //there is a right child, we compare the two children
            if(H[indexSmallest].compareTo(H[2*ind + 2]) > 0){
                //The right is the smallest
                indexSmallest = 2*ind + 2;
            }
        }
        //We have the smallest
        //if element at ind is larger than element at indSmallest
        if(H[indexSmallest].compareTo(H[ind]) < 0){
            //swap H[ind] with H[indexSmallest
            T temp = H[ind];
            H[ind] = H[indexSmallest];
            H[indexSmallest] = temp;
            reheapify(indexSmallest);
        }
    }
    public T poll(){
        //if empty return null
        if(this.isEmpty())
            return null;
        //save first element at index 0
        T save = H[0];
        //replace element at index 0 by element at index size-1
        H[0] = H[size-1];
        //decrease the size
        size--;
        //reheapify at index 0
        reheapify(0);
        return save;
    }
    public T remove(){
        return this.poll();
    }
}
