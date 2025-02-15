package com.questk2;

/**
 * Class representing a Pizza item.
 */
class Pizza extends FoodItem {
    private String name;
    private double price;

    public Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public double price() {
        return price;
    }
   
}
