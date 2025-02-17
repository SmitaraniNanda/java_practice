package com.questk2.library;

/**
 * Represents the library system interface, defining operations for book management.
 */
public interface Library {

    /**
     * Searches for books in the specified category.
     *
     * @param category The category of books to search for.
     */
    void booksearch(String category);

    /**
     * Allows a library member to borrow a book.
     *
     * @param bookId   The unique identifier of the book to be borrowed.
     * @param memberId The unique identifier of the library member borrowing the book.
     */
    void borrowbook(int bookId, int memberId);

    /**
     * Allows a library member to return a borrowed book.
     *
     * @param bookId   The unique identifier of the book being returned.
     * @param memberId The unique identifier of the library member returning the book.
     */
    void returnbook(int bookId, int memberId);

    /**
     * Adds a new book to the library.
     *
     * @param book The book object containing details of the new book.
     */
    void addbook(Book book);

    /**
     * Updates the details of an existing book.
     *
     * @param bookId      the unique identifier of the book to be updated.
     * @param updatedBook the updated book object with new details.
     */
    void updateBook(int bookId, Book updatedBook);

    /**
     * Deletes a book from the library.
     *
     * @param bookId The unique identifier of the book to be deleted.
     */
    void deleteBook(int bookId);
}
