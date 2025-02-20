package com.questk2.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortExample {
public static void main(String[] args) {
	 List<String> fruits = new ArrayList<>();
     fruits.add("Banana");
     fruits.add("Apple");
     fruits.add("Orange");

     // Sorting the list in natural (ascending) order
     Collections.sort(fruits);

     // Displaying the sorted list
     System.out.println("Sorted List (Natural Order): " + fruits);
     
     
  // Sorting the list in reverse (descending) order
     Collections.sort(fruits, Collections.reverseOrder());

     // Displaying the sorted list
     System.out.println("Sorted List (Reverse Order): " + fruits);
     
     
  // Sorting the list by the length of the strings
     Collections.sort(fruits, Comparator.comparingInt(String::length));

     // Displaying the sorted list
     System.out.println("Sorted List (By Length): " + fruits);
     
     
  // Sorting the list using a custom comparator (case-insensitive)
     Collections.sort(fruits, String.CASE_INSENSITIVE_ORDER);

     // Displaying the sorted list
     System.out.println("Sorted List (Case-Insensitive): " + fruits);
     
     
  // Sorting by length first, and then alphabetically
     Collections.sort(fruits, Comparator.comparingInt(String::length)
                                       .thenComparing(String::compareTo));

     // Displaying the sorted list
     System.out.println("Sorted List (Length then Alphabetical): " + fruits);
}
}
