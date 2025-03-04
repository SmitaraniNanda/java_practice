package com.questk2.main;

public class Employee {
	    private int id;
	    private String name;
	    private int age;
	    private double salary;
	    private String department;

	    /**
	     * Constructor for Employee class
	     * @param id Employee ID
	     * @param name Employee Name
	     * @param age Employee Age
	     * @param salary Employee Salary
	     * @param department Employee Department
	     * @throws InvalidAgeException if age is below 18
	     * @throws LowSalaryException if salary is below 30,000
	     */
	    public Employee(int id, String name, int age, double salary, String department) throws InvalidAgeException, LowSalaryException {
	        if (age < 18) {
	            throw new InvalidAgeException("Age must be 18 or older.");
	        }
	        if (salary < 30000) {
	            throw new LowSalaryException("Salary must be at least 30,000.");
	        }
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	        this.department = department;
	    }

	    // Getters
	    public int getId() { return id; }
	    public String getName() { return name; }
	    public int getAge() { return age; }
	    public double getSalary() { return salary; }
	    public String getDepartment() { return department; }

	    /**
	     * Sets the age of the employee
	     * @param age New age of the employee
	     * @throws InvalidAgeException if age is below 18
	     */
	    public void setAge(int age) throws InvalidAgeException {
	        if (age < 18) {
	            throw new InvalidAgeException("Age must be 18 or older.");
	        }
	        this.age = age;
	    }

	    /**
	     * Sets the salary of the employee
	     * @param salary New salary of the employee
	     * @throws LowSalaryException if salary is below 30,000
	     */
	    public void setSalary(double salary) throws LowSalaryException {
	        if (salary < 30000) {
	            throw new LowSalaryException("Salary must be at least 30,000.");
	        }
	        this.salary = salary;
	    }

	    // ToString method
	    @Override
	    public String toString() {
	        return "Employee [ID: " + id + ", Name: " + name + ", Age: " + age + ", Salary: " + salary + ", Department: " + department + "]";
	    }
	}