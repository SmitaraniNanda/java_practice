package com.questk2.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// Main Class
public class EmployeeManagement {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();
		Map<String, List<Employee>> departmentMap = new HashMap<>();

		System.out.print("Enter number of employees: ");
		Integer number = scanner.nextInt();

		for (Integer emp = 0; emp < number; emp++) {
			try {
				System.out.println("Enter details for Employee ");
				System.out.print("ID: ");
				Integer id = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				System.out.print("Name: ");
				String name = scanner.nextLine();
				System.out.print("Age: ");
				Integer age = scanner.nextInt();
				System.out.print("Salary: ");
				Double salary = scanner.nextDouble();
				scanner.nextLine(); // Consume newline
				System.out.print("Department: ");
				String department = scanner.nextLine();

				System.out.print("Is this employee a Manager? (yes/no): ");
				String isManager = scanner.nextLine();

				Employee employee;
				if (isManager.equalsIgnoreCase("yes")) {
					System.out.print("Enter team size: ");
					Integer teamSize = scanner.nextInt();
					scanner.nextLine(); // Consume the newline after nextInt()
					employee = new Manager(id, name, age, salary, department, teamSize);
				} else {
					employee = new Employee(id, name, age, salary, department);
				}

				employees.add(employee);
				if (!departmentMap.containsKey(department)) {
					departmentMap.put(department, new ArrayList<Employee>());
				}
				departmentMap.get(department).add(employee);

			} catch (InvalidAgeException | LowSalaryException e) {
				System.out.println("Error: " + e.getMessage());

			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter correct values.");

			}
		}

		// Sorting Employees by Salary in Descending Order
		Collections.sort(employees, new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return Double.compare(e2.getSalary(), e1.getSalary());
			}
		});

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
