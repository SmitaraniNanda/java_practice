package com.questk2.main;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueueExample {
    public static void main(String[] args) {
        // Creating a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();
        
        // Adding elements to the queue
        queue.add("Task 1");
        queue.add("Task 2");
        queue.add("Task 3");
        queue.remove("Task 2");
        // Displaying the queue
        System.out.println("Queue: " + queue);
        System.out.println("Peek element: " +  queue.peek());
        // Removing elements from the queue (FIFO)
        System.out.println("Removed element: " + queue.poll());
        System.out.println("Queue after removal: " + queue);
    }
}
