package com.questk2.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ObjectSortingExample {
    public static void main(String[] args) {
    	List<Person> people = new ArrayList<>();
        people.add(new Person("John", 25, "New York"));
        people.add(new Person("Alice", 30, "Los Angeles"));
        people.add(new Person("Bob", 20, "Chicago"));
        people.add(new Person("Charlie", 25, "New York"));
        people.add(new Person("David", 25, "Los Angeles"));

        // 1. Sorting by Name (alphabetically)
        Collections.sort(people, Comparator.comparing(person -> person.getName()));
        System.out.println("Sorted by Name: " + people);
        
        Collections.sort(people, Comparator.comparing(person -> person.getName(), Comparator.nullsFirst(Comparator.nullsLast(null))));

        // 2. Sorting by Age (ascending)
        Collections.sort(people, Comparator.comparingInt(person -> person.getAge()));
        System.out.println("Sorted by Age: " + people);

        // 3. Sorting by City (alphabetically)
        Collections.sort(people, Comparator.comparing(person -> person.getCity()));
        System.out.println("Sorted by City: " + people);

        // 4. Sorting by Age (ascending), then by Name (alphabetically)
        Collections.sort(people, Comparator.comparing((Person p) -> p.getAge()).thenComparing(p -> p.getName()));
        System.out.println("Sorted by Age then Name: " + people);

        // 5. Sorting by Name (alphabetically), then by City (alphabetically)
        Collections.sort(people, Comparator.comparing((Person p) -> p.getName()).thenComparing(p -> p.getCity()));
        System.out.println("Sorted by Name then City: " + people);

        // 6. Sorting by Age (ascending), then by City (alphabetically)
        Collections.sort(people, Comparator.comparingInt((Person p) -> p.getAge()).thenComparing(p -> p.getCity()));
        System.out.println("Sorted by Age then City: " + people);

        // 7. Sorting by Age (descending) and then by Name (ascending)
        Collections.sort(people, Comparator.comparingInt((Person p) -> p.getAge()).reversed().thenComparing(p -> p.getName()));
        System.out.println("Sorted by Age (desc) then Name: " + people);
        
        
    }
}

