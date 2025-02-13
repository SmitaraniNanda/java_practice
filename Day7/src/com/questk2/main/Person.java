package com.questk2.main;

public class Person {
	/**
	 * This class demonstrates constructor overloading in Java.
	 * It represents a simple "Person" entity with different ways to initialize it.
	 */
	    private String name;
	    private int age;

	    /*
	     * Default constructor.
	     * Initializes the person with default values.
	     */
	    public Person() {
	        this.name = "Unknown";
	        this.age = 0;
	    }

	    /*
	     * Parameterized constructor to initialize name. 
	     * @param name The name of the person.
	     */
	    public Person(String name) {
	        this.name = name;
	        this.age = 0; // Default age 
	    }

	    /*
	     * Parameterized constructor to initialize name and age.
	     * @param name The name of the person.
	     * @param age  The age of the person.
	     */
	    public Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    
	     // Displays person details.
	    
	    public void displayPersonInfo() {
	        System.out.println("Name: " + name + ", Age: " + age);
	    }

	    public static void main(String[] args) {
	        // Using different constructors
	        Person person1 = new Person();
	        Person person2 = new Person("smita");
	        Person person3 = new Person("puspa", 25);

	        // Displaying information
	        person1.displayPersonInfo();
	        person2.displayPersonInfo();
	        person3.displayPersonInfo();
	    }
	
}
