package com.mac286.heaps;

import java.util.PriorityQueue;

public class HeapTester {
    public static void main(String[] args) {
        // PriorityQueue<Integer> Q = new PriorityQueue<>();
        OurHeap<Integer> Q = new OurHeap<>();
        Q.add(13);
        Q.add(15);
        Q.add(8);
        Q.add(4);
        Q.add(7);
        System.out.println("Q: " + Q);
        Q.add(2);
        System.out.println("Q: " + Q);
        System.out.println("Q.poll: " + Q.poll());
        System.out.println("Q: " + Q);
        System.out.println("Q.remove should be same as poll: " + Q.remove());
        System.out.println("Q: " + Q);

    }
}
