package com.questk2.main;


//Manager Class (Subclass of Employee)
class Manager extends Employee {
 private int teamSize;

 /**
  * Constructor for Manager class
  * @param id Employee ID
  * @param name Employee Name
  * @param age Employee Age
  * @param salary Employee Salary
  * @param department Employee Department
  * @param teamSize Size of the team managed
  * @throws InvalidAgeException if age is below 18
  * @throws LowSalaryException if salary is below 30,000
  */
 public Manager(int id, String name, int age, double salary, String department, int teamSize) throws InvalidAgeException, LowSalaryException {
     super(id, name, age, salary, department);
     this.teamSize = teamSize;
 }

 public int getTeamSize() { return teamSize; }
 public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

 @Override
 public String toString() {
     return super.toString() + ", Team Size: " + teamSize;
 }
}