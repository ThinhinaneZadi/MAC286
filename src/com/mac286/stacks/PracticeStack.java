package com.mac286.stacks;

import java.util.Random;

//TODO: HW3
public class PracticeStack {
    //design a static method that generates a stack of specific
    // number of integers (num) between -max and +max.
    public static OurStack<Integer> generateStack(int n, int max) {
        //create a stack of integers
        OurStack<Integer> st = new OurStack<>();
        //create a random number generator
        Random rand = new Random();
        //loop n times
        for (int i = 0; i < n; i++) {
        //generate a number between -max and +max
            int num = rand.nextInt(2*max+1)-max;
        //push it to the stack
            st.push(num);
        }
        //return the stack
        return st;
    }


    public static void main(String[] args) {
        //generate a stack of 20 integers between -300 and +300.
        OurStack<Integer> st = generateStack(20, 300);
        //display it
        System.out.println("Our stack: " + st);

        //using two additional helper stacks (in total three stacks)
        OurStack<Integer> helper1 = new OurStack<>();
        OurStack<Integer> helper2 = new OurStack<>();

        //move all elements from original stack to helper1
        //to process the numbers in original order
        while (!st.isEmpty()) {
            helper1.push(st.pop());
        }

        //separate numbers into groups while reading in original order
        while (!helper1.isEmpty()) {
            int value = helper1.pop();
            //separate values less than -100 because we want them in bottom of our original stack
            if (value < -100) {
                st.push(value);
            }
            //otherwise pushed to helper2
            else {
                helper2.push(value);
            }
        }

        //move back the values that are not smaller than -100
        //we take them from helper2 because it contains values that are not smaller than -100
        while (!helper2.isEmpty()) {
            //put them in helper1 to be processed again
            helper1.push(helper2.pop());
        }

        //check values in helper1 and put middle values first in our stack
        while (!helper1.isEmpty()) {
            int value = helper1.pop();

            if (value >= -100 && value <= 100) {
                st.push(value);
            }
            else {
                helper2.push(value);
            }
        }
        //move back the values larger than 100
        while (!helper2.isEmpty()) {
            //put them in helper1 first to restore their correct order before puting them in the original stack
            helper1.push(helper2.pop());
        }
        //put top values last
        while (!helper1.isEmpty()) {
            st.push(helper1.pop());
        }
        System.out.println("Reorganized stack: " + st);

        //Example input [230, -20, 130, -135, 98, -200, -80, 156, 34, -230]
        //output [-135, -200, -230, -20, 98, -80, 34, 230, 130, 156]

    }

}