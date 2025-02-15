package com.questk2;
class PaymentGateway {
    /**
     * Calculates the total amount of an order.
     * @param amount Base amount of the order
     * @param tax Tax applied to the order
     * @return Total amount including tax
     */
    static double calculateTotalAmount(double amount, double tax) {
        double total = amount + tax;
        System.out.println("Total amount calculated: " + total);
        return total;
    }

    /**
     * Processes the payment for an order.
     * @param orderId Unique identifier for the order
     * @param amount Amount to be paid
     * @return Payment status
     */
    static boolean processPayment(int orderId, double amount) {
        System.out.println("Processing payment for Order ID: " + orderId + ", Amount: " + amount);
        return true;
    }
}
