package com.questk2.main;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // Creating a LinkedHashSet (maintains insertion order)
        Set<String> linkedHashSet = new LinkedHashSet<>();
        
        // Adding elements to the set
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Orange");

        // Displaying the set
        System.out.println("LinkedHashSet (insertion order): " + linkedHashSet);
    }
}

