package com.questk2.main;
// Parent class: Vehicle
class Vehicle {
    /**
     * Describes how the vehicle moves.
     */
    public void move() {
        System.out.println("The vehicle is moving...");
    }
}

// Child class: Car
class Car extends Vehicle {
   
	//Describes how a car moves.
     
  
    public void move() {
        System.out.println("Car moves on four wheels!");
    }
}

// Child class: Bike
class Bike extends Vehicle {
    /**
     * Describes how a bike moves.
     */
    @Override
    public void move() {
        System.out.println("Bike moves on two wheels!");
    }
}

// Main class to demonstrate polymorphism
public class PolymorphismExample {
    /**
     * Calls the move method on a Vehicle object.
     * 
     * @param vehicle The vehicle object that will move.
     */
    public static void startMoving(Vehicle vehicle) {
        vehicle.move();
    }

    public static void main(String[] args) {
        // Creating objects
        Vehicle myCar = new Car();
        Vehicle myBike = new Bike();

        // Demonstrating polymorphism
        startMoving(myCar);  // Output: Car moves on four wheels!
        startMoving(myBike); // Output: Bike moves on two wheels!
    }
}
