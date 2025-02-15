package com.questk2;
/**
 * Class representing a Burger item.
 */
class Burger extends FoodItem {
    private String name;
    private double price;

    public Burger(String name, double price) {
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
