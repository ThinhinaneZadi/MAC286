package com.mac286.midterm;

import com.mac286.Linkedlists.OurLinkedList;
import com.mac286.stacks.OurStack;

import java.util.Random;

public class Midterm {

    // This method generates a stack with n random integers.
    // max is the upper bound for random values.
    public static OurStack<Integer> generateStack(int n, int max) {

        // Create the stack that will store the random integers.
        OurStack<Integer> S = new OurStack<>();

        // Create a Random object to generate random numbers.
        Random generator = new Random();

        // Loop n times to generate n integers.
        for (int i = 0; i < n; i++) {

            // Generate a random integer between -max and max.
            // Example: if max = 300, values can be from -300 up to 299.
            int num = generator.nextInt(-max, max);

            // Push the generated number into the stack.
            S.push(num);
        }

        // Return the completed stack.
        return S;
    }

    // This is the correct Java main method.
    // Program execution starts here.
    public static void main(String[] args) {

        // =========================
        // PART A: USING TWO STACKS
        // =========================

        // Generate the original stack with random numbers.
        OurStack<Integer> mainStack = generateStack(20, 300);

        // Print the original stack before reorganizing it.
        System.out.println("Before S: " + mainStack);

        // Create a stack to hold negative integers.
        OurStack<Integer> SN = new OurStack<>();

        // Create a stack to hold positive integers.
        OurStack<Integer> SP = new OurStack<>();

        // Counters to track how many negatives and positives exist.
        int numNegatives = 0, numPositives = 0;

        // Move all elements from mainStack into either SN or SP.
        while (!mainStack.isEmpty()) {

            // Check the top element of mainStack without removing it.
            if (mainStack.peek() < 0) {

                // If it is negative, pop it from mainStack and push into SN.
                SN.push(mainStack.pop());

                // Increase the count of negatives.
                numNegatives++;
            } else {

                // Otherwise, push it into the positive stack.
                // Note: this includes zero too.
                SP.push(mainStack.pop());

                // Increase the count of positives.
                numPositives++;
            }
        }

        // Now rebuild the mainStack in alternating order.
        // If negatives are more, start with a negative.
        if (numNegatives > numPositives) {

            // Keep alternating while both stacks still have elements.
            while (!SN.isEmpty() && !SP.isEmpty()) {

                // Push one negative first.
                mainStack.push(SN.pop());

                // Then push one positive.
                mainStack.push(SP.pop());
            }

        } else {

            // Otherwise, start with a positive.
            while (!SN.isEmpty() && !SP.isEmpty()) {

                // Push one positive first.
                mainStack.push(SP.pop());

                // Then push one negative.
                mainStack.push(SN.pop());
            }
        }

        // If anything is left in SN, push it back to mainStack.
        // This usually matters only if the counts are not exactly equal.
        while (!SN.isEmpty()) {
            mainStack.push(SN.pop());
        }

        // If anything is left in SP, push it back to mainStack.
        while (!SP.isEmpty()) {
            mainStack.push(SP.pop());
        }

        // Print the stack after reorganizing.
        System.out.println("After S: " + mainStack);


        // ==========================================
        // PART B: USING ONE TEMPORARY LINKED LIST
        // ==========================================


        mainStack = generateStack(20, 300);
        System.out.println("Before S: " + mainStack);

// Create one temporary linked list
        OurLinkedList<Integer> list = new OurLinkedList<>();

// Reset counters
        numNegatives = 0;
        numPositives = 0;

// Move all items from stack into the list
        while (!mainStack.isEmpty()) {

            int value = mainStack.pop();

            if (value < 0) {
                // Put negatives at the FRONT of the list
                list.addFirst(value);
                numNegatives++;
            } else {
                // Put positives at the BACK of the list
                list.addLast(value);
                numPositives++;
            }
        }

// Rebuild the stack in alternating order
        if (numNegatives > numPositives) {

            // Start with negative
            while (numNegatives > 0 && numPositives > 0) {
                mainStack.push(list.removeFirst()); // negative from front
                numNegatives--;

                mainStack.push(list.removeLast());  // positive from back
                numPositives--;
            }

        } else {

            // Start with positive
            while (numNegatives > 0 && numPositives > 0) {
                mainStack.push(list.removeLast());  // positive from back
                numPositives--;

                mainStack.push(list.removeFirst()); // negative from front
                numNegatives--;
            }
        }

// Push leftovers if one side has extra values
        while (numNegatives > 0) {
            mainStack.push(list.removeFirst());
            numNegatives--;
        }

        while (numPositives > 0) {
            mainStack.push(list.removeLast());
            numPositives--;
        }

        System.out.println("After S: " + mainStack);
    }
}