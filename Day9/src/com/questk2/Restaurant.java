package com.questk2;
class Restaurant {
    /**
     * Constructor to initialize a restaurant.
     * @param name Name of the restaurant
     * @param location Location of the restaurant
     */
    public Restaurant(String name, String location) {
        System.out.println("Restaurant initialized: " + name + " at " + location);
    }

    /**
     * Displays restaurant details.
     */
    public void displayRestaurant() {
        System.out.println("Displaying restaurant details.");
    }

    /**
     * Adds a food item to the restaurant's menu.
     * @param item Food item to be added
     */
    public void addFoodItem(FoodItem item) {
        System.out.println("Adding food item to menu.");
    }
}