package com.questk2.library;

/**
 * Handles late fee payments for overdue book returns.
 */
public class LateFee {

    /**
     * Processes a late fee payment for a book returned after the due date.
     *
     * @param bookId   The unique identifier of the overdue book.
     * @param memberId The unique identifier of the library member making the payment.
     * @param daysLate The number of days the book was returned late.
     */
    public void makePayment(int bookId, int memberId, int daysLate) {
        System.out.println("Member " + memberId + " paid for late return of book with ID: " + bookId + ". Days late: " + daysLate);
    }
}
