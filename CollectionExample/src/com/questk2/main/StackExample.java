package com.questk2.main;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Creating a Stack
        Stack<String> stack = new Stack<>();
        
        // Pushing elements onto the stack
        stack.push("First");
        stack.push("Second");
        stack.push("Third");

        System.out.println("Stack: " + stack);

        // Popping elements from the stack (LIFO)
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack after pop: " + stack);

        // Peeking the top element
        System.out.println("Top element: " + stack.peek());
    }
}
