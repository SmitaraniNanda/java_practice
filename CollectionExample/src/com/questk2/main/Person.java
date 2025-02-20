package com.questk2.main;

public class Person implements Comparable<Person> {
	private String name;
	private Integer age;
	private String city;

	Person(String name, Integer age, String city) {
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String toString() {
		return name + " (" + age + ", " + city + ")";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	 // Implementing the compareTo() method for natural ordering
    @Override
    public int compareTo(Person other) {
        // Comparing by age
    	int compare = Integer.compare(this.age, other.age);
    	System.out.println("return : " + compare);
        return compare; // Ascending order
    }

}
