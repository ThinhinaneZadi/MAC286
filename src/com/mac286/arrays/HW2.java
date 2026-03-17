package com.mac286.arrays;

import java.util.Scanner;

public class HW2 {
    public static void main(String[] args) {
            OurVector<Double> V = new OurVector<>(10);
            //create a Scanner
            Scanner sc = new Scanner(System.in);
            for(int i = 0; i < 10; i++){
                System.out.print("Enter " + i + " th element: ");
                V.add(sc.nextDouble());
            }
            System.out.println("V: Before " + V);
            OurVector<Double> Temp = new OurVector<>(10);
            while(!V.isEmpty()){
                Temp.add(V.removeLast());
            }
            //remove from the head of Temp and insert in the back of V
            while(!Temp.isEmpty()){
                V.add(Temp.removeFirst());
            }
            System.out.println("V After: " + V);
        }
}
