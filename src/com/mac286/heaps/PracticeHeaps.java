package com.mac286.heaps;

import java.util.Arrays;
import java.util.Random;/*
TODO: HW8
Generate an array of 10 random integers. Using a Heap, order the array
in an descending order (largest first).
 */

public class PracticeHeaps {
    public static int[] generateArray(int s, int max){
        Random generator = new Random();
        int[] A = new int[s];
        for(int i = 0; i < s; i++){
            A[i] = generator.nextInt(-max, max);
        }
        return A;
    }
    public static void main(String[] args) {
        int[] array = generateArray(10, 300);
        System.out.println("Before: " +Arrays.toString(array));
        //create a heap
        OurHeap<Integer> H = new OurHeap<>();
        for(int i = 0; i < array.length; i++){
            H.add(array[i]);
        }
        for(int i = array.length-1; i >= 0; i--){
            array[i] = H.poll();
        }
        System.out.println("After: " +Arrays.toString(array));
    }

}
