package com.mac286.Queues;

import java.util.Random;
import com.mac286.arrays.OurVector;

public class PracticeQueue {
    //design a static method that generates a queue of specific
    // number of integers (num) between -max and +max.
    public static OurQueue<Integer> generateQueue(int n, int max) {
        //create a queue of integers
        OurQueue<Integer> Q = new OurQueue<>();

        //create a random number generator
        Random generator = new Random();

        for (int i = 0; i < n; i++) {
            //loop n times
            //generate a number between -max and +max
            int num = generator.nextInt(2 * max + 1) - max;

            //add it to the queue
            Q.add(num);
        }

        //return the queue
        return Q;
    }

    public static void main(String[] args) {
        //generate a queue of 20 integers between -300 and +300.
        OurQueue<Integer> originalQueue = generateQueue(20, 300);

        //display it
        System.out.println("Before Q: " + originalQueue);

        //using two additional helper queues (in total three queues)
        OurQueue<Integer> Q1 = new OurQueue<>();
        OurQueue<Integer> Q2 = new OurQueue<>();

        //if the number is less than -100 put it in Q1, else put it in Q2
        while (!originalQueue.isEmpty()) {
            if (originalQueue.peek() < -100) {
                Q1.add(originalQueue.remove());
            } else {
                Q2.add(originalQueue.remove());
            }
        }

        //empty the numbers from -100 to +100 from Q2 into originalQueue
        //and the others go to Q1 after the small numbers
        while (!Q2.isEmpty()) {
            if (Q2.peek() <= 100) {
                originalQueue.add(Q2.remove());
            } else {
                Q1.add(Q2.remove());
            }
        }

        //empty Q1 into a temp queue to separate small and large numbers
        OurQueue<Integer> temp = new OurQueue<>();
        while (!Q1.isEmpty()) {
            temp.add(Q1.remove());
        }

        //first put the small numbers back into originalQueue
        while (!temp.isEmpty()) {
            if (temp.peek() < -100) {
                originalQueue.add(temp.remove());
            } else {
                Q1.add(temp.remove());
            }
        }

        //now move all to temp again so small goes first, middle already inside, large goes last
        OurQueue<Integer> result = new OurQueue<>();

        //put small numbers first
        while (!originalQueue.isEmpty()) {
            if (originalQueue.peek() < -100) {
                result.add(originalQueue.remove());
            } else {
                temp.add(originalQueue.remove());
            }
        }

        //put middle numbers next
        while (!temp.isEmpty()) {
            if (temp.peek() >= -100 && temp.peek() <= 100) {
                result.add(temp.remove());
            } else {
                originalQueue.add(temp.remove());
            }
        }

        //put large numbers last
        while (!Q1.isEmpty()) {
            result.add(Q1.remove());
        }
        while (!originalQueue.isEmpty()) {
            result.add(originalQueue.remove());
        }

        originalQueue = result;

        System.out.println("After Q: " + originalQueue);


        OurQueue<Integer> q2 = generateQueue(20, 300);
        System.out.println("Before Q2: " + q2);

        OurVector<Integer> V = new OurVector<>(20);

        //move all queue elements into vector
        while (!q2.isEmpty()) {
            V.add(q2.remove());
        }

        //first add small numbers
        for (int i = 0; i < V.size(); i++) {
            if (V.get(i) < -100) {
                q2.add(V.get(i));
            }
        }

        //then add middle numbers
        for (int i = 0; i < V.size(); i++) {
            if (V.get(i) >= -100 && V.get(i) <= 100) {
                q2.add(V.get(i));
            }
        }

        //then add large numbers
        for (int i = 0; i < V.size(); i++) {
            if (V.get(i) > 100) {
                q2.add(V.get(i));
            }
        }

        System.out.println("After Q2: " + q2);
    }
}