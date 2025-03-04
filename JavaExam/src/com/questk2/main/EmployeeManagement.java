package com.questk2.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Main Class
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        
        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();

        for (int emp = 0; emp < n; emp++) {
            try {
                System.out.println("Enter details for Employee " + (emp + 1));
                System.out.print("ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Name: ");
                String name = scanner.nextLine();
                System.out.print("Age: ");
                int age = scanner.nextInt();
                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.print("Department: ");
                String department = scanner.nextLine();

                System.out.print("Is this employee a Manager? (yes/no): ");
                String isManager = scanner.nextLine();

                Employee employee;
                if (isManager.equalsIgnoreCase("yes")) {
                    System.out.print("Enter team size: ");
                    int teamSize = scanner.nextInt();
                    employee = new Manager(id, name, age, salary, department, teamSize);
                } else {
                    employee = new Employee(id, name, age, salary, department);
                }
                
                employees.add(employee);
                departmentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);

            } catch (InvalidAgeException | LowSalaryException e) {
                System.out.println("Error: " + e.getMessage());
               
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter correct values.");
                scanner.next(); // Clear buffer
               
            }
        }

        // Sorting Employees by Salary in Descending Order
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        
        // Displaying Employees
        System.out.println("\nEmployees Sorted by Salary (Descending Order):");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Grouping Employees by Department
        System.out.println("\nEmployees Grouped by Department:");
        for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (Employee emp : entry.getValue()) {
                System.out.println("  " + emp);
            }
        }
    }
}
