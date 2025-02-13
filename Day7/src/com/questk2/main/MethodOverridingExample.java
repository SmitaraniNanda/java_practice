package com.questk2.main;
// Parent class
class Animal {
    /**
     * @param name The name of the animal making the sound.
     */
    public void makeSound(String name) {
        System.out.println(name + " makes a generic animal sound.");
    }
}

// Child class overriding the makeSound method 
class Cat extends Animal {
    /**
     * Makes a sound specific to dogs.
     * @param name The name of the cat making the sound.
     */
    public void makeSound(String name) { // Overriding 
        System.out.println(name + " barks: Miaw! Miaw!");
    }
}

// Main class(child class)
public class MethodOverridingExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal cat = new Cat(); // Upcasting

        animal.makeSound("Some Animal");
        cat.makeSound("Tomy");
    }
}
