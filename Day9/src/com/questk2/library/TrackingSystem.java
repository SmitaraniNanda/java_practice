package com.questk2.library;

import java.util.Date;

/**
 * Tracks borrowed books in the library system.
 */
public class TrackingSystem {

    /**
     * Tracks the borrowing details of a book by a member.
     *
     * @param bookId   The unique identifier of the borrowed book.
     * @param memberId The unique identifier of the library member who borrowed the book.
     */
    public void trackBorrowedBooks(int bookId, int memberId) {
        System.out.println("Tracking borrowed book. Book ID: " + bookId + ", Member ID: " + memberId + ", Borrowed on: " + new Date());
    }
}
