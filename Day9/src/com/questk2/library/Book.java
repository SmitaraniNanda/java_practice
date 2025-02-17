package com.questk2.library;

/**
 * Represents a book in the library.
 */
public class Book {
    private int id;
    private String title;
    private String category;

    /**
     * Constructs a new Book with the specified id, title, and category.
     *
     * @param id       The unique identifier for the book.
     * @param title    The title of the book.
     * @param category The category or genre of the book.
     */
    public Book(int id, String title, String category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    /**
     * Gets the unique identifier of the book.
     *
     * @return The book ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the category of the book.
     *
     * @return The book category.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return A formatted string with book details.
     */
    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Category: " + category;
    }
}
