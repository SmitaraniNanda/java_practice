package com.questk2.Ecommerce;

/**
 * Represents an order in the e-commerce system.
 */
public class Order {
    private String orderId;
    private String name;
    private boolean processed;

    /**
     * Constructs an Order with the given order ID, customer name, and processed status.
     *
     * @param orderId   The unique identifier of the order.
     * @param name      The name of the customer placing the order.
     * @param processed The order's processing status (true if processed, false otherwise).
     */
    public Order(String orderId, String name, boolean processed) {
        this.orderId = orderId;
        this.name = name;
        this.processed = processed;
    }

    /**
     * Gets the order ID.
     *
     * @return The order ID.
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * Gets the customer's name.
     *
     * @return The name of the customer.
     */
    public String getCustomer() {
        return name;
    }

    /**
     * Checks if the order has been processed.
     *
     * @return True if the order is processed, false otherwise.
     */
    public boolean getProcessed() {
        return processed;
    }

    /**
     * Marks the order as processed.
     */
    public void orderProcessed() {
        this.processed = true;
    }
    
    /**
     * Returns a string representation of the order.
     *
     * @return A formatted string with order details.
     */
    @Override
    public String toString() {
        return "Order Id : " + orderId + " Customer : " + name + " Processed : " + processed;
    }
}
