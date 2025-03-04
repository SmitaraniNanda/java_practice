package com.questk2.main;

	import java.util.*;

	public class EmployeeManagement {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        List<Employee> employees = new ArrayList<>();
	        Map<String, List<Employee>> departmentMap = new HashMap<>();

	        System.out.print("Enter the number of employees: ");
	        Integer n = scanner.nextInt();
	        scanner.nextLine();

	        for (Integer emp = 0; emp < n; emp++) {
	            try {
	                System.out.println("\nEnter details for Employee " + ": ");
	                System.out.print("Enter ID: ");
	                Integer id = scanner.nextInt();
	                scanner.nextLine();
	                
	                System.out.print("Enter Name: ");
	                String name = scanner.nextLine();

	                System.out.print("Enter Age: ");
	                Integer age = scanner.nextInt();

	                System.out.print("Enter Salary: ");
	                Double salary = scanner.nextDouble();
	                scanner.nextLine();

	                System.out.print("Enter Department: ");
	                String department = scanner.nextLine();

	                System.out.print("Is this employee a Manager? (yes/no): ");
	                String isManager = scanner.nextLine();

	                Employee employee;
	                if (isManager.equalsIgnoreCase("yes")) {
	                    System.out.print("Enter Team Size: ");
	                    int teamSize = scanner.nextInt();
	                    scanner.nextLine();
	                    employee = new Manager(id, name, age, salary, department, teamSize);
	                } else {
	                    employee = new Employee(id, name, age, salary, department);
	                }

	                employees.add(employee);
	                departmentMap.computeIfAbsent(department, k -> new ArrayList<>()).add(employee);
	            } catch (InvalidAgeException | LowSalaryException e) {
	                System.out.println("Error: " + e.getMessage() + " Please re-enter details.");
	                emp--;
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter the correct format.");
	                scanner.nextLine();
	                emp--;
	            }
	        }

	        // Sorting employees by salary in descending order
	        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

	        // Display sorted employees
	        System.out.println("\nEmployees sorted by salary (Descending Order):");
	        for (Employee e : employees) {
	            System.out.println(e);
	        }
	        
	        scanner.close();
	    }
	

}
