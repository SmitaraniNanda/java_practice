package com.questk2.main;

import java.util.*;

/**
 * The Main class demonstrates the use of a HashMap to manage user sessions.
 * It iterates over the entries, removes an entry based on a key, and updates another entry.
 */
public class Main {
    /**
     * The main method serves as the entry point for the program.
     * It initializes a HashMap with session data, modifies it, and displays the updated sessions.
     * 
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        System.out.println("User Sessions:");

        // Creating a HashMap to store user sessions
        Map<String, CustomSession> map = new HashMap<>();
        map.put("1", new CustomSession("Smita", "Java", "1234"));
        map.put("2", new CustomSession("Puspa", "Python", "1234"));
        map.put("3", new CustomSession("Mamali", "C++", "1234"));
        map.put("4", new CustomSession("Khusi", "Data Structure", "1234"));

        // Using an iterator to traverse the map entries
        Iterator<Map.Entry<String, CustomSession>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, CustomSession> entry = iterator.next();

            // Removing an entry with key "2"
            if (entry.getKey().equals("2")) {
                iterator.remove();
            }

            // Updating an entry with key "3"
            if (entry.getKey().equals("3")) {
                map.put("3", new CustomSession("Raju", "C++", "4321"));
            }
        }

        // Displaying the updated map entries
        for (Map.Entry<String, CustomSession> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }
}
