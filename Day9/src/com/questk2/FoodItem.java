package com.questk2;

abstract class FoodItem {
    String name;
    double price;

	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	public double price() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
     * Displays the food item details.
     */
    void displayItem() {
        System.out.println("Food Item: " + name + ", Price: " + price);
    }
}
