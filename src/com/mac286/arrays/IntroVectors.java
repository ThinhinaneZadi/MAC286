package com.mac286.arrays;

/*
A Vector is a data structure that allows the use of an array in
an easy way. You can add elements to an array at any index
as long as no space is left empty.
To create a Vector we use:
Vector<Type> VectorName = new Vector(size, increment);
size if the initial length of the vector. How many elements
can you add there.
Increment is a number by how much the Vector grows each time
it reaches capacity

*/

public class IntroVectors {
    public static void main(String args[]) {
        //Vector<Integer> V = new Vector(5, 10);
        OurVector<Integer> V = new OurVector<Integer>(5, 10);
        //initial length is 5, when we reach 5, it's resized
        //to 15.
        System.out.println("V.capcity(): " + V.capacity() + " V.size: " + V.size() +
                "\nV: " + V);
        V.add(-1);
        V.add(-5);
        System.out.println("V.capcity(): " + V.capacity() + " V.size: " + V.size() +
                "\nV: " + V);
        V.addFirst(-9);
        System.out.println("V.capcity(): " + V.capacity() + " V.size: " + V.size() +
                "\nV: " + V);
        V.add(2, -11);
        System.out.println("V.capcity(): " + V.capacity() + " V.size: " + V.size() +
                "\nV: " + V);
        V.add(4, -13);
        System.out.println("V.capcity(): " + V.capacity() + " V.size: " + V.size() +
                "\nV: " + V);

        V.add(0, -17); //adding -11 at index 0
        System.out.println("V.capcity(): " + V.capacity() + " V.size: " + V.size() +
                "\nV: " + V);
        int temp = V.removeLast();
        System.out.println("Removed " + temp + " V: " + V + " V.size " + V.size() + " capa: " + V.capacity()); //-1, -9 ...all pushed down by 1
        temp = V.removeFirst();
        System.out.println("Removed " + temp + " V: " + V + " V.size " + V.size() + " capa: " + V.capacity()); //-1, -9 ...all pushed down by 1
        temp = V.remove(2);//removes element at index 2
        System.out.println("Removed " + temp + " V: " + V + " V.size " + V.size() + " capa: " + V.capacity());
        //adding at index 4 with trigger an IndexOutOfBoundsException as 4 will leave a space at 3
        //V.add(4, -21);

        //Create an OurVector object that contains strings
        OurVector<String> Vec = new OurVector<>();
        //add the following strings to it: Hello, Hola, Hi, Bye  (display)
        Vec.add("Hello");
        Vec.add("Hola");
        Vec.add("Hi");
        Vec.add("Bye");
        System.out.println("Vec: " + Vec);
        //Add How between Hola and Hi   display the vetor
        Vec.add(2, "How");
        System.out.println("Vec: " + Vec);
        //IN ONE instruction move Hola from index 1 to 0. Display the vector
        Vec.add(0, Vec.remove(1));//What you remove at index 1 add it at index 0
        System.out.println("Vec: " + Vec);
    }
}