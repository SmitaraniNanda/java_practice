package com.questk2.main;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        Set<String> hashSet = new HashSet<>(100, 0.5f);
        
        // Adding elements to the set
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Orange");
        hashSet.add("Apple");  // Duplicate will not be added
        hashSet.remove("Apple");
        // Displaying the set
        System.out.println("HashSet: " + hashSet);
    }
}
