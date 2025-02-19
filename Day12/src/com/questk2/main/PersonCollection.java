package com.questk2.main;

import java.util.ArrayList;
import java.util.List;

public class PersonCollection {
	
		
		// Person class with attributes, constructor, and toString method
		
		    String name;
		    int age;
		    String city;
		    List<String> subjects;

		    public PersonCollection(String name, int age, String city, List<String> subjects) {
		        this.name = name;
		        this.age = age;
		        this.city = city;
		        this.subjects = new ArrayList<>(subjects);
		    }

		    
		    public String toString() {
		        return "Person{name='" + name + '\'' + ", age=" + age +", city='" + city + '\'' +", subjects=" + subjects + '}';
		    }
		

}
