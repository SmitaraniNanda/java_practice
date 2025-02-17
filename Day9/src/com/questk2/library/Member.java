package com.questk2.library;

/**
 * Represents a library member who can search for, borrow, and return books.
 * Members do not have permissions to add, update, or delete books from the catalog.
 */
public class Member implements Library {

    /**
     * Searches for books in the specified category.
     *
     * @param category The category of books to search for.
     */
    public void booksearch(String category) {
        System.out.println("Member is searching books in category: " + category);
    }

    /**
     * Allows a member to borrow a book from the library.
     *
     * @param bookId   The unique identifier of the book to be borrowed.
     * @param memberId The unique identifier of the library member borrowing the book.
     */
    public void borrowbook(int bookId, int memberId) {
        System.out.println("Member " + memberId + " borrowed book with ID: " + bookId);
    }

    /**
     * Allows a member to return a borrowed book to the library.
     *
     * @param bookId   The unique identifier of the book being returned.
     * @param memberId The unique identifier of the library member returning the book.
     */
    public void returnbook(int bookId, int memberId) {
        System.out.println("Member " + memberId + " returned book with ID: " + bookId);
    }

    /**
     * Displays a message indicating that members cannot add books to the catalog.
     *
     * @param book The book object that the member attempted to add.
     */
    public void addbook(Book book) {
        System.out.println("Members cannot add books to the catalog.");
    }

    /**
     * Displays a message indicating that members cannot update books in the catalog.
     *
     * @param bookId      The unique identifier of the book the member attempted to update.
     * @param updatedBook The updated book object that the member attempted to modify.
     */
    public void updateBook(int bookId, Book updatedBook) {
        System.out.println("Members cannot update books in the catalog.");
    }

    /**
     * Displays a message indicating that members cannot delete books from the catalog.
     *
     * @param bookId The unique identifier of the book the member attempted to delete.
     */
    public void deleteBook(int bookId) {
        System.out.println("Members cannot delete books from the catalog.");
    }
}
