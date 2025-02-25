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
     * Employees are re-sorted by name after deletion.
     *
     * @param empId The ID of the employee to be deleted.
     * @param deptName The name of the department from which the employee will be removed.
     * @throws CustomException If the department doesn't exist or no employees are found in the department.
     *                         Also thrown if the employee is not found.
     */
    public void deleteEmployee(Integer empId, String deptName) throws CustomException {
        List<Employee> employees = departmentMap.get(deptName);
        if (employees == null || employees.isEmpty()) {
            throw new CustomException("Department not found or no employees in department");
        }
        boolean removed = employees.removeIf(emp -> emp.getEmpId() == empId);
        if (!removed) {
            throw new CustomException("Employee not found");
        }
        employees.sort(Comparator.comparing(Employee::getEmpName));
        printEmployees(deptName);
    }

    /**
     * Updates an employee's information, including their name and salary.
     * The employee is re-sorted by name after the update.
     *
     * @param empId The ID of the employee to be updated.
     * @param deptName The name of the department the employee belongs to.
     * @param newName The new name for the employee.
     * @param newSalary The new salary for the employee.
     * @throws CustomException If the department is not found or the employee doesn't exist.
     */
    public void updateEmployee(Integer empId, String deptName, String newName, double newSalary) throws CustomException {
        List<Employee> employees = departmentMap.get(deptName);
        if (employees == null || employees.isEmpty()) {
            throw new CustomException("Department not found or no employees in department");
        }
        for (Employee emp : employees) {
            if (emp.getEmpId() == empId) {
                employees.remove(emp);
                employees.add(new Employee(empId, newName, emp.getDepartment(), newSalary, emp.getEmpJoinDate()));
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
     * @throws CustomException If the department is not found or there are no employees in the department.
     */
    public void getEmployeesByJoinDate(String deptName) throws CustomException {
        List<Employee> employees = departmentMap.get(deptName);
        if (employees == null || employees.isEmpty()) {
            throw new CustomException("Department not found or no employees in department");
        }
        employees.stream()
        .sorted(Comparator.comparing(Employee::getEmpJoinDate).reversed())
        .forEach(System.out::println);
 } 

    /**
     * Demonstrates handling a ConcurrentModificationException by modifying a list while iterating over it.
     * Attempts to remove an employee from the list while iterating, which leads to a ConcurrentModificationException.
     */
    public void testConcurrentModification() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Smita", new Department(1, "HR"), 50000, new Date()));
        employees.add(new Employee(2, "Puspa", new Department(1, "HR"), 55000, new Date()));
        try {
            for (Employee emp : employees) {
                if (emp.getEmpId() == 1) {
                    employees.remove(emp); // This will cause ConcurrentModificationException
                }
            }
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
}
