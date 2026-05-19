package com.mac286.doublelinkedlist;

public class DoubleLinkedListTester {
    static void main() {
        OurDoubleLinkedList<Integer> list = new OurDoubleLinkedList<>();

        System.out.println("List at first: " + list);
        System.out.println("Size: " + list.size());
        System.out.println();

        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("After adding 10, 20, 30: " + list);

        list.addFirst(5);
        System.out.println("After addFirst(5): " + list);

        list.addLast(40);
        System.out.println("After addLast(40): " + list);

        list.add(2, 15);
        System.out.println("After add(2, 15): " + list);
        System.out.println();

        System.out.println("First item with peek: " + list.peek());
        System.out.println("Item at index 3: " + list.get(3));
        System.out.println();

        System.out.println("Removed first: " + list.remove());
        System.out.println("List now: " + list);

        System.out.println("Removed index 2: " + list.remove(2));
        System.out.println("List now: " + list);

        System.out.println("Removed last: " + list.removeLast());
        System.out.println("List now: " + list);
        System.out.println();

        System.out.println("Final size: " + list.size());
        System.out.println("Is empty? " + list.isEmpty());
    }
}
