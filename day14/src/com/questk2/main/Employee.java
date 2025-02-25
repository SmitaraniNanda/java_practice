package com.questk2.main;

import java.util.*;

public class Employee {
    private Integer empId;
    private String empName;
    private Department department;
    private Double salary;
    private Date empJoinDate;

    /**
     * Constructs an Employee object with the specified details.
     * 
     * @param empId The ID of the employee.
     * @param empName The name of the employee.
     * @param department The department to which the employee belongs.
     * @param salary The salary of the employee.
     * @param empJoinDate The join date of the employee.
     */
    public Employee(int empId, String empName, Department department, double salary, Date empJoinDate) {
        this.empId = empId;
        this.empName = empName;
        this.department = department;
        this.salary = salary;
        this.empJoinDate = empJoinDate;
    }

    /**
     * Gets the ID of the employee.
     * 
     * @return The employee ID.
     */
    public int getEmpId() {
        return empId;
    }

    /**
     * Gets the name of the employee.
     * 
     * @return The employee's name.
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * Gets the department to which the employee belongs.
     * 
     * @return The employee's department.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Gets the salary of the employee.
     * 
     * @return The employee's salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Gets the join date of the employee.
     * 
     * @return The employee's join date.
     */
    public Date getEmpJoinDate() {
        return empJoinDate;
    }

    /**
     * Returns a string representation of the Employee object, including details like
     * employee ID, name, department name, salary, and join date.
     * 
     * @return A string representing the employee's details.
     */
    @Override
    public String toString() {
        return "Employee{" + "empId=" + empId + ", empName='" + empName + '\'' + ", department=" + department.getDeptName() + ", salary=" + salary + ", empJoinDate=" + empJoinDate + '}';
    }
}
