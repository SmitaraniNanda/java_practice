package com.questk2.main;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // Creating a TreeSet (sorted order)
        Set<String> treeSet = new TreeSet<>();
        
        // Adding elements to the set
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Orange");

        // Displaying the sorted set
        System.out.println("TreeSet (sorted order): " + treeSet);
        
        // Creating a TreeSet with custom comparator (reverse order in this case)
        Set<String> treeSetCustomOrder = new TreeSet<>(Comparator.reverseOrder());
        
        // Adding elements to the set
        treeSetCustomOrder.add("Banana");
        treeSetCustomOrder.add("Apple");
        treeSetCustomOrder.add("Orange");

        // Displaying the TreeSet sorted in custom order (reverse order)
        System.out.println("TreeSet (custom reverse order): " + treeSetCustomOrder);
    }
}
