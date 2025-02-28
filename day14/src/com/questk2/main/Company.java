package com.questk2.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Company {
    private Map<String, List<Employee>> departmentMap = new HashMap<>();

    /**
     * Adds an employee to the corresponding department, ensuring no duplicates.
     * The employee is added to the department and sorted by their name.
     *
     * @param employee The employee to be added.
     * @throws CustomException If the employee already exists in the department.
     */
    public void addEmployee(Employee employee) throws CustomException {
        departmentMap.putIfAbsent(employee.getDepartment().getDeptName(), new ArrayList<>());
        List<Employee> employees = departmentMap.get(employee.getDepartment().getDeptName());
        if (employees.contains(employee)) {
            throw new CustomException("Employee already exists in the department");
        }
        employees.add(employee);
        employees.sort(Comparator.comparing(Employee::getEmpName));
        printEmployees(employee.getDepartment().getDeptName());
    }

    /**
     * Deletes an employee from the specified department based on employee ID.
     *
     * @param empId    The ID of the employee to be deleted.
     * @param deptName The name of the department from which the employee will be removed.
     * @throws CustomException If the department or employee is not found.
     */
    public void deleteEmployee(Integer empId, String deptName) throws CustomException {
        List<Employee> employees = departmentMap.get(deptName);
        if (employees == null || employees.isEmpty()) {
            throw new CustomException("Department not found or no employees in department");
        }

        boolean removed = employees.removeIf(emp -> emp.getEmpId().equals(empId));
        if (!removed) {
            throw new CustomException("Employee not found");
        }

        employees.sort(Comparator.comparing(Employee::getEmpName));
        printEmployees(deptName);
    }

    /**
     * Updates an employee's information, including their name and salary.
     *
     * @param empId     The ID of the employee to be updated.
     * @param deptName  The name of the department the employee belongs to.
     * @param newName   The new name for the employee.
     * @param newSalary The new salary for the employee.
     * @throws CustomException If the department or employee is not found.
     */
    public void updateEmployee(Integer empId, String deptName, String newName, Integer newSalary) throws CustomException {
        List<Employee> employees = departmentMap.get(deptName);
        if (employees == null || employees.isEmpty()) {
            throw new CustomException("Department not found or no employees in department");
        }

        for (Employee emp : employees) {
            if (emp.getEmpId().equals(empId)) {
                emp.setEmpName(newName);
                emp.setSalary(newSalary);
                employees.sort(Comparator.comparing(Employee::getEmpName));
                printEmployees(deptName);
                return;
            }
        }
        throw new CustomException("Employee not found");
    }

    /**
     * Retrieves and prints all employees in a department, sorted by their join date.
     *
     * @param deptName The name of the department whose employees should be retrieved.
     * @throws CustomException If the department is not found or has no employees.
     */
    public void getEmployeesByJoinDate(String deptName) throws CustomException {
        List<Employee> employees = departmentMap.get(deptName);
        if (employees == null || employees.isEmpty()) {
            throw new CustomException("Department not found or no employees in department");
        }

        employees.stream()
                .sorted(Comparator.comparing(Employee::getEmpJoinDate))
                .forEach(System.out::println);
    }

    /**
     * Demonstrates handling a ConcurrentModificationException by modifying a list while iterating over it.
     */
    public void testConcurrentModification() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Smita", new Department(1, "HR"), 50000, new Date()));
        employees.add(new Employee(2, "Puspa", new Department(1, "HR"), 55000, new Date()));

        try {
            employees.removeIf(emp -> emp.getEmpId().equals(1)); // Safe removal
        } catch (ConcurrentModificationException e) {
            System.out.println("Concurrent modification detected! Handling the exception...");
        }
    }

    /**
     * Prints the list of employees in the specified department, sorted by their name.
     *
     * @param deptName The name of the department whose employees are to be printed.
     */
    private void printEmployees(String deptName) {
        System.out.println("Employees in " + deptName + " sorted by name:");
        departmentMap.get(deptName).forEach(System.out::println);
    }
    
    /**
     * Sorts the employees in the specified department by name, then by salary (if names are the same), 
     * and finally by their joining date (if both name and salary are the same). 
     * The sorted employee list is then printed to the console.
     *
     * @param deptName The name of the department whose employees need to be sorted.
     */
    public void sortEmployees(String deptName) {
        // Get the list of employees in the given department
        List<Employee> employeesInDepartment = departmentMap.get(deptName);

        if (employeesInDepartment != null) {
            employeesInDepartment.sort(Comparator.comparing(Employee::getEmpName) // First sort by name
                    .thenComparing(Employee::getSalary) // If names are the same, sort by salary
                    .thenComparing(Employee::getEmpJoinDate) // If both name and salary are the same, sort by join date
            );

            // Print the sorted list of employees
            System.out.println("\nEmployees in " + deptName + " department:");
            for (Employee emp : employeesInDepartment) {
                System.out.println(emp);
            }
        } else {
            System.out.println("Department not found: " + deptName);
        }
    }

}
