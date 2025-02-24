package com.questk2.warehouse;

/**
 * Represents a product in the inventory with a name and stock count.
 */
public class Product {
    private String name;
    private int stock;

    /**
     * Constructs a Product with the given name and stock count.
     *
     * @param name  The name of the product.
     * @param stock The initial stock count of the product.
     */
    public Product(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    /**
     * Returns a string representation of the product, including its name and stock count.
     *
     * @return A formatted string containing the product's name and stock count.
     */
    @Override
    public String toString() {
        return " Name : " + name + " Stock count : " + stock;
    }

    /**
     * Gets the name of the product.
     *
     * @return The product's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the current stock count of the product.
     *
     * @return The stock count.
     */
    public int getStock() {
        return stock;
    }
}
