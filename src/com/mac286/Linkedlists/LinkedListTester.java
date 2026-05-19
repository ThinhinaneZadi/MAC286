package com.mac286.Linkedlists;
import java.util.ArrayList;
import java.util.LinkedList;

public class LinkedListTester {
    public static void main(String[] args) {
        OurLinkedList<Integer> Ar = new OurLinkedList<>();
        //LinkedList add() adds at the back, remove/pop/poll removes the first
        //peek returns the first.
        Ar.add(-1);
        Ar.add(-3);
        System.out.println("Ar: " + Ar);
        Ar.add(-5);
        System.out.println("Ar: " + Ar);
        System.out.println("removing: " + Ar.remove()); //removes the first, implements the queue
        System.out.println("Ar: " + Ar);
        System.out.println("Peek: " + Ar.peek());
        //test poll
        System.out.println("poll: " + Ar.poll());
        System.out.println("Ar: " + Ar);

        //test pop
        System.out.println("pop: " + Ar.pop());
        System.out.println("Ar: " + Ar);

        //add more values again
        Ar.add(-7);
        Ar.add(-9);
        System.out.println("Ar: " + Ar);

        //test size
        System.out.println("size: " + Ar.size());

        //test isEmpty
        System.out.println("isEmpty: " + Ar.isEmpty());


    }
}
