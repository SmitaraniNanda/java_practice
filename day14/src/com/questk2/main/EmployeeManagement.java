package com.questk2.main;

import java.util.Date;

/**
 * The EmployeeManagement class is the entry point for managing employees within a company.
 * It provides adding, updating, deleting, and retrieving employees within different departments.
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

            // Retrieving employees by department
            company.getEmployeesByJoinDate("HR");

            // Updating an employee's details
            company.updateEmployee(1, "HR", "Sita", 52000);

            // Deleting an employee from the company
            company.deleteEmployee(2, "HR");

            // Testing concurrent modification handling
            company.testConcurrentModification();
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}
