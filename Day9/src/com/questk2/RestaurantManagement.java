package com.questk2;

class RestaurantManagement {
    /**
     * A static class for managing multiple restaurants.
     */
    public static void addRestaurant(String name) {
        System.out.println("Restaurant " + name + " added to manager.");
    }

    public static void removeRestaurant(String name) {
        System.out.println("Restaurant " + name + " removed from manager.");
    }

    public static void addDishToRestaurant(String restaurantName, String dishName, double price) {
        System.out.println("Dish " + dishName + " added to " + restaurantName + " with price " + price + ".");
    }

    public static void removeDishFromRestaurant(String restaurantName, String dishName) {
        System.out.println("Dish " + dishName + " removed from " + restaurantName + ".");
    }
    public static void getRestaurantMenu(String restaurantName) {
        System.out.println("Fetching menu for " + restaurantName + ".");
    }
}