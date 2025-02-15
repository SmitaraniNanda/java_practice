package com.questk2;

/**
 * Main class for the Online Food Delivery System.
 */
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        System.out.println("Welcome to the Online Food Delivery System");
        
        // Example usage of different components
        
        /**
         * Registers a new customer, logs in, and views the profile.
         */
        Customer customer = new Customer();
        customer.register();
        customer.login();
        customer.viewProfile();
 
        /**
         * Registers a new delivery driver, logs in, and views the profile.
         */
        DeliveryTracker tracker = new DeliveryTracker();
        tracker.register();
        tracker.login();
        tracker.viewProfile();
     
        /**
         * Adds and removes an item from the cart.
         * @param item The item to be added or removed.
         */
        Cart cart = new Cart();
        cart.addItem("Pizza");
        cart.removeItem("Pizza");
      
        /**
         * Processes payment for an order.
         * @param orderId The ID of the order.
         * @param amount The total amount to be paid.
         */
        PaymentGateway.processPayment(101, PaymentGateway.calculateTotalAmount(20.0, 2.5));
    }
}
