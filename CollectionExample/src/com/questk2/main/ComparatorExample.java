package com.questk2.main;

import java.util.*;

class Student {
	String name;
	int age;
	int marks;

	Student(String name, int age, int marks) {
		this.name = name;
		this.age = age;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return name + " (Age: " + age + ", Marks: " + marks + ")";
	}
}

class NameComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return s1.name.compareTo(s2.name); // Sorting by name alphabetically
	}
}

class AgeComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return Integer.compare(s1.age, s2.age); // Sorting by age in ascending order
	}
}

class MarksComparator implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {
		return Integer.compare(s1.marks, s2.marks); // Sorting by marks in ascending order
	}
}

public class ComparatorExample {
	public static void main(String[] args) {
		// Creating a list of students
		List<Student> students = new ArrayList<>();
		students.add(new Student("John", 18, 85));
		students.add(new Student("Alice", 20, 90));
		students.add(new Student("Bob", 19, 75));

		System.out.println("Original List:");
		System.out.println(students);

		// Sorting students by name
		Collections.sort(students, new NameComparator());
		System.out.println("\nSorted by Name:");
		System.out.println(students);

		// Sorting students by age
		Collections.sort(students, new AgeComparator());
		System.out.println("\nSorted by Age:");
		System.out.println(students);

		// Sorting students by age using an anonymous inner class
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return Integer.compare(s1.age, s2.age); // Sorting by age in ascending order
			}
		});

		System.out.println("\nSorted by Age:");
		System.out.println(students);

		// Sorting students by marks
		Collections.sort(students, new MarksComparator());
		System.out.println("\nSorted by Marks:");
		System.out.println(students);

		// Reversing the sorting order (e.g., sorting by marks in descending order)
		Collections.sort(students, Collections.reverseOrder(new MarksComparator()));
		System.out.println("\nSorted by Marks (Descending):");
		System.out.println(students);
	}
}
