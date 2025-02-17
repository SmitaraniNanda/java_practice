package com.questk2.library;

import java.util.Scanner;

/**
 * The main class to test library management functionalities, allowing interaction as a member or librarian.
 */
public class MainTest {

    /**
     * The entry point of the program, demonstrating various library operations.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept user input to determine whether they are a librarian or a member.
        String type = scanner.next();

        // Create and initialize the library management system.
        LibraryManagement libraryManagement = new LibraryManagement();
        libraryManagement.presentbooks();
        libraryManagement.addBook(new Book(3, "History Book 1", Categories.HISTORY));

        // Perform actions based on user type.
        if (type.contentEquals("member")) {
            Member member = new Member();
            member.borrowbook(1, 101);
        } else if (type.contentEquals("librarian")) {
            Librarian librarian = new Librarian();
            librarian.booksearch(Categories.FICTION);
            librarian.updateBook(2, new Book(2, "Book-2", Categories.NONFICTION));
            librarian.deleteBook(2);
        }

        // Track borrowed books.
        TrackingSystem trackingSystem = new TrackingSystem();
        trackingSystem.trackBorrowedBooks(1, 101);

        // Handle late fee payments.
        LateFee lateFee = new LateFee();
        lateFee.makePayment(1, 101, 3);

        // Display the final library catalog.
        libraryManagement.showCatalog();

        // Close the scanner to prevent resource leaks.
        scanner.close();
    }
}
