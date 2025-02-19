package com.questk2.main;

import java.util.*;


 public  class Person {
	    public static void main(String[] args) {
	        // Using List to store multiple Person objects
	        List<PersonCollection> personList = new ArrayList<>();
	        personList.add(new PersonCollection("Smita", 25, "India", Arrays.asList("Math","Odia")));
	        personList.add(new PersonCollection("Sita", 30, "New York", Arrays.asList("History", "Science")));

	        // Using Set to store unique Person objects
	        Set<PersonCollection> personSet = new HashSet<>(personList);
	        personSet.add(new PersonCollection("Charlie", 22, "Chicago", Arrays.asList("Physics", "Chemistry")));

	        // Using Vector
	        Vector<PersonCollection> personVector = new Vector<>(personList);
	        personVector.add(new PersonCollection("Mamali", 28, "America", Arrays.asList("Biology", "English")));

	        // Using Queue (LinkedList as Queue)
	        Queue<PersonCollection> personQueue = new LinkedList<>(personList);
	        personQueue.offer(new PersonCollection("Rutu", 26, "Japan", Arrays.asList("English", "Art")));

	        // Perform some operations
	        personList.remove(0); // Remove first person from list
	        personSet.remove(new PersonCollection("Sita", 30, "New York", Arrays.asList("History", "Science"))); // Removing from Set
	        personVector.remove(0); // Remove first person from vector
	        personQueue.poll(); // Remove the first element from queue

	        // Print final collections
	        System.out.println("List: " + personList);
	        System.out.println("Set: " + personSet);
	        System.out.println("Vector: " + personVector);
	        System.out.println("Queue: " + personQueue);
	    }
	

}
