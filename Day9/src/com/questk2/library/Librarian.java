package com.questk2.library;

/**
 * Represents a librarian who manages library operations such as searching, borrowing, returning,
 * adding, updating, and deleting books.
 */
public class Librarian implements Library {

    /**
     * Searches for books in the specified category.
     *
     * @param category The category of books to search for.
     */
    public void booksearch(String category) {
        System.out.println("Librarian is searching books in category: " + category);
    }

    /**
     * Allows a library member to borrow a book.
     *
     * @param bookId   The unique identifier of the book to be borrowed.
     * @param memberId The unique identifier of the library member borrowing the book.
     */
    public void borrowbook(int bookId, int memberId) {
        System.out.println("Librarian allows Member " + memberId + " to borrow book with ID: " + bookId);
    }

    /**
     * Allows a library member to return a borrowed book.
     *
     * @param bookId   The unique identifier of the book being returned.
     * @param memberId The unique identifier of the library member returning the book.
     */
    public void returnbook(int bookId, int memberId) {
        System.out.println("Librarian allows Member " + memberId + " to return book with ID: " + bookId);
    }

    /**
     * Adds a new book to the library.
     *
     * @param book The book object containing details of the new book.
     */
    public void addbook(Book book) {
        System.out.println("Librarian is adding new book: " + book);
    }

    /**
     * Updates the details of an existing book.
     *
     * @param bookId      The unique identifier of the book to be updated.
     * @param updatedBook The updated book object with new details.
     */
    public void updateBook(int bookId, Book updatedBook) {
        System.out.println("Librarian is updating book ID " + bookId + " with details: " + updatedBook);
    }

    /**
     * Deletes a book from the library.
     *
     * @param bookId The unique identifier of the book to be deleted.
     */
    public void deleteBook(int bookId) {
        System.out.println("Librarian is deleting book with ID: " + bookId);
    }
}
