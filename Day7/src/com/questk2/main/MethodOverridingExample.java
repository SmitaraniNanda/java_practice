package com.questk2.main;
// Parent class
class Animal {
    /**
     * Makes a sound.
     * @param name The name of the animal making the sound.
     */
    public void makeSound(String name) {
        System.out.println(name + " makes a generic animal sound.");
    }
}

// Child class overriding the makeSound method 
class Dog extends Animal {
    /**
     * Makes a sound specific to dogs.
     * @param name The name of the dog making the sound.
     */
    public void makeSound(String name) { // Overriding 
        System.out.println(name + " barks: Woof! Woof!");
    }
}

// Main class
public class MethodOverridingExample {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        Animal myDog = new Dog(); // Upcasting

        myAnimal.makeSound("Some Animal");
        myDog.makeSound("Buddy");
    }
}
