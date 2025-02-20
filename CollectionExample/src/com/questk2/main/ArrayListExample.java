package com.questk2.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ArrayListExample {
    public static void main(String[] args) {
        // Creating an ArrayList
        List<String> arrayList = new ArrayList<>();
        
        // Adding elements to the list
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");
        arrayList.add("Java");  // Duplicate element

        // Accessing elements
        System.out.println("ArrayList: " + arrayList);
        System.out.println("Element at index 1: " + arrayList.get(1));
        System.out.println("Index of 'Java': " + arrayList.indexOf("Java"));
        
        // Removing an element
        //arrayList.remove("Python");
        System.out.println("After removing 'Python': " + arrayList);
        List<String> removeArrayList = new ArrayList<>();
        
        // Adding elements to the list
        removeArrayList.add("Java");
        removeArrayList.add("Python");
        //arrayList.removeAll(removeArrayList);
        //Collections.singletonList("java");
        //arrayList.removeAll(Collections.singletonList("Java"));
        //System.out.println("After removing 'Java': " + arrayList);
        
        arrayList.retainAll(removeArrayList);
        System.out.println(arrayList);
        
        
        List<String> vectors = new Vector<String>();
    }
}

