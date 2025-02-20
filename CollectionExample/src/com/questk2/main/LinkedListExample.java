package com.questk2.main;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // Creating a LinkedList
        List<String> linkedList = new LinkedList<>();
        
        // Adding elements to the list
        linkedList.add("Red");
        linkedList.add("Green");
        linkedList.add("Blue");

        // Methods on LinkedList
        System.out.println("LinkedList: " + linkedList);
        linkedList.add(1, "Yellow");  // Add at specific index
        System.out.println("After adding 'Yellow': " + linkedList);
        linkedList.set(2, "Purple");  // Set new value at index 2
        System.out.println("After replacing 'Blue' with 'Purple': " + linkedList);
    }
}
