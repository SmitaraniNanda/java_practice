package com.questk2.main;

public class Employee {
	    protected Integer id;
	    protected String name;
	    protected Integer age;
	    protected Double salary;
	    protected String department;

	    public Employee(Integer id, String name, Integer age, Double salary, String department) throws InvalidAgeException, LowSalaryException {
	        if (age < 18) {
	            throw new InvalidAgeException("Age must be at least 18.");
	        }
	        if (salary < 30000) {
	            throw new LowSalaryException("Salary must be at least 30000.");
	        }
	        this.id = id;
	        this.name = name;
	        this.age = age;
	        this.salary = salary;
	        this.department = department;
	    }

	    public Integer getId() { 
	    	return id; 
	    	}
	    public String getName() {
	    	return name;
	    	}
	    public Integer getAge() { 
	    	return age;
	    	}
	    public Double getSalary() { 
	    	return salary;
	    	}
	    public String getDepartment() { 
	    	return department; 
	    	}

	    public void setSalary(Double salary) throws LowSalaryException {
	        if (salary < 30000) {
	            throw new LowSalaryException("Salary must be at least 30000.");
	        }
	        this.salary = salary;
	    }

	    @Override
	    public String toString() {
	        return "Employee [ID=" + id + ", Name=" + name + ", Age=" + age + ", Salary=" + salary + ", Department=" + department + "]";
	    }
	
 
}
