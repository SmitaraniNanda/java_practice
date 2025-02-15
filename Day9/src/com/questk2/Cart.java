package com.questk2;

public class Cart {
    /**
     * Adds an item to the cart.
     * @param itemName Name of the food item
     */
    void addItem(String itemName) {
        System.out.println("Item added to cart: " + itemName);
    }

    /**
     * Removes an item from the cart.
     * @param itemName Name of the food item
     */
    void removeItem(String itemName) {
        System.out.println("Item removed from cart: " + itemName);
    }
}