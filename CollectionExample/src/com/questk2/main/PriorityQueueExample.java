package com.questk2.main;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Creating a PriorityQueue
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        
        // Adding elements to the queue
        priorityQueue.add(5);
        priorityQueue.add(1);
        priorityQueue.add(3);

        // Displaying the queue (ordered by natural order)
        System.out.println("PriorityQueue: " + priorityQueue);
        
        // Removing elements (FIFO but ordered by priority)
        System.out.println("Removed element: " + priorityQueue.poll());
        System.out.println("Queue after removal: " + priorityQueue);
    }
}

