package com.questk2;

/**
 * Class representing a Pizza item.
 */
class Pizza extends FoodItem {
    private String name;
    private double price;

    /**
     * Constructor to initialize a Pizza object.
     *
     * @param name  The name of the pizza.
     * @param price The price of the pizza.
     */
    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the name of the pizza.
     *
     * @return The name of the pizza.
     */
    @Override
    public String name() {
        return name;
    }

    /**
     * Gets the price of the pizza.
     *
     * @return The price of the pizza.
     */
    @Override
    public double price() {
        return price;
    }
}
