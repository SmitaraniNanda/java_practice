package com.questk2.main;

import java.util.Date;

/**
 * The EmployeeManagement class is the entry point for managing employees within a company.
 */
public class EmployeeManagement {
    /**
     * The main method demonstrates various employee management operations.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Company company = new Company();
        Department hr = new Department(1, "HR");
        Department it = new Department(2, "IT");

        try {
            // Adding employees to the company
            company.addEmployee(new Employee(1, "Smita", hr, 50000, new Date()));
            company.addEmployee(new Employee(2, "Puspa", hr, 55000, new Date()));
            company.addEmployee(new Employee(3, "Mamali", it, 60000, new Date()));

            // Retrieving employees by department (sorted by join date)
            System.out.println("\nEmployees in HR sorted by join date:");
            company.getEmployeesByJoinDate("HR");

            // Updating an employee's details
            System.out.println("\nUpdating Smita's name to Sita and salary to 52000:");
            company.updateEmployee(1, "HR", "Sita", 52000);

            // Deleting an employee from the company
            System.out.println("\nDeleting Puspa from HR:");
            company.deleteEmployee(2, "HR");

            // Testing concurrent modification handling
            company.testConcurrentModification();
        } catch (CustomException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
