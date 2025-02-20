package com.questk2.main;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    public static void main(String[] args) {
        // Creating a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>();
        
        // Adding elements to both ends
        deque.addFirst("Front 1");
        deque.addLast("Back 1");
        deque.addFirst("Front 2");
        deque.addLast("Back 2");

        System.out.println("Deque: " + deque);

        // Removing elements from both ends
        deque.removeFirst();
        deque.removeLast();

        System.out.println("Deque after removal: " + deque);

        // Peeking elements from both ends
        System.out.println("Front element: " + deque.peekFirst());
        System.out.println("Back element: " + deque.peekLast());
    }
}

