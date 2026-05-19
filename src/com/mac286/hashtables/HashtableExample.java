package com.mac286.hashtables;

import java.util.Hashtable;
import java.util.Set;

public class HashtableExample {
    public static void main(String[] args) {
        Hashtable<Integer, String> Tab = new Hashtable<>(20 , 0.25f);
        Tab.put(11209, "Bayridge");
        Tab.put(11101, "Long Island City");
        Tab.put(10000, "Manhattan");
        System.out.println("Tab: "+Tab.toString());
        System.out.println("removing zip 10000: "+Tab.remove(10000));
        System.out.println("Tab: "+Tab.toString());
        Tab.put(11111,"No Clue");
        Tab.put(11377, "woodside");
        System.out.println("Tab: "+Tab.toString());
        //going through elements of hashtable
        //1. get the set of he keys
        Set<Integer> keys = Tab.keySet();
        //use a for loop to go through the set of keys
        for(Integer k: keys){
            System.out.println(k+ "=" +Tab.get(k));
        }
        String st = "No Clue";
        System.out.println("st hashcode: "+st.hashCode());
    }
}
