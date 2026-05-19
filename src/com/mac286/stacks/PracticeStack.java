package com.mac286.stacks;

import com.mac286.Queues.OurQueue;
import com.mac286.arrays.OurVector;

import java.util.Random;

//TODO: HW3
public class PracticeStack {
    //design a static method that generates a stack of specific
    // number of integers (num) between -max and +max.
    public static OurStack<Integer> generateStack(int n, int max) {
        //create a stack of integers
        OurStack<Integer> S = new OurStack<>();
        //create a random number generator
        Random generator = new Random();
        for(int i = 0; i < n; i++) {
            //loop n times
            //generate a number between -max and +max
            int num = generator.nextInt(-max, max);
            //push it to the stack
            S.push(num);
        }
        //return the stack
        return S;
    }


    public static void main(String[] args) {
        //generate a stack of 20 integers between -300 and +300.
        OurStack<Integer> mainStack = generateStack(20, 300);
        //display it
        System.out.println("Before S: " + mainStack);
        //using two additional helper stacks (in total three stacks)
        OurStack<Integer> S1 = new OurStack<>();
        OurStack<Integer> S2 = new OurStack<>();
        while(!mainStack.isEmpty()){
            //if the number is less than -100 put it in S1, else put it in S2
            if(mainStack.peek() < -100){
                S1.push(mainStack.pop());
            }else{
                S2.push(mainStack.pop());
            }
        }
        //empty S1 into mainStack
        while(!S1.isEmpty()){
            mainStack.push(S1.pop());
        }
        //empty the numbers from -100 to +100 from S2 into mainStack
        //and the others go back to S1
        while(!S2.isEmpty()){
            if(S2.peek() < 100){
                mainStack.push(S2.pop());
            }else{
                S1.push(S2.pop());
            }
        }
        //empty S1 into S2 to restore the order
        while(!S1.isEmpty()){
            S2.push(S1.pop());
        }
        //empty S2 into the main stack (large numbers
        while(!S2.isEmpty()){
            mainStack.push(S2.pop());
        }
        //reorganize the original stack so that numbers smaller than -100 go
        //to the bottom of the original stack, numbers betwen -100 and +100
        //in the middle and number larger than 100 to the top while respecting
        //the relative order in which they were in the original stack.
        //Example input [230, -20, 130, -135, 98, -200, -80, 156, 34, -230]
        //output [-135, -200, -230, -20, 98, -80, 34, 230, 130, 156]
        System.out.println("After S: " + mainStack);

        /*TODO: HW4 Generate a new stack same as above, and reorganize it the same way

        1- Using one queue and one stack for help;

        2- Using one OurVector object only for help;

        3- Challenging: Using one single queue for help;

         */


        //1- Using one queue and one stack for help;
        OurStack<Integer> stack1 = generateStack(20, 300);
        System.out.println("Before S Q+S: " + stack1);

        OurQueue<Integer> Q1 = new OurQueue<>();
        OurStack<Integer> HS1 = new OurStack<>();

        //move all elements from stack1 to helper stack to reverse the order
        while(!stack1.isEmpty()){
            HS1.push(stack1.pop());
        }

        //put numbers smaller than -100 directly in stack1
        //the others go to the queue
        while(!HS1.isEmpty()){
            if(HS1.peek() < -100){
                stack1.push(HS1.pop());
            }else{
                Q1.add(HS1.pop());
            }
        }

        //put numbers from -100 to 100 in stack1
        //the larger numbers stay in the queue
        int size1 = Q1.size();
        for(int i = 0; i < size1; i++){
            int num = Q1.remove();
            if(num <= 100){
                stack1.push(num);
            }else{
                Q1.add(num);
            }
        }

        //move the large numbers to helper stack
        while(!Q1.isEmpty()){
            HS1.push(Q1.remove());
        }

        //restore their order in the queue
        while(!HS1.isEmpty()){
            Q1.add(HS1.pop());
        }

        //put the large numbers on top of stack1
        while(!Q1.isEmpty()){
            stack1.push(Q1.remove());
        }

        System.out.println("After S Q+S: " + stack1);



        //2- Using one OurVector object only for help;
        OurStack<Integer> stack2 = generateStack(20, 300);
        System.out.println("Before S V: " + stack2);

        OurVector<Integer> V = new OurVector<>();

        //move all elements from stack2 into the vector
        while(!stack2.isEmpty()){
            V.add(stack2.pop());
        }

        //put numbers smaller than -100 first
        for(int i = V.size() - 1; i >= 0; i--){
            if(V.get(i) < -100){
                stack2.push(V.get(i));
            }
        }

        //put numbers from -100 to 100 next
        for(int i = V.size() - 1; i >= 0; i--){
            if(V.get(i) >= -100 && V.get(i) <= 100){
                stack2.push(V.get(i));
            }
        }

        //put numbers larger than 100 last
        for(int i = V.size() - 1; i >= 0; i--){
            if(V.get(i) > 100){
                stack2.push(V.get(i));
            }
        }

        System.out.println("After S V: " + stack2);



        //3- Challenging: Using one single queue for help;
        OurStack<Integer> stack3 = generateStack(20, 300);
        System.out.println("Before S Q: " + stack3);

        OurQueue<Integer> Q2 = new OurQueue<>();

        //move all elements from stack3 to the queue
        while(!stack3.isEmpty()){
            Q2.add(stack3.pop());
        }

        //move them back to the stack to reverse the order
        while(!Q2.isEmpty()){
            stack3.push(Q2.remove());
        }

        //move them again to the queue
        //now the queue has the elements in original order
        while(!stack3.isEmpty()){
            Q2.add(stack3.pop());
        }

        //put numbers smaller than -100 first
        int size2 = Q2.size();
        for(int i = 0; i < size2; i++){
            int num = Q2.remove();
            if(num < -100){
                stack3.push(num);
            }else{
                Q2.add(num);
            }
        }

        //put numbers from -100 to 100 next
        int size3 = Q2.size();
        for(int i = 0; i < size3; i++){
            int num = Q2.remove();
            if(num >= -100 && num <= 100){
                stack3.push(num);
            }else{
                Q2.add(num);
            }
        }

        //put numbers larger than 100 last
        while(!Q2.isEmpty()){
            stack3.push(Q2.remove());
        }

        System.out.println("After S Q: " + stack3);

    }

}