package com.mac286.Linkedlists;

public class NodeTester {
    public static void main(String[] args) {
        //recreate the list in oneNote
        //create N1 with -1 as data
        Node<Integer> N1 = new Node<>(-1);
        //create N2 with -3
        Node<Integer> N2 = new Node<>(-3);
        //reate N5 with -7
        Node<Integer> N5 = new Node<>(-7);
        //make N2 the next of N1, link N2 to N1
        N1.setNext(N2);
        //set N5 as the next of N2
        N2.setNext(N5);
        //Set a reference Head to the first node N1
        Node<Integer> Head = N1;
        Node<Integer> Tail = N5;
        //Change the content of N2 to -9, using only Head reference.
        Head.getNext().setData(-9);
        //display the N2 using only Head reference.
        System.out.println("N2: "+Head.getNext());
        //create a new Node N3 with value -13, put it between N1 and N2 using only Head
        //as a reference.
        Node<Integer> N3 = new Node<>(-13);
        N3.setNext(Head.getNext());
        Head.setNext(N3);

        //remove N1 from the list, using only Head reference and make Head refer to N2 now.
        Head=N2;
        Head.setNext(N3);
        N1=null;

        //display the content of Head.
        System.out.println("Head: "+Head);

    }
}