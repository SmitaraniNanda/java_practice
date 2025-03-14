package com.questk2.main;

import java.util.*;

public class Employee {
    private Integer empId;
    private String empName;
    private Department department;
    private Integer salary;
    private Date empJoinDate;

    /**
     * Constructs an Employee object with the specified details.
     *
     * @param empId       The ID of the employee.
     * @param empName     The name of the employee.
     * @param department  The department to which the employee belongs.
     * @param i      The salary of the employee.
     * @param empJoinDate The join date of the employee.
     */
    public Employee(Integer empId, String empName, Department department, Integer salary, Date empJoinDate) {
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
    public Integer getEmpId() {
        return empId;
    }

    /**
     * Sets the ID of the employee.
     *
     * @param empId The new employee ID.
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
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
     * Sets the name of the employee.
     *
     * @param empName The new employee name.
     */
    public void setEmpName(String empName) {
        this.empName = empName;
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
     * Sets the department of the employee.
     *
     * @param department The new department.
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Gets the salary of the employee.
     *
     * @return The employee's salary.
     */
    public Integer getSalary() {
        return salary;
    }

    /**
     * Sets the salary of the employee.
     *
     * @param salary The new salary.
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
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
     * Sets the join date of the employee.
     *
     * @param empJoinDate The new join date.
     */
    public void setEmpJoinDate(Date empJoinDate) {
        this.empJoinDate = empJoinDate;
    }

    /**
     * Returns a string representation of the Employee object, including details
     * like employee ID, name, department name, salary, and join date.
     *
     * @return A string representing the employee's details.
     */
    
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", department=" + (department != null ? department.getDeptName() : "None") +
                ", salary=" + salary +
                ", empJoinDate=" + empJoinDate +
                '}';
    }
}
