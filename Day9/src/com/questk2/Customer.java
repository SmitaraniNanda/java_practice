package com.questk2;

/**
 * Represents a customer.
 */
public class Customer implements User {
        @Override
    public void login() {
        System.out.println(" logged in.");
    }

    @Override
    public void register() {
        System.out.println(" registered successfully.");
    }

    @Override
    public void viewProfile() {
        System.out.println("Customer Profile: ");
    }

   
}
