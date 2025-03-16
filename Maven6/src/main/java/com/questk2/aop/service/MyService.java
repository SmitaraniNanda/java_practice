package com.questk2.aop.service;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	public void performTask(String taskName) {
        System.out.println("Executing Task: " + taskName);
    }
    
    public int calculateSum(int a, int b) {
        return a + b;
    }
    
    public void throwException() {
        throw new RuntimeException("An error occurred!");
    }
}