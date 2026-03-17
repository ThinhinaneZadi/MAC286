package com.mac286.stacks;

import java.util.Stack;

public class StackTester {
    public static void main(String[] args) {
        OurStack<Integer> S= new OurStack<>();
        //push numbers
        S.push(-1);
        S.push(-3);
        System.out.println("S: " + S);
        S.push(-9);
        S.push(-7);
        System.out.println("S: " + S);
        //poping
        System.out.println("Poping: " + S.pop());
        System.out.println("S: " + S);
        System.out.println("The top of S is: " + S.peek());
    }
}
