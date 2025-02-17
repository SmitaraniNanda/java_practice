package com.questk2.library;

/**
 * Manages the library's book catalog, including adding, updating, deleting, and displaying books.
 */
public class LibraryManagement {
    
    /** Array to store books in the library catalog. */
    public Book[] booksCatalog;

    /** Keeps track of the number of books in the catalog. */
    public int bookCount;

    /**
     * Initializes the library catalog with a few books.
     */
    public void presentbooks() {
        System.out.println("Initializing the library catalog with a few books...");
    }

    /**
     * Adds a new book to the library catalog.
     *
     * @param book The book object to be added.
     */
    public void addBook(Book book) {
        System.out.println("Book added to catalog: " + book);
    }

    /**
     * Updates the details of an existing book in the catalog.
     *
     * @param bookId      The unique identifier of the book to be updated.
     * @param updatedBook The updated book object with new details.
     */
    public void updateBook(int bookId, Book updatedBook) {
        System.out.println("Updated book with ID " + bookId + " to: " + updatedBook);
    }

    /**
     * Deletes a book from the library catalog based on its ID.
     *
     * @param bookId The unique identifier of the book to be deleted.
     */
    public void deleteBook(int bookId) {
        System.out.println("Deleted book with ID: " + bookId);
    }

    /**
     * Displays all books currently in the library catalog.
     */
    public void showCatalog() {
        System.out.println("Displaying the library catalog...");
    }
}
